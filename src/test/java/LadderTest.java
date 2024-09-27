import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    void createLadder() {
        LadderCreator ladderCreator = new LadderCreator(Index.from(5), Index.from(7), false);

        Row[] rows = ladderCreator.getRow();

        Assertions.assertThat(rows.length).isEqualTo(5);
        Assertions.assertThat(rows[0].getPeopleNum()).isEqualTo(7);
    }

    @Test
    void drawLine() {
        LadderCreator ladderCreator = new LadderCreator(Index.from(5), Index.from(7), false);

        PositionOfLine position = PositionOfLine.of(Index.from(3), Index.from(2));

        ladderCreator.drawLine(position);

        Assertions.assertThat(ladderCreator.LineAlreadyExisting(position.getX(), position.getY())).isEqualTo(true);
    }

    @Test
    void 줄_중복_생성_예외() {
        LadderCreator ladderCreator = new LadderCreator(Index.from(5), Index.from(7), false);

        ladderCreator.drawLine(PositionOfLine.of(Index.from(0), Index.from(0)));
        Assertions.assertThat(ladderCreator.canDrawLine(PositionOfLine.of(Index.from(0), Index.from(1)))).isEqualTo(false);
    }

    @Test
    void LadderGame() {
        LadderCreator ladderCreator = new LadderCreator(Index.from(5), Index.from(7), false);

        ladderCreator.drawLine(PositionOfLine.of(Index.from(0), Index.from(0)));
        ladderCreator.drawLine(PositionOfLine.of(Index.from(1), Index.from(1)));
        ladderCreator.drawLine(PositionOfLine.of(Index.from(1), Index.from(3)));
        ladderCreator.drawLine(PositionOfLine.of(Index.from(2), Index.from(0)));
        ladderCreator.drawLine(PositionOfLine.of(Index.from(2), Index.from(2)));
        ladderCreator.drawLine(PositionOfLine.of(Index.from(3), Index.from(0)));
        ladderCreator.drawLine(PositionOfLine.of(Index.from(3), Index.from(4)));
        ladderCreator.drawLine(PositionOfLine.of(Index.from(4), Index.from(2)));
        ladderCreator.drawLine(PositionOfLine.of(Index.from(4), Index.from(5)));

        RunGame gameRunner = new RunGame(ladderCreator.getRow());

        int end = gameRunner.run(0);

        Assertions.assertThat(end).isEqualTo(2);
    }

    @Test
    void RandomLadderGame() {
        LadderCreator ladderCreator = new LadderCreator(Index.from(5), Index.from(7), true);

        RunGame gameRunner = new RunGame(ladderCreator.getRow());

        gameRunner.run(0);
    }
}