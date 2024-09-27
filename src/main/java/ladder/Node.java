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

    public void move(LadderPosition position) {
        if (isRight()) {
            position.moveRight();
            return;
        }else if (isLeft()) {
            position.moveLeft();
            return;
        }
    }

    public String toString() {
        if (isRight()) {
            return "1 ";
        } else if (isLeft()) {
            return "-1 ";
        } else {
            return "0 ";
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

    public boolean isRight() {
        return direction == RIGHT;
    }

    public  boolean isLeft() {
        return direction == LEFT;
    }

    public boolean isNone() {
        return direction == NONE;
    }
}
