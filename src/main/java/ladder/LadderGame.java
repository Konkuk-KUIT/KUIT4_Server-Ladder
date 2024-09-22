package ladder;

import ladder.creator.LadderCreator;

// todo Ladder 클래스가 많은 책임 (사다리 생성 / 사다리 그리기 / 사다리 게임 진행)
// 마지막으로 Ladder는 전체를 관장하는 클래스가 되었으므로
// LadderGame으로 변경
public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    // todo 포지션 wrapper 클래스 필요
    // todo LadderRunner로 분리 (Ladder 클래스 책임분산)
    // LadderRunner를 통해 돌리자
    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        ladderRunner.run(position);

        return position.getPosition();
    }
}
