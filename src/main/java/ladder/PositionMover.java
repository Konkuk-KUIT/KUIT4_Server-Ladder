package ladder;

public class PositionMover {
    public static void moveLeft(LadderPosition position) {
        position.setX(position.getX() - 1);
    }

    public static void moveRight(LadderPosition position) {
        position.setX(position.getX() + 1);
    }

    public static void moveDown(LadderPosition position) {
        position.setY(position.getY() + 1);
    }

    public static boolean isSmallerThan(LadderPosition position, int x) {
        return position.getX() < x;
    }

    public static boolean isBiggerThan(LadderPosition position, int x) {
        return position.getX() > x;
    }
}
