package ladder;

import static ladder.Direction.*;

public class Node {

    private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }

    public static Node from(Direction direction) {
        return new Node(direction);
    }

    public void move(LadderPosition ladderPosition) {
        if (isRight()) {
            ladderPosition.goRight();
            return;
        }
        if (isLeft()) {
            ladderPosition.goLeft();
            return;
        }
    }

    public void setRightNode() {
        direction = RIGHT;
    }

    public void setLeftNode() {
        direction = LEFT;
    }

    public boolean isAlreadySetDirection() {
        return !isNone();
    }

    private boolean isRight() {
        return direction == RIGHT;
    }

    private boolean isLeft() {
        return direction == LEFT;
    }

    private boolean isNone() {
        return direction == NONE;
    }

    @Override
    public String toString() {
        return Integer.toString(direction.getValue());
    }
}
