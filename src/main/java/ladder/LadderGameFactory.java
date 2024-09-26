package ladder;

import ladder.creator.DefaultLadderCreator;
import ladder.creator.LadderCreator;
import ladder.creator.RandomLadderCreator;

public class LadderGameFactory {

    private LadderSize ladderSize;
    // 정적 팩토리 메서드
    public static LadderGame createRandomLadderGame(LadderSize ladderSize) {
        // 복잡한 생성 로직을 여기서 처리
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(ladderSize.getNumberOfRow(), ladderSize.getNumberOfPerson());
        return new LadderGame(randomLadderCreator);  // 의존성 주입도 여기서 처리
    }

    // 다른 방식의 사다리 생성 메서드도 가능
    public static LadderGame createDefaultLadderGame(LadderSize ladderSize) {
        DefaultLadderCreator defaultLadderCreator = new DefaultLadderCreator(ladderSize.getNumberOfRow(), ladderSize.getNumberOfPerson());
        return new LadderGame(defaultLadderCreator);
    }
}