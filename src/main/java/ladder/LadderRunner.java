package ladder;

public class LadderRunner {

    private final Row[] rows; // 사다리의 한 행을 빼놓았다.

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    // todo 포지션 wrapper 클래스 필요
    // todo LadderRunner로 분리 (Ladder 클래스 책임분산)
    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            rows[i].nextPosition(position); // position에 대입 삭제 (1)
        }
        return position.getPosition();
    }
}
