package ladder;

import ladder.component.GreaterThanOne;
import ladder.component.LadderPosition;
import ladder.component.LadderSize;
import ladder.component.Position;
import ladder.creator.LadderCreator;
import org.junit.jupiter.api.Test;

public class LadderFactoryTest {

    @Test
    void 정적_팩토리_메소드_기본사다리_검증() {

        // given
        LadderSize ladderSize = LadderSize.from(GreaterThanOne.from(5), GreaterThanOne.from(5));
        LadderGame ladderGame = LadderGameFactory.createBasicLadderGame(ladderSize);
        ladderGame.getLadderCreator().drawLine(LadderPosition.from(Position.from(0), Position.from(0)));

        // then
        ladderGame.run(Position.from(0));

    }

    @Test
    void 정적_팩토리_메소드_랜덤사다리_검증() {

        // given

        LadderSize ladderSize = LadderSize.from(GreaterThanOne.from(5), GreaterThanOne.from(5));
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(ladderSize);
        ladderGame.getLadderCreator().drawLine(LadderPosition.from(Position.from(0), Position.from(0)));

        // then
        ladderGame.run(Position.from(0));

    }

    // todo LadderPosition, LadderSize 등등 좀 더 엄밀히 테스팅


}
