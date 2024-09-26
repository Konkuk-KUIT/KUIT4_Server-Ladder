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
            printLadderState(position, i);
            System.out.println();

            // 현재 행에서 위치 이동 (왼쪽 또는 오른쪽으로)
            rows[i].nextPosition(position);

            // After 출력
            System.out.println("After");
            printLadderState(position, i);
            System.out.println();
        }

        return position.getPosition();
    }

    // 사다리 상태를 출력하는 메서드
    private void printLadderState(Position userPosition, int currentRow) {
        for (int i = 0; i < rows.length; i++) {
            StringBuilder rowRepresentation = new StringBuilder();
            for (int j = 0; j < rows[i].getNodes().length; j++) {
                // 사용자 위치인 경우 숫자와 *를 함께 출력
                if (i == currentRow && j == userPosition.getPosition()) {
                    rowRepresentation.append(rows[i].getNodes()[j].getDirectionValue()).append("* ");
                } else {
                    rowRepresentation.append(rows[i].getNodes()[j].getDirectionValue()).append(" ");
                }
            }
            System.out.println(rowRepresentation.toString());
        }
    }

}
