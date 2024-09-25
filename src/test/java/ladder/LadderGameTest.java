package ladder;

import ladder.creator.CustomLadderCreator;
import ladder.creator.LadderCreator;
import ladder.creator.RandomLadderCreator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);

        //when
        CustomLadderCreator customLadderCreator = CustomLadderCreator.from(ladderSize);

        //then
        assertThat(customLadderCreator).isNotNull();
    }

    @Test
    void 사다리_사람_예외_처리_확인() {
        //when
        GreaterThanOne numberOfRow = GreaterThanOne.from(2);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        CustomLadderCreator customLadderCreator = CustomLadderCreator.from(LadderSize.of(numberOfRow, numberOfPerson));
        LadderGame ladderGame = LadderGame.from(customLadderCreator);

        //given
        Position position = Position.from(4);

        //then
        assertThatThrownBy(() -> ladderGame.run(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_결과_확인() {
        //when
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);
        LadderGame ladderGame = LadderGameFactory.createCustomLadderGame(ladderSize);

        LadderCreator ladderCreator = ladderGame.getLadderCreator();
        ladderCreator.drawLine(LadderPosition.of(Position.from(0),Position.from(0)));
        ladderCreator.drawLine(LadderPosition.of(Position.from(1),Position.from(1)));
        ladderCreator.drawLine(LadderPosition.of(Position.from(2),Position.from(0)));

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

    @Test
    void 랜덤_사다리_게임_생성_확인() {
        //when
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);
        Position position = Position.from(0);

        //given
        LadderGame ladderGame1 = LadderGameFactory.createRandomLadderGame(ladderSize);
        ladderGame1.run(position);

        LadderGame ladderGame2 = LadderGameFactory.createRandomLadderGame(ladderSize);
        ladderGame2.run(position);

        //then
        assertThat(ladderGame1).isNotEqualTo(ladderGame2);
    }

    @Test
    void 랜덤_사다리_게임_결과_확인() {
        //when
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(ladderSize);

        //given
        Position position = Position.from(0);
        int result0 = ladderGame.run(position);

        position = Position.from(1);
        int result1 = ladderGame.run(position);

        //then
        assertThat(result0).isNotEqualTo(result1);
    }
}