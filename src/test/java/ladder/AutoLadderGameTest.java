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
        AutoLadderCreator ladderCreator = new AutoLadderCreator(size);

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
        //assertThat(totalLinesActual).isLessThanOrEqualTo(totalLinesExpected);  // 생성된 라인 수가 예상치를 초과하면 X
    }

    @Test
    void 중복된_라인_생성_방지_테스트() {
        //given
        LadderSize size = new LadderSize(5, 5);  // 사다리 5행 5열
        AutoLadderCreator ladderCreator = new AutoLadderCreator(size);

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
        AutoLadderCreator ladderCreator = new AutoLadderCreator(size);

        //when & then
        for (int y = 0; y < size.getNumberOfRows(); y++) {
            for (int x = 0; x < size.getNumberOfPersons() - 1; x++) {
                int finalX = x;
                int finalY = y;
                assertThatThrownBy(() -> ladderCreator.drawLine(LadderPosition.of(finalX, finalY), LadderPosition.of(finalX + 1, finalY)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("가로선은 인접한 열 사이에만 그릴 수 있습니다.");
            }
        }
    }
    @Test
    void 사다리_게임_진행_확인() {
        //given
        LadderSize size = new LadderSize(5, 5);  // 사다리 5행 5열
        AutoLadderCreator ladderCreator = new AutoLadderCreator(size); // 자동 사다리 생성
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //when
        LadderPosition startPosition = LadderPosition.of(0, 0); // 게임 시작 위치
        int finalX = ladderGame.run(startPosition); // 게임 실행

        //then
        System.out.println("게임 시작 위치: (0, 0)");
        System.out.println("게임 종료 위치: (" + finalX + ", " + (size.getNumberOfRows() - 1) + ")");
        assertThat(finalX).isBetween(0, size.getNumberOfPersons() - 1); // 최종 위치 확인
    }
}
