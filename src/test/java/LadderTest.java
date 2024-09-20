import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리 생성")
    void createLadder(){
        Ladder ladder = new Ladder(new NaturalNumber(3),new NaturalNumber(4));
        //using asertJ
        assertThat(ladder.checkRow()).isEqualTo(3);
        assertThat(ladder.checkNumberOfPerson()).isEqualTo(4);
    }

    @Test
    @DisplayName("사다리 drawLine test")
    void drawLineTest(){
        Ladder ladder = new Ladder(new NaturalNumber(3),new NaturalNumber(3));
        ladder.drawLine(new NaturalNumber(3),new NaturalNumber(2));
        assertThat(ladder.checkLine(3,3)).isEqualTo(-1);

    }


    @Test
    @DisplayName("사다리 run test")
    void runTest(){
        Ladder ladder = new Ladder(new NaturalNumber(5),new NaturalNumber(3));
        ladder.drawLine(new NaturalNumber(1),new NaturalNumber(1));
        ladder.drawLine(new NaturalNumber(2),new NaturalNumber(2));
        assertThat(ladder.run(new NaturalNumber(3))).isEqualTo(2);
    }

    @Test
    @DisplayName("사다리 run test2")
    void runTest2(){
        //drawline 불가 case
        Ladder ladder = new Ladder(new NaturalNumber(1),new NaturalNumber(1));
        assertThat(ladder.run(new NaturalNumber(1))).isEqualTo(1);
    }

}
