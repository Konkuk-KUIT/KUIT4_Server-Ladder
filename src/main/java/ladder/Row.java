package ladder;

class Row {
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

    public nodeState rightSideOfCurrentState(int index) {
        return currentState(index+1);
    }

    public nodeState leftSideOfCurrentState(int index) {
        return currentState(index-1);
    }

    public void drawLineAt(int position, Direction direction) {

        nodes[position].setLine();

        if (direction == Direction.LEFT) {
            nodes[position - 1].setLine();
        }

        if (direction == Direction.RIGHT) {
            nodes[position + 1].setLine();
        }
    }

}
