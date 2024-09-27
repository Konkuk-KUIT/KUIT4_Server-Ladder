package ladder;

import ladder.creator.LadderCreator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderGameTest {



    @Test
    void 사다리_생성_확인() {
        //given
        LadderSize size = new LadderSize(3, 5);  // 사다리의 행과 열


        //when
        LadderCreator ladderCreator = new LadderCreator(size);

        //then
        assertThat(ladderCreator).isNotNull();
    }

    @Test
    void 사다리_사람_예외_처리_확인() {
        //when
        LadderSize size = new LadderSize(2, 3);  // 사다리의 행과 열
        LadderCreator ladderCreator = new LadderCreator(size);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //given
        LadderPosition position = LadderPosition.of(4, 0);

        //then
        assertThatThrownBy(() -> ladderGame.run(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_결과_확인() {
        //when
        LadderSize size = new LadderSize(4, 5);  // 사다리의 행과 열
        LadderCreator ladderCreator = new LadderCreator(size);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(LadderPosition.of(0, 0), LadderPosition.of(1, 0));
        ladderCreator.drawLine(LadderPosition.of(1, 1), LadderPosition.of(2, 1));

        //given
        LadderPosition position = LadderPosition.of(0, 0);
        ladderGame.run(position);
        //then
        assertThat(position.getX()).isEqualTo(2);


    }
}