package ladder;

import ladder.creator.LadderRandomCreator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class LadderRandomTest {
    @Test
    void 사다리_자동_생성_확인() {
        // given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);

        // when
        LadderRandomCreator ladderRandomCreator = new LadderRandomCreator(new LadderSize(numberOfRow, numberOfPerson));

        // then
        assertThat(ladderRandomCreator).isNotNull();
    }

    @Test
    void 사다리_사람_예외_처리_확인() {
        //when
        GreaterThanOne numberOfRow = GreaterThanOne.from(2);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderRandomCreator ladderRandomCreator = new LadderRandomCreator(new LadderSize(numberOfRow, numberOfPerson));
        LadderRunner ladderRunner = new LadderRunner(ladderRandomCreator.getRows());


        //given
        Position nthOfPerson = Position.from(4);

        //then
        assertThatThrownBy(() -> ladderRunner.run(nthOfPerson))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    // todo test통과할 때가 있고 안될때가 있다...
    void 사다리_결과_확인() { // 출력결과 포함
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        LadderRandomCreator ladderRandomCreator = new LadderRandomCreator(new LadderSize(numberOfRow, numberOfPerson));
        LadderRunner ladderRunner = new LadderRunner(ladderRandomCreator.getRows());

        ladderRandomCreator.makeRandomLine();

        //given
        Position nthOfPerson = Position.from(0);

        //then
        // 눈으로 테스트하는게 제일 직관적이겠지만, numberOfPerson 사이에 결과가 있어야하는 건 자명하니, isBetween 메소드 사용
        assertThat(ladderRunner.run(nthOfPerson)).isBetween(0,3);

        //given
        nthOfPerson = Position.from(1);

        //then
        assertThat(ladderRunner.run(nthOfPerson)).isBetween(0,3);

        //given
        nthOfPerson = Position.from(2);

        //then
        assertThat(ladderRunner.run(nthOfPerson)).isBetween(0,3);
    }
}
