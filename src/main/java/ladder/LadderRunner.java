package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public void run(Position position, int currentRowIndex) {

        // Before 상태 출력
        System.out.println("Before:");
        printLadder(position, currentRowIndex);

        // 현재 Row에서 방향에 따라 좌우 이동
        rows[currentRowIndex].nextPosition(position);

        // After 상태 출력
        System.out.println("After:");
        printLadder(position, currentRowIndex);


    }

    // 사다리 상태를 출력하는 메서드
    public void printLadder(Position position, int currentRowIndex) {
        for (int i = 0; i < rows.length; i++) {
            System.out.println(rows[i].toString(position, i == currentRowIndex));  // 해당 행에만 true 전달
        }
        System.out.println();
    }
}
