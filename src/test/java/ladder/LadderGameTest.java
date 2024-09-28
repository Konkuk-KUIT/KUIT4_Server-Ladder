package ladder;

import ladder.creator.LadderAutoCreator;
import ladder.creator.LadderUserCreator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderUserCreator ladderUserCreator = new LadderUserCreator(numberOfRow, numberOfPerson);

        //then
        assertThat(ladderUserCreator).isNotNull();
    }

    @Test
    void 사다리_사람_예외_처리_확인() {
        //when
        GreaterThanOne row=GreaterThanOne.from(2);
        GreaterThanOne numberOfPerson=GreaterThanOne.from(3);
        LadderUserCreator ladderUserCreator = new LadderUserCreator(row, numberOfPerson);
        LadderRunner ladderRunner =new LadderRunner(ladderUserCreator.getRows());
        //given
        Position nthOfPerson = Position.from(4);
        //예외 확인하는거라 만들다 끊겨지는구나 ->어케 처리할지?
        //then

        assertThatThrownBy(() -> ladderRunner.run(nthOfPerson))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_결과_확인() {
        //when
        GreaterThanOne row=GreaterThanOne.from(4);
        GreaterThanOne numberOfPerson=GreaterThanOne.from(3);
        LadderUserCreator ladderUserCreator = new LadderUserCreator(row, numberOfPerson);

        ladderUserCreator.drawLine(Position.from(0),Position.from(0));
        ladderUserCreator.drawLine(Position.from(1),Position.from(1));
        ladderUserCreator.drawLine(Position.from(2),Position.from(0));
        LadderRunner ladderRunner =new LadderRunner(ladderUserCreator.getRows());

        //given
        Position nthOfPerson = Position.from(0);

        //then
        assertThat(ladderRunner.run(nthOfPerson)).isEqualTo(2);

        //given
        nthOfPerson = Position.from(1);

        //then
        assertThat(ladderRunner.run(nthOfPerson)).isEqualTo(1);

        //given
        nthOfPerson = Position.from(2);
        //then2
        assertThat(ladderRunner.run(nthOfPerson)).isEqualTo(0);
    }

    @Test
    void 자동사다리_drawline_개수확인() {
        //when
        GreaterThanOne row=GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson=GreaterThanOne.from(5);
        LadderSize ladderSize=new LadderSize(row,numberOfPerson);
        LadderAutoCreator autoCreator=new LadderAutoCreator(ladderSize);

        assertThat(autoCreator.getCreatedLadderLineNumber()).isEqualTo(4);
        //drawLine의 개수 확인
    }
    @Test
    void 자동사다리_확인_minimum() {
        //when
        LadderSize ladderSize=new LadderSize(GreaterThanOne.from(2),GreaterThanOne.from(2));
        LadderAutoCreator autoCreator=new LadderAutoCreator(ladderSize);
        LadderRunner ladderRunner =new LadderRunner(autoCreator.getRows());

        ladderRunner.run(Position.from(1));

        assertThat(ladderRunner.run(Position.from(0))).isEqualTo(1);
}
    @Test
    void 자동사다리_확인_3_5() {
        //when
        GreaterThanOne row=GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson=GreaterThanOne.from(5);
        LadderSize ladderSize=new LadderSize(row,numberOfPerson);
        LadderAutoCreator autoCreator=new LadderAutoCreator(ladderSize);
        LadderRunner ladderRunner =new LadderRunner(autoCreator.getRows());

        ladderRunner.run(Position.from(1));

        //drawLine의 case를 확인해바야함
    }

    @Test
    void 자동사다리_확인_minimum_LadderGame적용() {
        //when
        LadderSize ladderSize=new LadderSize(GreaterThanOne.from(2),GreaterThanOne.from(2));
        LadderAutoCreator autoCreator=new LadderAutoCreator(ladderSize);
        LadderGame ladderGame=new LadderGame(autoCreator);

        //사다리 한 개니까 무조건 반대로 나와야 성공

        assertThat(ladderGame.run(Position.from(0))).isEqualTo(1);
    }

}
