public class RunGame {
    private Row[] rows;

    public RunGame(Row[] rows) {
        this.rows = rows;
    }

    public int run(int startLine) {
        Index col = Index.from(startLine);
        for (int row = 0; row < rows.length; row++) {
            System.out.println("Before");
            PrintLadder(row, col.getNumber());

            if (rows[row].getValue(col).isZero()) { continue; }
            col.move(rows[row].getValue(col).getDirection());

            System.out.println("After");
            PrintLadder(row, col.getNumber());
        }
        return col.getNumber();
    }

    public void PrintLadder(int row, int col) {
        for (int i=0; i < rows.length; i++) {
            if (i==row) {rows[i].PrintRowWithStar(col); continue;}
            rows[i].PrintRow(col);
        }
        System.out.println();
    }

}
