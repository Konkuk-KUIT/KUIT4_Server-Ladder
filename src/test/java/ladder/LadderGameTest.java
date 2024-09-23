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
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        //when
        LadderCreator ladderCreator = new LadderCreator(ladderSize);

        //then
        assertThat(ladderCreator).isNotNull();
    }

    @Test
    void 사다리_사람_예외_처리_확인() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(2);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        LadderCreator ladderCreator = new LadderCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //when
        Position position = Position.from(4);

        //then
        assertThatThrownBy(() -> ladderGame.run(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_결과_확인() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        LadderCreator ladderCreator = new LadderCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(new LadderPosition(0, 0));
        ladderCreator.drawLine(new LadderPosition(1, 1));
        ladderCreator.drawLine(new LadderPosition(2, 0));

        //when
        Position position = Position.from(0);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(2);

        //when
        position = Position.from(1);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(1);

        //when
        position = Position.from(2);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(0);
    }

    @Test
    void 랜덤_사다리_생성() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(4);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(ladderSize);

        int[] count = new int[5];

        //when
        Position position = Position.from(0);
        count[ladderGame.run(position)]++;

        position = Position.from(1);
        count[ladderGame.run(position)]++;

        position = Position.from(2);
        count[ladderGame.run(position)]++;

        position = Position.from(3);
        count[ladderGame.run(position)]++;

        position = Position.from(4);
        count[ladderGame.run(position)]++;

        //then
        assertThat(count[0]).isEqualTo(1);
        assertThat(count[1]).isEqualTo(1);
        assertThat(count[2]).isEqualTo(1);
        assertThat(count[3]).isEqualTo(1);
        assertThat(count[4]).isEqualTo(1);
    }
}