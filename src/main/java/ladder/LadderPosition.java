package ladder;

public class LadderPosition {

    private Position x;
    private Position y;

    public LadderPosition(Position x, Position y) {
        this.x = x;
        this.y = y;
    }

    public LadderPosition(int x, int y) {
        this.x = Position.from(x);
        this.y = Position.from(y);
    }

    public Position getX() {
        return x;
    }

    public Position getY() {
        return y;
    }

    public int getValueX() {
        return x.getValue();
    }

    public int getValueY() {
        return y.getValue();
    }

    public Boolean isNthRow(int n) {
        return x.getValue() == n;
    }

    public Boolean isNthNode(int n) {
        return y.getValue() == n;
    }

    public void goLeft() {
        y.prev();
    }

    public void goRight() {
        y.next();
    }

    public void goDown() {
        x.next();
    }
}
