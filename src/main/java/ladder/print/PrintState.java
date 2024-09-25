package ladder.print;

public enum PrintState {

    BEFORE("Before"), AFTER("After");

    private final String state;

    PrintState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
