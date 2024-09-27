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

    public StringBuilder rowToString(int position, boolean currentRow) {
        StringBuilder rowString = new StringBuilder();
        for (int i = 0; i < nodes.length; i++) {
            rowString.append(String.valueOf(nodes[i].getDirection().getValue()));
            if(i == position && currentRow)
                rowString.append("*");
            rowString.append(" ");
        }
        return rowString;
    }

    public boolean drawLine(Position startPosition) {
        boolean validLine = validateDrawLinePosition(startPosition);

        setDirectionBetweenNextPosition(startPosition);
        return validLine;
    }

    public void nextPosition(Position position) {
        validatePosition(position);

        nodes[position.getValue()].move(position);
    }

    private void setDirectionBetweenNextPosition(Position position) {
        nodes[position.getValue()].setRightNode();
        position.next();
        nodes[position.getValue()].setLeftNode();
    }

    private void validatePosition(Position position) {
        if (isInvalidPosition(position) ) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    private boolean validateDrawLinePosition(Position startPosition) {
        validatePosition(startPosition);
        // throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        return !isLineAtPosition(startPosition) && !isLineAtNextPosition(startPosition);
    }

    private boolean isInvalidPosition(Position position) {
        return position.isBiggerThan(nodes.length - 1) ;
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