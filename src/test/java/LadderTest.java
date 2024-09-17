import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    Scanner scanner = new Scanner(System.in);

    @Test
    void selectLadder2(){

        Ladder ladder = new Ladder(4, 3);

        int answer = ladder.run(ladder.validLadderIndex(5));
        System.out.println(answer);
    }

    @Test
    void 사다리_라인_생성(){

        Ladder ladder = new Ladder(4, 3);

        ladder.drawLine(2,3);
        ladder.drawLine(1,4);
        int i = ladder.run(ladder.validLadderIndex(3));
        System.out.println(i);
    }

}