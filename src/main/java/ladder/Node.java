package ladder;

public class Node {

    private nodeState state;

    private Node(nodeState state) {
        this.state = state;
    }

    public static Node from(nodeState state){
        return new Node(state);
    }

    public void setLine(nodeState state){
        this.state = state;
    }

    public nodeState getState() {
        return state;
    }

}
