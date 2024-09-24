package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position positionX) {

        LadderDraw ladderDraw = new LadderDraw(rows);

        for (int i = 0; i < rows.length; i++) {
            ladderDraw.drawLadderState(positionX,Position.from(i),"Before");
            rows[i].nextPosition(positionX);
            ladderDraw.drawLadderState(positionX,Position.from(i),"After");
        }
        return positionX.getPosition();
    }
}
