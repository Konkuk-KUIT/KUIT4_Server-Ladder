import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class LadderTest {


    @Test
    @DisplayName("사다리 행 생성 오류 검증")
    void drawLineRowErrorTest() {
        assertThatThrownBy(() -> new Ladder(Row.from(0), NumberOfPerson.from(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 열 생성 오류 검증")
    void drawLineColErrorTest() {
        assertThatThrownBy(() -> new Ladder(Row.from(1), NumberOfPerson.from(0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 모호성 검증")
    void drawLineAmbiguousTest() {

        //given
        Ladder ladder = new Ladder(Row.from(2), NumberOfPerson.from(3));

        //when
        ladder.drawLine(new Position(Row.from(1), Col.from(3)));

        //then
        assertThatThrownBy(() -> ladder.drawLine(new Position(Row.from(1), Col.from(2))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("실행 함수 실패 사례 검증")
    void runFailedTest() {
        Ladder ladder = new Ladder(Row.from(5), NumberOfPerson.from(5));

        assertThatThrownBy(() -> ladder.run(Col.from(6))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("실행 함수 성공 사례 검증")
    void runSuccessTest() {

        //given
        Ladder ladder = new Ladder(Row.from(5), NumberOfPerson.from(5));


        //when
        ladder.drawLine(new Position(Row.from(1), Col.from(2)));
        ladder.drawLine(new Position(Row.from(2), Col.from(3)));
        ladder.drawLine(new Position(Row.from(3), Col.from(4)));
        ladder.drawLine(new Position(Row.from(4), Col.from(5)));


        //then
        assertThat(ladder.run(Col.from(1))).isEqualTo(5);

    }

    @Test
    @DisplayName("한 줄짜리 사다리 실행 검증")
    void runOnlyOneLadderTest() {
        //given
        Ladder ladder = new Ladder(Row.from(1), NumberOfPerson.from(1));

        assertThat(ladder.run(Col.from(1))).isEqualTo(1);
    }


}