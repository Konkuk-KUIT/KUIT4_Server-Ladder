package ladder;

import static ladder.ExceptionMessage.INVALID_LADDER_POSITION;

public class LadderPosition {
    private int x, y;

    public LadderPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static LadderPosition of(int x, int y) {
        validatePosition(x, y);
        return new LadderPosition(x, y);
    }
    private static void validatePosition(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_POSITION.getMessage());
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isCurrentPosition(int x, int y) {
        return this.x == x && this.y == y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
