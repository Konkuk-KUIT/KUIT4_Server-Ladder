package ladder;

import static javax.swing.RowFilter.ComparisonType.AFTER;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(LadderPosition position) {
        for (int i = 0; i < rows.length; i++) {

            printLadder(position, "BEFORE");

            // 현재 행(Row)에서 좌우로 이동
            rows[i].nextPosition(position);

            // 사다리 진행 후 상태 출력 (AFTER)
            printLadder(position, "AFTER");

            // 행을 한 칸 아래로 이동
            PositionMover.moveDown(position);
        }
        return position.getX();
    }
    //사다리 출력 메소드
    private void printLadder(LadderPosition currentPosition, String state) {
        //Row[] rows = ladderCreator.getRows();
        System.out.println(state + ": 현재 위치는 (" + currentPosition.getX() + ", " + currentPosition.getY() + ") 입니다.");

        for (int y = 0; y < rows.length; y++) {
            StringBuilder rowStr = new StringBuilder();
            for (int x = 0; x < rows[y].getNodes().length; x++) {
                //현재 위치 *으로 표시
                if (currentPosition.isCurrentPosition(x, y)) {
                    rowStr.append("* ");
                } else {
                    rowStr.append(rows[y].getNodes()[x].toString().trim()).append(" ");
                }
            }
            System.out.println(rowStr.toString().trim());
        }
        System.out.println();
    }
}
