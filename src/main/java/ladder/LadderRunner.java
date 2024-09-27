package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            // Before 출력
            System.out.println("Before");
            printLadder(position, i);  // 사다리 상태 출력
            System.out.println();

            // 현재 행에서 위치 이동 (왼쪽 또는 오른쪽으로)
            rows[i].nextPosition(position);

            // After 출력
            System.out.println("After");
            printLadder(position, i);  // 사다리 상태 출력
            System.out.println();
        }

        return position.getPosition();
    }

    // 사다리 상태를 출력하는 메서드
    private void printLadder(Position position, int currentRow) {
        for (int i = 0; i < rows.length; i++) {
            if (currentRow == i) {
                rows[i].printUserRow(position);  // 사용자 위치를 표시하여 출력
            } else {
                rows[i].printRow();  // 일반 행 출력
            }
        }
    }

}
