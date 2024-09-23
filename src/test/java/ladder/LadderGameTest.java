package ladder;

import ladder.creator.LadderCreator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {

        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);

        //then
        assertThat(ladderCreator).isNotNull();
    }

    @Test
    void 사다리_사람_예외_처리_확인() {

        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderCreator ladderCreator = new LadderCreator(GreaterThanOne.from(2), numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //given
        Position position = Position.from(4);

        //then
        assertThatThrownBy(() -> ladderGame.run(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_결과_확인() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);
        LadderCreator ladderCreator = new LadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.from(0),Position.from(0));
        ladderCreator.drawLine(Position.from(1),Position.from(1));
        ladderCreator.drawLine(Position.from(2),Position.from(0));

        //given
        Position position = Position.from(0);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(2);

        //given
        position = Position.from(1);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(1);

        //given
        position = Position.from(2);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(0);
    }

    @Test
    void 사다리_출력_확인() {

        //given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);
        LadderCreator ladderCreator = new LadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);
        StringBuilder line = new StringBuilder();
        OutputCapture outputCapture = new OutputCapture();
        outputCapture.start(); // 출력 캡처 시작

        // when
        ladderCreator.drawLine(Position.from(0),Position.from(0));
        ladderCreator.drawLine(Position.from(1),Position.from(1));
        ladderCreator.drawLine(Position.from(2),Position.from(0));

        Position position = Position.from(0);
        ladderGame.run(position);

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

    private String normalizeOutput(String output) {
        // 줄바꿈과 공백을 정리
        return output.replaceAll("\\s+", " ")
                .replaceAll(" +", " ")
                .trim();
    }

}