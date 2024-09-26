package ladder;

import ladder.creator.DefaultLadderCreator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        DefaultLadderCreator defaultLadderCreator = new DefaultLadderCreator(numberOfRow, numberOfPerson);

        //then
        assertThat(defaultLadderCreator).isNotNull();
    }

    @Test
    void 사다리_사람_예외_처리_확인() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        DefaultLadderCreator defaultLadderCreator = new DefaultLadderCreator(GreaterThanOne.from(2), numberOfPerson);
        LadderGame ladderGame = new LadderGame(defaultLadderCreator);

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
        GreaterThanOne row = GreaterThanOne.from(3);
        DefaultLadderCreator defaultLadderCreator = new DefaultLadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(defaultLadderCreator);

        defaultLadderCreator.drawLine(Position.from(0),Position.from(0));
        defaultLadderCreator.drawLine(Position.from(1),Position.from(1));
        defaultLadderCreator.drawLine(Position.from(2),Position.from(0));

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