package ladder;

// 사다리의 인덱스(위치)를 나타내는 클래스
public class Position {

    private int position;

    private Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public static Position from(int position) {
        validatePosition(position); // 1-1. 검증로직
        return new Position(position);
    }

    private static void validatePosition(int position) {
        if (!isPosition(position)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_POSITION.getMessage());
        }

    }

    private static boolean isPosition(int position) {
        return position >= 0;
    }

    public boolean isBiggerThan(int position) {
        return this.position > position;
    }

    public boolean isSmallerThan(int position) {
        return this.position < position;
    }

    public void next() {
        // return Position.from(position + 1); (1)
        position++;
    }
    // 3번째 강의 11:04
    // 1. Position을 생성해서 넘겨주고 있음 (next, prev)
    // 1-3. Position을 생성해서 로직을 돌리는 것 보다, 본인 스스로 관리하도록

    public void prev() {
        // return Position.from(position - 1);
        position--;
    }
}
