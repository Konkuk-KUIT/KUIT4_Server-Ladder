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

    public boolean canDrawLineAt(int col) {
        if (col < 0 || col >= nodes.length - 1) {
            return false;
        }
        return nodes[col].isNone() && nodes[col + 1].isNone();
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

    public void nextPosition(Position position) {
        validatePosition(position);

        nodes[position.getPosition()].move(position);
    }

    public String printRow(Position position, boolean isCurrentRow) {
        StringBuilder rowBuilder = new StringBuilder();

        for (int i = 0; i < nodes.length; i++) {
            rowBuilder.append(getNodeIndex(i))
                    .append((isCurrentRow && i == position.getPosition()) ? "*" : "")
                    .append(i < nodes.length - 1 ? " " : "");
        }
        return rowBuilder.toString();
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
        boolean IsLineAtPosition = !nodes[startPosition.getPosition()].isAlreadySetDirection();
        startPosition.prev();
        return IsLineAtPosition;
    }

    private String getNodeIndex(int index) {
        switch (nodes[index].getDirection()) {
            case RIGHT:
                return "1";
            case LEFT:
                return "-1";
            case NONE:
            default:
                return "0";
        }
    }
}