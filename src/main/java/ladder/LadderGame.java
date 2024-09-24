package ladder;

import ladder.creator.LadderCreator;

public class LadderGame {

    private final LadderCreator ladderCreator;

    // todo Ladder 생성자 래퍼 클래스 -> 완
    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    // todo LadderCreator, LadderRunner -> 완

    // todo 인덱스 값 Position 래퍼 클래스 -> 완
    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        ladderRunner.run(position);
        return position.getPosition();
    }
}
