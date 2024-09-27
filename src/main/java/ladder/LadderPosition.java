package ladder;

import static ladder.ExceptionMessage.INVALID_LADDER_POSITION;

public class LadderPosition {
    private int x,y;
    public LadderPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public static LadderPosition of(int x, int y) {
        validatePosition(x, y);
        return new LadderPosition(x,y);
    }

    private static void validatePosition(int x, int y) {
        if (!isPosition(x, y)) {
            throw new IllegalArgumentException(INVALID_LADDER_POSITION.getMessage());
        }
    }

    private static boolean isPosition(int x, int y) {
        return x>=0 && y>=0;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }


    public void moveDown() {
        this.y++;
    }

    // x 좌표가 입력된 값보다 작은지 확인
    public boolean isSmallerThan(int x) {
        return this.x < x;
    }

    // x 좌표가 입력된 값보다 큰지 확인
    public boolean isBiggerThan(int x) {
        return this.x > x;
    }

    public boolean isCurrentPosition(int x, int y) {
        return this.x == x && this.y == y;
    }


    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
