package ladder;

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

    public void moveDown() {
        y++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
