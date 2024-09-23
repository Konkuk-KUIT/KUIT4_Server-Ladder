package ladder;

import ladder.creator.LadderCreator;
import org.junit.jupiter.api.Test;

public class LadderAutoCreateTest {

    @Test
    void 사다리_자동_생성() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(5);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //when
        ladderCreator.autoDrawLine();
        Position position = Position.from(2);

        //then
        ladderGame.run(position);

    }
}
