package ladder.enumclass;

public enum State {
    BEFORE("before"),
    AFTER("after");

    private final String state;

    State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
