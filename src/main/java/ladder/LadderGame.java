package ladder;

import ladder.creator.LadderCreator;

public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run(Position position) {

        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());

        for (int i = 0; i < ladderCreator.getRows().length; i++) {

            // 마지막 행에 도달했을 때 이동을 멈추고 출력 종료
            if (i == ladderCreator.getRows().length - 1) {
                ladderRunner.run(position, i);
                break;
            }
            // 현재 Row에서 방향에 따라 이동
            ladderRunner.run(position,i);
        }
        return position.getValue();
    }

}
