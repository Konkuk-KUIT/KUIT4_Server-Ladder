import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class LadderTest {


    @Test
    public void testLadderRun() {
        Ladder ladder = new Ladder(5, 4);

        ladder.drawLine(0, 0); // 0번 위치에 가로선 추가
        ladder.drawLine(1, 1); // 1번 위치에 가로선 추가
        ladder.drawLine(2, 2); // 2번 위치에 가로선 추가
        ladder.drawLine(3, 0); // 3번 위치에 가로선 추가
        ladder.drawLine(4, 1); // 3번 위치에 가로선 추가


        // 테스트
        assertThat(ladder.run(0)).isEqualTo(3); // 0번 세로줄에서 시작 -> 1번으로 이동
        assertThat(ladder.run(1)).isEqualTo(2); // 1번 세로줄에서 시작 -> 0번으로 이동
        assertThat(ladder.run(2)).isEqualTo(0); // 2번 세로줄에서 시작 -> 3번으로 이동
        assertThat(ladder.run(3)).isEqualTo(1); // 3번 세로줄에서 시작 -> 2번으로 이동
    }

    @Test
    public void testInvalidStartPosition() {
        Ladder ladder = new Ladder(5, 4);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ladder.run(4));
        assertThat(exception.getMessage()).isEqualTo("잘못된 시작 위치입니다.");
    }



}