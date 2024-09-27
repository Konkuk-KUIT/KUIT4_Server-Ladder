package ladder;

import static ladder.Direction.*;

public class Node {

    private Direction direction;
    public Node() {
        this.direction = Direction.NONE;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public void move(LadderPosition position) {
        switch (direction) {
            case RIGHT:
                position.setX(position.getX() + 1);
                break;
            case LEFT:
                position.setX(position.getX() - 1);
                break;
            default:
                break;
        }
    }
    public String toString() {
        return direction == Direction.NONE ? "0 " : (direction == Direction.RIGHT ? "1 " : "-1 ");
    }
    public boolean isAlreadySetDirection() {
        return direction != Direction.NONE;
    }

}
