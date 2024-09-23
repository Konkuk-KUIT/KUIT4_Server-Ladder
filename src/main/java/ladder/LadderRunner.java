package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {

        for (int i = 0; i < rows.length; i++) {

            printWholeLine(Position.from(i), position);
            rows[i].nextPosition(position);
            printWholeLine(Position.from(i), position);

        }

        return position.getValue();
    }

    private void printWholeLine(Position row, Position col) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows.length; i++) {
            if(i == row.getValue()) {
                sb.append(rows[i].printAsteroidLine(col)).append("\n");
                continue;
            }

            sb.append(rows[i].printNormalLine()).append("\n");
        }

        System.out.println(sb);
    }
}
