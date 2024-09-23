package ladder;

import static ladder.ExceptionMessage.INVALID_LADDER_POSITION;

public class Position {

    private int x;
    private int y;

    private Position(int x) {
        this.x = x;
    }

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }


    public static Position from(int position) {
        validatePosition(position);
        return new Position(position);
    }

    public static Position of(int x, int y) {
        return new Position(x,y);
    }

    public void prevX() {
        x--;
    }

    public void nextX() {
        x++;
    }

    public boolean xIsSmallerThan(int x) {
        return this.x < x;
    }

    public boolean xIsBiggerThan(int x) {
        return this.x > x;
    }

    public boolean isCorrectPosition(int x, int y) {
        return this.x == x && this.y == y;
    }

    private static void validatePosition(int position) {
        if (!isPosition(position)) {
            throw new IllegalArgumentException(INVALID_LADDER_POSITION.getMessage());
        }
    }

    private static boolean isPosition(int position) {
        return position >= 0;
    }
}
