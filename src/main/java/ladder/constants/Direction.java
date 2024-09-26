package ladder.constants;

public enum Direction {
    LEFT(-1) , RIGHT(1);

    private int value;

    private Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
