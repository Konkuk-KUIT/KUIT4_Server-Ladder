package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        LadderPosition currentPosition = new LadderPosition(Position.from(0), position);
        for (Row row : rows) {
            printBeforeLadder(currentPosition);
            row.nextPosition(currentPosition.getCol());
            printAfterLadder(currentPosition);
            currentPosition.moveDown();
        }
        return position.getValue();
    }
    private void printBeforeLadder(LadderPosition currentPosition){
        System.out.println("Before");
        printLadder(currentPosition);

    }
    private void printAfterLadder(LadderPosition currentPosition){
        System.out.println("After");
        printLadder(currentPosition);
    }

    private void printLadder(LadderPosition currentPosition){
        for (int i = 0; i < rows.length; i++) {
            if (currentPosition.getRow().getValue() == i) {
                System.out.println(rows[i].toString(currentPosition));
            }
            else {
                System.out.println(rows[i].toString());
            }
        }
        System.out.println();
    }
}
