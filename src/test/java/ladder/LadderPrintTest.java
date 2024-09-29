package ladder;

import ladder.component.GreaterThanOne;
import ladder.component.LadderPosition;
import ladder.component.LadderSize;
import ladder.component.Position;
import ladder.creator.AutoLadderCreatorImpl;
import ladder.creator.LadderCreator;
import ladder.creator.BasicLadderCreatorImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderPrintTest {

    @Test
    void 기본_사다리_출력_테스트() {
        // given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        GreaterThanOne row = GreaterThanOne.from(5);

        LadderSize ladderSize = LadderSize.from(row, numberOfPerson);

        LadderCreator ladderCreator = new BasicLadderCreatorImpl(ladderSize);

        LadderGame ladderGame = new LadderGame(ladderCreator);


        ladderCreator.drawLine(LadderPosition.from(Position.from(0), Position.from(0)));
        ladderCreator.drawLine(LadderPosition.from(Position.from(1), Position.from(1)));

        // when
        ladderGame.run(Position.from(0));
    }

    @Test
    void 랜덤_생성_사다리_출력_테스트() {
        // given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        GreaterThanOne row = GreaterThanOne.from(5);

        LadderSize ladderSize = LadderSize.from(row, numberOfPerson);

        LadderCreator ladderCreator = new AutoLadderCreatorImpl(ladderSize);

        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(LadderPosition.from(Position.from(0), Position.from(0)));

        // when
        ladderGame.run(Position.from(0));
    }

}
