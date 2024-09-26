package ladder;

import ladder.constants.Direction;
import ladder.constants.ExceptionMessage;
import ladder.constants.nodeState;
import ladder.wrapper.ArrayIndex;
import ladder.wrapper.unsignedInt;

public class Row {
    private Node[] nodes;

    public Row(int column) {
        nodes = new Node[column];
        for (int i = 0; i < column; i++) {
            nodes[i] = Node.from(nodeState.empty);
        }
    }

    public int LineLength() {
        return nodes.length;
    }

    public nodeState currentState(int index) {
        return nodes[index].getState();
    }

    public void drawLineAt(unsignedInt position, Direction direction) {
        vaildateLine(position, direction);

        if (isLineToLeft(direction)) {
            drawLeftLine(position);
        }

        if (isLineToRight(direction)) {
            drawRightLine(position);
        }
    }

    private void vaildateLine(unsignedInt position, Direction direction) {

        if(position.getValue() < 0 || position.getValue() >= LineLength()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }

        int lineEndingAt = position.getValue() + direction.getValue();
        if(lineEndingAt < 0 || lineEndingAt >= LineLength()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }

        if((nodes[position.getValue()].getState() != nodeState.empty) || (nodes[lineEndingAt].getState() != nodeState.empty)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }


    private static boolean isLineToLeft(Direction direction) {
        return direction == Direction.LEFT;
    }

    private static boolean isLineToRight(Direction direction) {
        return direction == Direction.RIGHT;
    }

    private void drawLeftLine(unsignedInt position) {
        nodes[position.getValue()].setLine(nodeState.RIGHT);
        nodes[position.getValue() - 1].setLine(nodeState.LEFT);
    }

    private void drawRightLine(unsignedInt position) {
        nodes[position.getValue()].setLine(nodeState.LEFT);
        nodes[position.getValue() + 1].setLine(nodeState.RIGHT);
    }

    public boolean hasRightLine(ArrayIndex currentLadderIndex){
        if(currentLadderIndex.getIndex() == (nodes.length - 1)){
            return false;
        } else {
            return currentState(currentLadderIndex.getIndex()+1) == nodeState.RIGHT;
        }
    }

    public boolean hasLeftLine(ArrayIndex currentLadderIndex){
        if(currentLadderIndex.getIndex() == 0){
            return false;
        } else {
            return currentState(currentLadderIndex.getIndex()-1) == nodeState.LEFT;
        }
    }

}
