public class Player {
    private final int startPosition;

    public Player(int startPosition) {
        // 사다리는 0부터 시작하기 때문에
        this.startPosition = startPosition-1;
    }

    public int getStartPosition() {
        return startPosition;
    }
}
