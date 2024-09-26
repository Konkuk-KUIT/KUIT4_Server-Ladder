package ladder.constants;

public enum nodeState {

    LEFT("L"), RIGHT("R") ,empty("0");

    private String state;

    nodeState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

}
