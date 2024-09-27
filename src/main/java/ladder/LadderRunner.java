package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {

            StringBuilder sbBefore = new StringBuilder("Before\n");
            printLadder(sbBefore, GreaterThanOne.from(rows.length), position, i);  // Pass current row index
            System.out.println(sbBefore);

            rows[i].nextPosition(position);

            StringBuilder sbAfter = new StringBuilder("After\n");
            printLadder(sbAfter, GreaterThanOne.from(rows.length), position, i);  // Pass current row index
            System.out.println(sbAfter);
        }

        return position.getValue();
    }

    private void printLadder(StringBuilder sb, GreaterThanOne numberOfRows, Position position, int currentRowIndex) {
        for (int rowIndex = 0; rowIndex < rows.length; rowIndex++) {
            if (rowIndex == currentRowIndex) {
                rows[rowIndex].printCurrentRow(sb, numberOfRows, position);
            } else {
                rows[rowIndex].printRow(sb, numberOfRows);
            }
            sb.append("\n");
        }
    }
}
