package ladder;

import ladder.creator.LadderCreator;
import org.junit.jupiter.api.Test;

public class LadderFactoryTest {

    @Test
    void 정적_팩토리_메소드_기본사다리_검증() {

        // given
        LadderGame ladderGame = LadderGameFactory.createBasicLadderGame();
        LadderCreator ladderCreator = ladderGame.getLadderCreator();
        ladderCreator.setRowsAndPersons(GreaterThanOne.from(5), GreaterThanOne.from(5));
        ladderGame.getLadderCreator().drawLine(Position.from(0), Position.from(0));

        // then
        ladderGame.run(Position.from(0));

    }

    @Test
    void 정적_팩토리_메소드_랜덤사다리_검증() {

        // given
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame();
        LadderCreator ladderCreator = ladderGame.getLadderCreator();
        ladderCreator.setRowsAndPersons(GreaterThanOne.from(5), GreaterThanOne.from(5));
        ladderGame.getLadderCreator().drawLine(Position.from(0), Position.from(0));

        // then
        ladderGame.run(Position.from(0));

    }


}
