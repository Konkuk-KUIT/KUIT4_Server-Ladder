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

    //    사다리 가로줄을 그을 때 해당 좌표에는 1을 넣고 오른쪽 값은 -1을 해줘서
//    입력한 좌표의 오른쪽에 라인이 생기게끔 만듦
//    이런식으로 상수가 하드코딩이 돼있는건 좋지 않음
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
        return !nodes[startPosition.getPosition()].isAlreadySetDirection();
    }

    private boolean isLineAtNextPosition(Position startPosition) {
        startPosition.next();
        boolean isLineAtPosition = !nodes[startPosition.getPosition()].isAlreadySetDirection();
        startPosition.prev();
        return isLineAtPosition;
    }
}