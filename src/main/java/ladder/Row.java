package ladder;

import ladder.constants.Direction;
import ladder.constants.nodeState;
import ladder.wrapper.ArrayIndex;

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

    public void drawLineAt(int position, Direction direction) {

        if (isLineToLeft(direction)) {
            drawLeftLine(position);
        }

        if (isLineToRight(direction)) {
            drawRightLine(position);
        }
    }

    private static boolean isLineToLeft(Direction direction) {
        return direction == Direction.LEFT;
    }

    private static boolean isLineToRight(Direction direction) {
        return direction == Direction.RIGHT;
    }

    private void drawLeftLine(int position) {
        nodes[position].setLine(nodeState.LEFT);
        nodes[position - 1].setLine(nodeState.RIGHT);
    }

    private void drawRightLine(int position) {
        nodes[position].setLine(nodeState.LEFT);
        nodes[position + 1].setLine(nodeState.RIGHT);
    }

    public boolean hasRightLine(ArrayIndex currentLadderIndex){
        if(currentLadderIndex.getIndex() == nodes.length){
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
