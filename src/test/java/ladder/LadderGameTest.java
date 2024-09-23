package ladder;

import ladder.creator.LadderCreator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderCreator ladderCreator = new LadderCreator(LadderSize.of(numberOfRow, numberOfPerson));

        //then
        assertThat(ladderCreator).isNotNull();
    }

    @Test
    void 사다리_사람_예외_처리_확인() {
        //when
        GreaterThanOne numberOfRow = GreaterThanOne.from(2);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);

        LadderCreator ladderCreator = new LadderCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //given
        Position position = Position.from(4);

        //then
        assertThatThrownBy(() -> ladderGame.run(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_결과_확인() {
        //when
        GreaterThanOne row = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        LadderSize ladderSize = LadderSize.of(row, numberOfPerson);

        LadderCreator ladderCreator = new LadderCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        LadderPosition ladderPosition1 = LadderPosition.of(Position.from(0), Position.from(0));
        LadderPosition ladderPosition2 = LadderPosition.of(Position.from(1), Position.from(1));
        LadderPosition ladderPosition3 = LadderPosition.of(Position.from(2), Position.from(0));

        ladderCreator.drawLine(ladderPosition1);
        ladderCreator.drawLine(ladderPosition2);
        ladderCreator.drawLine(ladderPosition3);

        //given
        Position position = Position.from(0);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(2);

        //given
        position = Position.from(1);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(1);

        //given
        position = Position.from(2);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(0);
    }
}