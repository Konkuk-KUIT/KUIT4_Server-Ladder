package ladder;

import ladder.creator.LadderAutoCreator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLadderGameTest {
    @Test
    void 사다리_자동_생성_확인() {
        // given
        GreaterThanOne row = GreaterThanOne.from(5);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        // when
        LadderAutoCreator ladderCreator = new LadderAutoCreator(row, numberOfPerson);

        // then
        assertThat(ladderCreator).isNotNull();
    }

    @Test
    void 사다리_자동_생성_결과_확인() {
        GreaterThanOne numberOfRow = GreaterThanOne.from(5);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);

        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(numberOfRow, numberOfPerson);
        Position startPosition = Position.from(0);
        int finalPosition = ladderGame.run(startPosition);

        assertThat(finalPosition).isNotNegative();
    }
}
