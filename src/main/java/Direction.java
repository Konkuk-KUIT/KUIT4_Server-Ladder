public enum Direction {
    LEFT(-1), NONE(0), RIGHT(1);

    private final int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }


}
