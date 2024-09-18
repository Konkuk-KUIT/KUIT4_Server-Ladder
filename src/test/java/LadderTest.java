import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class LadderTest {

    @Test
    void selectLadder(){

        Ladder ladder = new Ladder(4, 3);

        int answer = ladder.run(ladder.validLadderIndex(2));
        assertThat(answer).isEqualTo(2);
    }

    @Test
    void 사다리_라인_생성(){

        Ladder ladder = new Ladder(4, 3);

        ladder.drawLine(2,3);
        ladder.drawLine(1,4);
        int i = ladder.run(ladder.validLadderIndex(3));
        assertThat(i).isEqualTo(1);
    }

}