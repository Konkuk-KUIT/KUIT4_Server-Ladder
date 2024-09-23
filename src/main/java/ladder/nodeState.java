package ladder;

public enum nodeState {

    hasLine(1), empty(0);

    private int state;

    nodeState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

}
