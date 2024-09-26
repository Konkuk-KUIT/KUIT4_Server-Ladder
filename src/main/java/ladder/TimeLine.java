package ladder;

public enum TimeLine {

    BEFORE("Before"), AFTER("After");

    private final String value;

    TimeLine(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
