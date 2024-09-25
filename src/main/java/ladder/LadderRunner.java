package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public void run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            System.out.println("Running row " + i + ", position: " + position.getValue());
            rows[i].nextPosition(position);

        }
        //return position.getValue();
    }
}
