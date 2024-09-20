
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class LadderTest {
    @Test
    public void createLadder() throws NaturalNumberException {
        Ladder ladder = new Ladder(NaturalNumber.from(1), NaturalNumber.from(1));
        assertThat(ladder.getDistance(new Position(NaturalNumber.from(1), NaturalNumber.from(1)))).isEqualTo(0);
    }

    @Test
    public void drawLadder() throws NaturalNumberException {
        // given
        Ladder ladder = new Ladder(NaturalNumber.from(4), NaturalNumber.from(4));
        Position pos1 = new Position(NaturalNumber.from(1),NaturalNumber.from(1));
        Position pos2 = new Position(NaturalNumber.from(1),NaturalNumber.from(2));

        // when
        ladder.drawLine(pos1, pos2);

        //then
        assertThat(ladder.getDistance(pos1)).isEqualTo(1);
        assertThat(ladder.getDistance(pos2)).isEqualTo(-1);

    }

    @Test
    public void runLadderEx1() throws NaturalNumberException {
        // given
        Ladder ladder = new Ladder(NaturalNumber.from(3), NaturalNumber.from(3));

        assertThat(ladder.run(NaturalNumber.from(1))).isEqualTo(1);
        assertThat(ladder.run(NaturalNumber.from(2))).isEqualTo(2);
        assertThat(ladder.run(NaturalNumber.from(3))).isEqualTo(3);

    }

    @Test
    public void runLadderEx2() throws NaturalNumberException {
        // given
        Ladder ladder = new Ladder(NaturalNumber.from(3), NaturalNumber.from(3));
        Position pos1 = new Position(NaturalNumber.from(1),NaturalNumber.from(1));
        Position pos2 = new Position(NaturalNumber.from(1),NaturalNumber.from(2));
        Position pos3 = new Position(NaturalNumber.from(2),NaturalNumber.from(1));
        Position pos4 = new Position(NaturalNumber.from(2),NaturalNumber.from(2));
        Position pos5 = new Position(NaturalNumber.from(3),NaturalNumber.from(2));
        Position pos6 = new Position(NaturalNumber.from(3),NaturalNumber.from(3));

        ladder.drawLine(pos1, pos2);
        ladder.drawLine(pos3, pos4);
        ladder.drawLine(pos5, pos6);


        assertThat(ladder.run(NaturalNumber.from(1))).isEqualTo(1);
        assertThat(ladder.run(NaturalNumber.from(2))).isEqualTo(3);
        assertThat(ladder.run(NaturalNumber.from(3))).isEqualTo(2);

    }
}