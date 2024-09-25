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

            //변경 후 상태 업데이트
            ladderPosition = new LadderPosition(position.getValue(), i );

            // 이동 후 상태 출력
            System.out.println("After:");
            printLadder(ladderPosition);

            // y 좌표를 한 칸 내려감
            //ladderPosition.moveDown();
        }
    }
    private void printLadder(LadderPosition currentPosition) {
        Row[] rows = ladderCreator.getRows();
        for (int y = 0; y < rows.length; y++) {
            StringBuilder rowStr = new StringBuilder();
            for (int x = 0; x < rows[y].getNodes().length; x++) {
                //현재 위치 *으로 표시
                if (currentPosition.getX() == x && currentPosition.getY() == y) {
                    //rowStr.append("*");
                    rowStr.append(rows[y].getNodes()[x].toString().trim()).append("* ");
                } else {
                    //rowStr.append(rows[y].getNodes()[x].toString());
                    rowStr.append(rows[y].getNodes()[x].toString().trim()).append(" ");
                }
            }
            System.out.println(rowStr.toString().trim());
            //System.out.println(rowStr);
        }
        System.out.println();
    }
}
