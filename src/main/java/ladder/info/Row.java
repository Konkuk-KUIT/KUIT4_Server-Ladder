package ladder.info;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.exception.ExceptionMessage;

import static ladder.Direction.*;

public class Row {
    private final Node[] nodes;

    public Row(GreaterThanOne col) {
        nodes = new Node[col.getNumber()];
        for (int i = 0; i < col.getNumber(); i++) {
            nodes[i] = Node.from(NONE);
        }
    }

    public void drawLine(Position position) {
        validateDrawLinePosition(position);
        setDirectionBetweenNextPosition(position);
    }

    public void moveRow(Position position) {
        position.UpdateRow();
    }

    public void nextPosition(Position position) {
        validatePosition(position);
        nodes[position.getCol()].move(position);
    }

    private void setDirectionBetweenNextPosition(Position position) {
        nodes[position.getCol()].setRightNode();
        position.next();
        nodes[position.getCol()].setLeftNode();
    }

    private void validatePosition(Position position) {
        if (isInvalidPosition(position) ) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    private void validateDrawLinePosition(Position position) {
        validatePosition(position);
        if (isLineAtPosition(position) || isLineAtNextPosition(position)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isInvalidPosition(Position position) {
        return position.isBiggerThan(nodes.length - 1) ;
    }

    private boolean isLineAtPosition(Position position) {
        return nodes[position.getCol()].isAlreadySetDirection();
    }

    private boolean isLineAtNextPosition(Position position) {
        position.next();
        boolean lineAtPosition = isLineAtPosition(position);
        position.prev();
        return lineAtPosition;
    }

    public Node[] getNodes() {
        return nodes;
    }

}