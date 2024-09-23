package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position x) {

        LadderDraw ladderDraw = new LadderDraw(rows);

        for (int i = 0; i < rows.length; i++) {
            ladderDraw.drawLadderState(x.getX(),i,"Before");
            rows[i].nextPosition(x);
            ladderDraw.drawLadderState(x.getX(),i,"After");
        }
        return x.getX();
    }
}
