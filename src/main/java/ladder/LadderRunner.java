package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            System.out.println("Before");
            printLadder(position, i);
            System.out.println();

            rows[i].nextPosition(position);

            System.out.println("After");
            printLadder(position, i);
            System.out.println();
        }
        return position.getPosition();
    }

    private void printLadder(Position position, int currentRow) {
        StringBuilder ladderBuilder = new StringBuilder();

        for (int i = 0; i < rows.length; i++) {
            ladderBuilder.append(rows[i].printRow(position, i == currentRow));
            ladderBuilder.append("\n");
        }

        System.out.print(ladderBuilder.toString());
    }
}
