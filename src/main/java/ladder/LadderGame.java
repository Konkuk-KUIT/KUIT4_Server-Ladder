package ladder;

import ladder.creator.LadderCreator;

public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

//    사다리에 position값을 넣어주고 반복문을 통해
//    메세지를 보내면서 다음 좌표가 어딨는지 질문을 함
    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        ladderRunner.run(position);
        return position.getPosition();
    }
}
