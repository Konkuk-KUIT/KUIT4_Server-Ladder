package ladder;

import ladder.creator.LadderCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderPrintTest {
    @Test
    void 사다리_출력_테스트() {
        // given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        GreaterThanOne row = GreaterThanOne.from(5);
        LadderCreator ladderCreator = new LadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.from(0), Position.from(0));
        ladderCreator.drawLine(Position.from(1), Position.from(1));

        // when
        Position position = Position.from(0);

        // then
        Assertions.assertThat(ladderGame.run(position)).isEqualTo(2);
    }

}
