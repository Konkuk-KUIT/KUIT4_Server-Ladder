package ladder;

import static ladder.Direction.*;

public class Row {

    Node[] nodes;


    public Row(GreaterThanOne numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()];

        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            nodes[i] = Node.from(NONE);
        }
    }

    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);
        setDirectionBetweenNextPosition(startPosition);
    }

    private void setDirectionBetweenNextPosition(Position position) {
        nodes[position.getPosition()].setRightNode(position);
        position.next();
        nodes[position.getPosition()].setLeftNode(position);
    }

    //    자신의 상태가 무엇인지에 따라서 다음 좌표를 계산하고 반환을 함
    public void nextPosition(Position position) {
        validatePosition(position);

        nodes[position.getPosition()].move(position);
    }

    private void validatePosition(Position position) {
        if (position.isBiggerThan(nodes.length - 1)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    private void validateDrawLinePosition(Position startPosition) {
        if (isInvalidPosition(startPosition) || isLineAtPosition(startPosition) || isLineAtNextPosition(startPosition)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isInvalidPosition(Position startPosition) {
        return startPosition.isBiggerThan(nodes.length - 1);
    }

    private boolean isLineAtPosition(Position startPosition) {
        return nodes[startPosition.getPosition()].isAlreadySetDirection();
    }

    private boolean isLineAtNextPosition(Position startPosition) {
        startPosition.next();
        boolean isLineAtPosition = nodes[startPosition.getPosition()].isAlreadySetDirection();
        startPosition.prev();
        return isLineAtPosition;
    }


    // 한 행을 출력하는 메서드 (별 표시 없이)
    public void printRow() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodes.length; i++) {
            sb.append(nodes[i].getDirectionValue()).append(" ");
        }
        System.out.println(sb);
    }

    // 사용자 위치에 *를 표시하여 한 행을 출력하는 메서드
    public void printUserRow(Position position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodes.length; i++) {
            if (i == position.getPosition()) {
                sb.append(nodes[i].getDirectionValue()).append("* ");
            } else {
                sb.append(nodes[i].getDirectionValue()).append(" ");
            }
        }
        System.out.println(sb);
    }
}