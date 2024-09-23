package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        LadderViewer ladderViewer = new LadderViewer(rows);
        for (int i = 0; i < rows.length; i++) {
            ladderViewer.printLadderStatus(LadderPosition.of(Position.from(i), position));
            rows[i].nextPosition(position);
            ladderViewer.printLadderStatus(LadderPosition.of(Position.from(i), position));
        }
        return position.getValue();
    }
}
