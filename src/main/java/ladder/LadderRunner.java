package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public void printRow(int rowNumber, int position, int currentRow) {
        boolean isCurrent = (currentRow == rowNumber);
        System.out.println(rows[rowNumber].rowToString(position, isCurrent));
    }

    public void printLadder(int row, int position){
        for (int i = 0; i < rows.length; i++) {
            printRow(i, position, row);
        }
        System.out.println();
    }
    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {

            System.out.println("Before");
            printLadder(i, position.getValue());

            rows[i].nextPosition(position);

            System.out.println("After");
            printLadder(i, position.getValue());
        }
        return position.getValue();
    }

}
