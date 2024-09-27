package ladder;

import ladder.creator.AutoLadderCreator;
import ladder.creator.LadderCreator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class AutoLadderGameTest {
    @Test
    void 자동_사다리_생성_확인() {
        //given
        LadderSize size = new LadderSize(5, 5);  // 사다리 5행 5열
        LadderCreator ladderCreator = new LadderCreator(size);

        //when
        int totalLinesExpected = (int) (size.getNumberOfRows() * size.getNumberOfPersons() * 0.3);
        int totalLinesActual = 0;
        for (Row row : ladderCreator.getRows()) {
            for (Node node : row.getNodes()) {
                if (node.isAlreadySetDirection()) {
                    totalLinesActual++;
                }
            }
        }

        //then
        assertThat(totalLinesActual).isGreaterThan(0);  // 적어도 하나 이상의 라인이 생성
        assertThat(totalLinesActual).isLessThanOrEqualTo(totalLinesExpected);  // 생성된 라인 수가 예상치를 초과하면 X
    }

    @Test
    void 중복된_라인_생성_방지_테스트() {
        //given
        LadderSize size = new LadderSize(5, 5);  // 사다리 5행 5열
        LadderCreator ladderCreator = new LadderCreator(size);

        //when
        boolean hasConsecutiveLines = false;
        for (Row row : ladderCreator.getRows()) {
            for (int i = 0; i < row.getNodes().length - 1; i++) {
                if (row.getNodes()[i].isAlreadySetDirection() &&
                        row.getNodes()[i + 1].isAlreadySetDirection()) {
                    hasConsecutiveLines = true;
                    break;
                }
            }
            if (hasConsecutiveLines) break;
        }

        //then
        assertThat(hasConsecutiveLines).isFalse();  // 연속된 라인이 생성되지 않아야 함
    }

    @Test
    void 라인_생성_유효성_검사() {
        //given
        LadderSize size = new LadderSize(5, 5);  // 사다리 5행 5열
        LadderCreator ladderCreator = new LadderCreator(size);

        //when & then
        for (int y = 0; y < size.getNumberOfRows(); y++) {
            for (int x = 0; x < size.getNumberOfPersons() - 1; x++) {
                int finalX = x;
                int finalY = y;
                // 연속된 라인이 없어야 하므로, 다음과 같은 테스트를 수행
                assertThatThrownBy(() -> ladderCreator.drawLine(LadderPosition.of(finalX, finalY), LadderPosition.of(finalX + 1, finalY)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("가로선은 인접한 열 사이에만 그릴 수 있습니다.");
            }
        }
    }
}
