package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderGame;
import ladder.LadderGameFactory;
import ladder.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RandomCreatorTest {
    @Test
    void 랜덤_사다리_생성_확인() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderRandomCreator randomCreator = new LadderRandomCreator(numberOfRow, numberOfPerson);

        //then
        assertThat(randomCreator).isNotNull();
    }

    @Test
    void 랜덤_사다리_사람_예외_처리_확인() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderRandomCreator ladderRandomCreator = new LadderRandomCreator(GreaterThanOne.from(2), numberOfPerson);
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(ladderRandomCreator);

        //given
        Position position = Position.from(4);

        //then
        assertThatThrownBy(() -> ladderGame.run(position))
                .isInstanceOf(IllegalArgumentException.class);
    }
}