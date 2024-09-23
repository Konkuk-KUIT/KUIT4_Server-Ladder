package ladder;

public enum nodeState {

    LEFT("L"), RIGHT("R") ,empty("0");

    private String state;

    nodeState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public boolean hasLine(){
        if(state.equals("L") || state.equals("R")) {
            return true;
        } else {
            return false;
        }
    }
}
