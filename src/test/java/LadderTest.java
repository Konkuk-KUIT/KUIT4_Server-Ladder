import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    private Ladder ladder;
    @BeforeEach
    void setUp() {
        ladder = new Ladder(NaturalNumber.from(4), NaturalNumber.from(4));
    }

    @Test
    void runTestWithoutLine(){
        for(int i = 1; i <= 4 ; i++){
            assertThat(ladder.run(i)).isEqualTo(i);
        }
    }

    @Test
    void TestDrawInvalidLines() {
        assertThatThrownBy(() -> {
            ladder.drawLine(NaturalNumber.from(-1), NaturalNumber.from(0));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            ladder.drawLine(NaturalNumber.from(0), NaturalNumber.from(-1));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            ladder.drawLine(NaturalNumber.from(0), NaturalNumber.from(4));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            ladder.drawLine(NaturalNumber.from(5), NaturalNumber.from(0));
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void TestRun(){

        ladder.drawLine(NaturalNumber.from(0),NaturalNumber.from(0));
        ladder.drawLine(NaturalNumber.from(0),NaturalNumber.from(1));

        ladder.drawLine(NaturalNumber.from(1),NaturalNumber.from(0));
        ladder.drawLine(NaturalNumber.from(1),NaturalNumber.from(1));
        ladder.drawLine(NaturalNumber.from(2),NaturalNumber.from(1));
        ladder.drawLine(NaturalNumber.from(2),NaturalNumber.from(2));
        ladder.drawLine(NaturalNumber.from(0),NaturalNumber.from(2));
        ladder.drawLine(NaturalNumber.from(0),NaturalNumber.from(3));
        ladder.drawLine(NaturalNumber.from(3),NaturalNumber.from(2));
        ladder.drawLine(NaturalNumber.from(3),NaturalNumber.from(3));


        ladder.initLines();

        assertThat(ladder.run(1)).isEqualTo(1);
        assertThat(ladder.run(2)).isEqualTo(4);
        assertThat(ladder.run(3)).isEqualTo(3);
        assertThat(ladder.run(4)).isEqualTo(2);



    }



}