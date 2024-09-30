package ladder;

public class LadderRunner {

    private final Row[] rows;
    private final LadderPrinter printer;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
        this.printer = new LadderPrinter(rows);
    }

    public int run(Position position) {
        System.out.println("사다리 게임 시작");

        for (int i = 0; i < rows.length; i++) {
            printer.printLadder(position, i, false); //Before 출력
            rows[i].nextPosition(position);
            printer.printLadder(position, i, true);  //After 출력
        }

        return position.getValue();
    }
}