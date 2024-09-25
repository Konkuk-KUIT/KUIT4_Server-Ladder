package ladder;

import ladder.info.LadderSize;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static ladder.OutputCapture.normalizeOutput;
import static org.assertj.core.api.Assertions.*;

class LadderGameTest {


    @Test
    void 사다리_사용자생성_확인() {

        //given
        LadderSize ladderSize = LadderSize.of(3,5);

        //when
        LadderGame ladderGame =LadderGameFactory.createInputLadderGame(ladderSize);

        //then
        assertThat(ladderGame).isNotNull();
    }

    @Test
    void 사다리_랜덤생성_확인() {

        //given
        LadderSize ladderSize = LadderSize.of(3,5);

        //when
        LadderGame ladderGame =LadderGameFactory.createRandomLadderGame(ladderSize);

        //then
        assertThat(ladderGame).isNotNull();
    }

    @Test
    void 사다리_사람_예외_처리_확인() {

        //given
        LadderSize ladderSize = LadderSize.of(2,3);
        LadderGame ladderGame =LadderGameFactory.createInputLadderGame(ladderSize);

        //when
        Position position = Position.of(0,4);

        //then
        assertThatThrownBy(() -> ladderGame.run(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자입력사다리_결과_확인() {

        //given
        LadderSize ladderSize = LadderSize.of(3,4);
        LadderGame ladderGame =LadderGameFactory.createInputLadderGame(ladderSize);

        ladderGame.getLadderCreator().drawLine(Position.of(0,0));
        ladderGame.getLadderCreator().drawLine(Position.of(1,1));
        ladderGame.getLadderCreator().drawLine(Position.of(2,0));

        //when
        Position position = Position.of(0,0);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(2);

        //when
        position =  Position.of(0,1);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(1);

        //when
        position =  Position.of(0,2);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(0);
    }

    //랜덤사다리와 일반사다리의 차이점이 라인생성부분인데 그부분을.. 어떻게 테스트할지 감이안와서..
    //그냥 좀 무식하게 100번돌렸을때 예외가 안터지면 성공이아닐까...로 생각해봤습니다
    @RepeatedTest(100)
    void 랜덤사다리_라인생성_확인() {
        // given
        LadderSize ladderSize = LadderSize.of(3, 4);
        LadderGame ladderGame =LadderGameFactory.createRandomLadderGame(ladderSize);

        // when & then
        assertThatNoException().isThrownBy(() -> {
            ladderGame.getLadderCreator().drawLine(ladderSize);
        });
    }

    @Test
    void 사용자입력사다리_라인그리기_예외_확인() {

        //given
        LadderSize ladderSize = LadderSize.of(3,4);
        LadderGame ladderGame =LadderGameFactory.createInputLadderGame(ladderSize);

        // when & then
        assertThatThrownBy(() -> ladderGame.getLadderCreator().drawLine(ladderSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤사다리_라인그리기_예외_확인() {

        //given
        LadderSize ladderSize = LadderSize.of(3,4);
        LadderGame ladderGame =LadderGameFactory.createRandomLadderGame(ladderSize);

        // when & then
        assertThatThrownBy(() -> ladderGame.getLadderCreator().drawLine(Position.of(0,0)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 사다리_출력_확인() {

        //given
        LadderSize ladderSize = LadderSize.of(3,4);
        LadderGame ladderGame =LadderGameFactory.createInputLadderGame(ladderSize);

        OutputCapture outputCapture = new OutputCapture();
        outputCapture.start(); // 출력 캡처 시작

        ladderGame.getLadderCreator().drawLine(Position.of(0,0));
        ladderGame.getLadderCreator().drawLine(Position.of(1,1));
        ladderGame.getLadderCreator().drawLine(Position.of(2,0));

        // when
        ladderGame.run(Position.of(0,0));

        // then
        String output = outputCapture.stop(); // 출력 캡처 중지

        // 예상 출력 형식
        String expectedOutput = "Before\n" +
                "1* -1 0 0\n" +
                "0 1 -1 0\n" +
                "1 -1 0 0\n" +
                "\n" +
                "After\n" +
                "1 -1* 0 0\n" +
                "0 1 -1 0\n" +
                "1 -1 0 0\n" +
                "\n" +
                "Before\n" +
                "1 -1 0 0\n" +
                "0 1* -1 0\n" +
                "1 -1 0 0\n" +
                "\n" +
                "After\n" +
                "1 -1 0 0\n" +
                "0 1 -1* 0\n" +
                "1 -1 0 0\n" +
                "\n" +
                "Before\n" +
                "1 -1 0 0\n" +
                "0 1 -1 0\n" +
                "1 -1 0* 0\n" +
                "\n" +
                "After\n" +
                "1 -1 0 0\n" +
                "0 1 -1 0\n" +
                "1 -1 0* 0\n";

        // 공백 및 줄바꿈 정리 후 비교
        assertThat(normalizeOutput(output)).isEqualTo(normalizeOutput(expectedOutput));
    }

}