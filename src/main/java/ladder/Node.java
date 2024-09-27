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

    public void move(Position position) {
        if (direction == Direction.RIGHT) {
            position.next();  // 오른쪽으로 이동
        } else if (direction == Direction.LEFT) {
            position.prev();  // 왼쪽으로 이동
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


    public Direction getDirection() {
        return this.direction;
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
}
