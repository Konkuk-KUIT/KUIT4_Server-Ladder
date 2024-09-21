import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    Position pos;

    @Test
    void Ladder_init() {
        int height = 5, numberOfPerson = 5;
        Ladder ladder = new Ladder(height, numberOfPerson);
        assertThat(ladder).isNotNull();
    }
    @Test
    void OnePerson(){
        int height = 5, numberOfPerson = 1;
        Ladder ladder = new Ladder(height, numberOfPerson);

        int result = ladder.run(0);
        assertThat(result).isEqualTo(0);
    }
    @Test
    void TwoPerson(){
        int height = 5, numberOfPerson = 2;
        Ladder ladder = new Ladder(height, numberOfPerson);
        ladder.drawLine(new Position(0, 0), 1);
        ladder.drawLine(new Position(2, 1), -1);
        ladder.drawLine(new Position(3, 1), -1);

        int result = ladder.run(0);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void ThreePerson(){
        int height = 5, numberOfPerson = 3;
        Ladder ladder = new Ladder(height, numberOfPerson);
        ladder.drawLine(new Position(0, 0), 1);
        ladder.drawLine(new Position(1, 1), 1);
        ladder.drawLine(new Position(2, 2), -1);
        //ladder.drawLine(new Position(3, 1), -1); => 0

        int result = ladder.run(0);
        assertThat(result).isEqualTo(1);
    }
    @Test
    void FivePerson(){
        int height = 5, numberOfPerson = 5;
        Ladder ladder = new Ladder(height, numberOfPerson);
        ladder.drawLine(new Position(0, 0), 1);
        ladder.drawLine(new Position(1, 1), 1);
        ladder.drawLine(new Position(2, 1), -1);
        ladder.drawLine(new Position(2, 3), -1);
        ladder.drawLine(new Position(3, 1), 1);
        ladder.drawLine(new Position(3, 4), -1);
        ladder.drawLine(new Position(4, 2), 1);
        ladder.drawLine(new Position(4, 0), 1);

        int result = ladder.run(3); // 2
        assertThat(result).isEqualTo(0);  // 1
    }
}