package ladder;

import static ladder.Direction.*;

public class Row {
    private final Node[] nodes;

    public Row(GreaterThanOne numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()];
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            nodes[i] = Node.from(NONE);
        }
    }

    public Node[] getNodes(){
        return nodes;
    }
    public void drawLine(LadderPosition position) {
        validateDrawLinePosition(position);
        setDirectionBetweenNextPosition(position); //현위치에 가로선
    }

    public void nextPosition(LadderPosition position) {
        validatePosition(position);
        nodes[position.getX()].move(position);
    }



    private void setDirectionBetweenNextPosition(LadderPosition position) {
        nodes[position.getX()].setRightNode();
        position.moveRight();
        nodes[position.getX()].setLeftNode();
    }

    private void validatePosition(LadderPosition position) {
        if (isInvalidPosition(position) ) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    private void validateDrawLinePosition(LadderPosition startPosition) {
        validatePosition(startPosition);
        if (isLineAtPosition(startPosition) || isLineAtNextPosition(startPosition)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isInvalidPosition(LadderPosition position) {
        return position.isBiggerThan(nodes.length - 1) ;
    }

    private boolean isLineAtPosition(LadderPosition position) {
        return nodes[position.getX()].isAlreadySetDirection();
    }

    private boolean isLineAtNextPosition(LadderPosition position) {
        position.moveRight();
        boolean lineAtPosition = isLineAtPosition(position);
        position.moveLeft();
        return lineAtPosition;
    }

}