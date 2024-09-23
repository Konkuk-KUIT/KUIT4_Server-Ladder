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

    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);

        setDirectionBetweenNextPosition(startPosition);
    }

    public void nextPosition(Position position) {
        validatePosition(position);
        nodes[position.getX()].moveRow(position);
    }

    private void setDirectionBetweenNextPosition(Position position) {
        nodes[position.getX()].setRightNode();
        position.nextX();
        nodes[position.getX()].setLeftNode();
    }

    private void validatePosition(Position position) {
        if (isInvalidPosition(position) ) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    private void validateDrawLinePosition(Position startPosition) {
        validatePosition(startPosition);
        if (isLineAtPosition(startPosition) || isLineAtNextPosition(startPosition)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isInvalidPosition(Position position) {
        return position.xIsBiggerThan(nodes.length - 1) ;
    }

    private boolean isLineAtPosition(Position position) {
        return nodes[position.getX()].isAlreadySetDirection();
    }

    private boolean isLineAtNextPosition(Position position) {
        position.nextX();
        boolean lineAtPosition = isLineAtPosition(position);
        position.prevX();
        return lineAtPosition;
    }

    public Node[] getNodes() {
        return nodes;
    }
}