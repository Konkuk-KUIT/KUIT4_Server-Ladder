public class Node {
    private Direction direction;

    public Node(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void SetNode(Direction direction) {
        this.direction = direction;
    }

    public boolean isLeft() {
        return direction == Direction.LEFT;
    }

    public boolean isRight() {
        return direction == Direction.RIGHT;
    }

    public boolean isZero() {
        return direction == Direction.NONE;
    }

    public void printDirectionNumber() {
        System.out.print(direction.getDirection());
    }
}
