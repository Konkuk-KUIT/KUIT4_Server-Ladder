package ladder;

import ladder.creator.LadderCreator;

public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public void run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        //ladderRunner.run(position);
        //return position.getValue();
        LadderPosition ladderPosition = new LadderPosition(position.getValue(), 0);

        for (int i = 0; i < ladderCreator.getRows().length; i++) {
            // 현재 상태를 출력하기 전에
            System.out.println("Before:");
            printLadder(ladderPosition);

            // 현재 행에서 좌우 이동
            ladderRunner.run(position);

            // 이동 후 상태 출력
            System.out.println("After:");
            printLadder(ladderPosition);

            // y 좌표를 한 칸 내려감
            ladderPosition.moveDown();
        }
    }
    private void printLadder(LadderPosition currentPosition) {
        Row[] rows = ladderCreator.getRows();
        for (int y = 0; y < rows.length; y++) {
            StringBuilder rowStr = new StringBuilder();
            for (int x = 0; x < rows[y].nodes.length; x++) {
                if (currentPosition.getX() == x && currentPosition.getY() == y) {
                    rowStr.append("* ");
                } else {
                    rowStr.append(rows[y].toString());
                }
            }
            System.out.println(rowStr);
        }
        System.out.println();
    }
}
