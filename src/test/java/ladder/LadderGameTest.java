package ladder;

import ladder.creator.AutoLadderCreatorImpl;
import ladder.creator.LadderCreator;
import ladder.creator.BasicLadderCreatorImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderGameTest {

    @Test
    void 기본_사다리_생성_확인() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        LadderSize ladderSize = LadderSize.from(numberOfRow, numberOfPerson);

        //when
        LadderCreator ladderCreator = new BasicLadderCreatorImpl(ladderSize);

        //then
        assertThat(ladderCreator).isNotNull();
    }

    @Test
    void 랜덤_사다리_생성_확인() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        LadderSize ladderSize = LadderSize.from(numberOfRow, numberOfPerson);

        //when
        LadderCreator autoLadderCreator = new AutoLadderCreatorImpl(ladderSize);

        //then
        assertThat(autoLadderCreator).isNotNull();

    }

    @Test
    void 사다리_사람_예외_처리_확인() {
        //when
        GreaterThanOne numberOfRow = GreaterThanOne.from(2);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderSize ladderSize = LadderSize.from(numberOfRow, numberOfPerson);

        LadderCreator ladderCreator = new BasicLadderCreatorImpl(ladderSize);
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
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);

        LadderSize ladderSize = LadderSize.from(numberOfRow, numberOfPerson);

        LadderCreator ladderCreator = new BasicLadderCreatorImpl(ladderSize);

        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(LadderPosition.from(Position.from(0),Position.from(0)));
        ladderCreator.drawLine(LadderPosition.from(Position.from(1),Position.from(1)));
        ladderCreator.drawLine(LadderPosition.from(Position.from(2),Position.from(0)));

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