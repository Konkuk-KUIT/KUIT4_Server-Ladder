import ladder.LadderGame;
import ladder.Line;
import ladder.constants.Direction;
import ladder.creator.LadderGameFactory;
import ladder.wrapper.ArrayIndex;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {
    @Test
    @DisplayName("normalGame를 실행했을 때 예상한 결과와 맞는지 확인")
    void normalGameTest() {
        //when
        LadderGame laddergame = LadderGameFactory.createPureLadderGame(5,5);
        laddergame.drawLine(Line.of(0,1, Direction.RIGHT));
        laddergame.drawLine(Line.of(1,2, Direction.RIGHT));
        laddergame.drawLine(Line.of(2,3, Direction.RIGHT));
        laddergame.drawLine(Line.of(3,4, Direction.LEFT));

        //given
        int result = laddergame.run(ArrayIndex.of(1));

        //then
        assertThat(result).isEqualTo(3);

    }

    @Test
    @DisplayName("randomGame을 실행했을 때 랜덤한 사다리로 게임이 진행되는지 확인")
    void randomGameTest_IsLadderRandom() {
        //when
        LadderGame laddergame;
        ArrayList<Integer> resultList = new ArrayList<>();
        int randomStartPosition;
        int[] resultCount = new int[5];

        //given
        for(int i=0; i<1000; i++){
            laddergame = LadderGameFactory.createRandomLadderGame(5,5);
            randomStartPosition = (int)Math.floor(Math.random() * 5);
            resultList.add(laddergame.run(ArrayIndex.of(randomStartPosition)));
        }
        for (Integer i : resultList) {
            resultCount[i]++;
        }

        //then
        assertThat(resultCount[0]).isCloseTo(200, Percentage.withPercentage(20));

    }

    @Test
    @DisplayName("randomGame을 실행했을 때 게임이 적절히 동작하는지 확인")
    void randomGameTest() {
        //when
        LadderGame laddergame = LadderGameFactory.createRandomLadderGame(5,5);

        //given
        int result = laddergame.run(ArrayIndex.of(1));

        //then
        assertThat(result).isBetween(0,4);

    }

    @Test
    @DisplayName("적절하지 않은 위치에서 시작할 때 예외가 발생하는지 확인")
    void GameTest_InvalidStartPosition() {
        //when
        LadderGame laddergame = LadderGameFactory.createRandomLadderGame(5,5);

        //given
        assertThatThrownBy(() -> laddergame.run(ArrayIndex.of(5))).isInstanceOf(IllegalArgumentException.class);

    }


}
