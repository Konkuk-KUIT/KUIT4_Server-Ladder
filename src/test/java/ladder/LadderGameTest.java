package ladder;

import ladder.creator.LadderCreator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(5);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);

        //then
        assertThat(ladderCreator).isNotNull();
    }

    @Test
    void 사다리_사람_예외_처리_확인() {
        //when
        GreaterThanOne row = GreaterThanOne.from(5);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        LadderCreator ladderCreator = new LadderCreator(row, numberOfPerson);
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());

        //given
        Position nthOfPerson = Position.from(5);

        //then
        assertThatThrownBy(() -> ladderRunner.run(nthOfPerson))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_결과_확인() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        GreaterThanOne row = GreaterThanOne.from(5);
        LadderCreator ladderCreator = new LadderCreator(row, numberOfPerson);
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());

        ladderCreator.drawLine(Position.from(0), Position.from(0));
        ladderCreator.drawLine(Position.from(1), Position.from(1));
        ladderCreator.drawLine(Position.from(2), Position.from(0));
        ladderCreator.drawLine(Position.from(3), Position.from(2));
        ladderCreator.drawLine(Position.from(2), Position.from(3));

        //given
        Position nthOfPerson = Position.from(0);

        //then
        assertThat(ladderRunner.run(nthOfPerson)).isEqualTo(3);

        //given
        nthOfPerson = Position.from(1);

        //then
        assertThat(ladderRunner.run(nthOfPerson)).isEqualTo(1);

        //given
        nthOfPerson = Position.from(2);

        //then
        assertThat(ladderRunner.run(nthOfPerson)).isEqualTo(0);

        //given
        nthOfPerson = Position.from(3);

        //then
        assertThat(ladderRunner.run(nthOfPerson)).isEqualTo(4);

        //given
        nthOfPerson = Position.from(4);

        //then
        assertThat(ladderRunner.run(nthOfPerson)).isEqualTo(2);
    }
}