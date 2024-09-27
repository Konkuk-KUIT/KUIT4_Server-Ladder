package ladder;

import ladder.creator.AutoLadderCreator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLadderGameTest {

    @Test
    void 랜덤_사다리_생성_확인() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        AutoLadderCreator ladderCreator = new AutoLadderCreator(numberOfRow, numberOfPerson);

        //then
        assertThat(ladderCreator).isNotNull();
    }

    @Test
    void 랜덤_사다리_결과_확인() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        AutoLadderCreator ladderCreator = new AutoLadderCreator(numberOfRow, numberOfPerson);
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());

        //when
        ladderCreator.drawRandomLines(ladderSize, numberOfRow, numberOfPerson);

        //then
        ladderRunner.run(Position.from(0));

    }

}
