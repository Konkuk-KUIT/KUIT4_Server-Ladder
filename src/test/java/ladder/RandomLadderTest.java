package ladder;

import ladder.creator.LadderAutoCreator;
import org.junit.jupiter.api.Test;

public class RandomLadderTest {
    @Test
    void 사다리_자동_생성_결과_확인(){
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);
        LadderAutoCreator ladderAutoCreator = new LadderAutoCreator(numberOfPerson,row);
        LadderGame ladderGame = new LadderGame(ladderAutoCreator);

        ladderAutoCreator.drawLine(Position.from(0),Position.from(0));

        ladderGame.run(Position.from(0));

    }
}
