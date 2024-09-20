import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class LadderTest {

    @Test
    void selectLadder(){

        Ladder ladder = new Ladder(5, 5);
        RunLadder runLadder = new RunLadder(ladder);

        int answer = runLadder.run(runLadder.validLadderIndex(1));
        System.out.println(answer);
        assertThat(answer).isEqualTo(1);
    }

    @Test
    void 사다리_라인_생성(){

        Ladder ladder = new Ladder(5, 4);
        RunLadder runLadder = new RunLadder(ladder);

        ladder.drawLine(ladder.validDrawLine(3),2);
        ladder.drawLine(ladder.validDrawLine(1),1);
        int i = runLadder.run(runLadder.validLadderIndex(1));
        assertThat(i).isEqualTo(3);
    }

}