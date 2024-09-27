package ladder;

import java.util.ArrayList;
import java.util.List;

public class Row {

    private final Node[] nodes;

    public Row(int numberOfPerson) {
        nodes = new Node[numberOfPerson];
        for (int i = 0; i < numberOfPerson; i++) {
            nodes[i] = Node.from(Direction.NONE);
        }
    }

    public int getNumberOfNodes() {
        return nodes.length;
    }

    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);

        setDirectionBetweenNextPosition(startPosition);
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

    private void validateDrawLinePosition(Position startPosition) {
        validatePosition(startPosition);
        if (isLineAtPosition(startPosition) || isLineAtNextPosition(startPosition)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }
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

    public String toString(Position position, boolean isCurrentRow) {

        List<String> nodeStrings = new ArrayList<>();

        for (int i = 0; i < nodes.length; i++) {
            if (isCurrentRow && i == position.getValue()) {
                // 현재 위치에만 * 표시
                if (nodes[i].getDirection() == Direction.RIGHT) {
                    nodeStrings.add("1*");
                } else if (nodes[i].getDirection() == Direction.LEFT) {
                    nodeStrings.add("-1*");
                } else {
                    nodeStrings.add("0*");
                }
            } else {
                // 나머지 열은 * 없이 출력
                if (nodes[i].getDirection() == Direction.RIGHT) {
                    nodeStrings.add("1");
                } else if (nodes[i].getDirection() == Direction.LEFT) {
                    nodeStrings.add("-1");
                } else {
                    nodeStrings.add("0");
                }
            }
        }
        return String.join(" ", nodeStrings);
    }
}