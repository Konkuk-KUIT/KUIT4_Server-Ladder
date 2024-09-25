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
    // LadderRunner를 통해 돌리자 (사다리를 타는것을 관리하는 클래스)
    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows()); // 이미 만들어 둔 ladderCreator의 사다리를 인수로 넘긴다..
        ladderRunner.run(position);

        return position.getPosition(); // 최종 인덱스(세로 번 째) 반환
    }
}
