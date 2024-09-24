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

    public void moveRow(Position position) {

        if (isRight()) {
            position.next();
            return;
        }
        if (isLeft()) {
            position.prev();
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

    public boolean isRight() {
        return direction == RIGHT;
    }

    public boolean isLeft() {
        return direction == LEFT;
    }

    public boolean isNone() {
        return direction == NONE;
    }
}
