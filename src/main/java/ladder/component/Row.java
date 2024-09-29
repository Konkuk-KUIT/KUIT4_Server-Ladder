package ladder.component;

import ladder.constant.ExceptionMessage;

import static ladder.constant.Direction.*;

public class Row {
    private final Node[] nodes;

    public Row(GreaterThanOne numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()];
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            nodes[i] = Node.from(NONE);
        }
    }

    public Node[] getNodes() {
        return this.nodes;
    }

    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);

        setDirectionBetweenNextPosition(startPosition);
    }

    public void nextPosition(Position position) {
        validatePosition(position);

        nodes[position.getValue()].move(position);
    }


    // 별표를 추가한 행 출력
    public StringBuilder printAsteroidLine(Position col) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nodes.length; i++) {
            if (i == col.getValue()) {
                nodes[i].appendNodeValue(sb);
                sb.append("* ");
                continue;
            }

            nodes[i].appendNodeValue(sb);
            sb.append(" ");
        }

        return sb;
    }

    // 별표를 추가하지 않는 행 출력
    public StringBuilder printNormalLine() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nodes.length; i++) {
            nodes[i].appendNodeValue(sb);
            sb.append(" ");
        }

        return sb;
    }


    private void setDirectionBetweenNextPosition(Position position) {
        nodes[position.getValue()].setRightNode();
        position.next();
        nodes[position.getValue()].setLeftNode();
    }

    private void validatePosition(Position position) {
        if (isInvalidPosition(position)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }


    // AutoLadderCreator에서도 메소드를 가져다 사용할 것이라서 public으로 변경
    public void validateDrawLinePosition(Position startPosition) {
        validatePosition(startPosition);
        if (isLineAtPosition(startPosition) || isLineAtNextPosition(startPosition)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isInvalidPosition(Position position) {
        return position.isBiggerThan(nodes.length - 1);
    }

    private boolean isLineAtPosition(Position position) {
        return nodes[position.getValue()].isAlreadySetDirection();
    }

    private boolean isLineAtNextPosition(Position position) {
        position.next();
        boolean lineAtPosition = isLineAtPosition(position);
        position.prev();
        return lineAtPosition;
    }

}