public class RunGame {
    private Row[] rows;

    public RunGame(Row[] rows) {
        this.rows = rows;
    }

    public int run(int startLine) {
        Index col = Index.from(startLine);
        for (int row = 0; row < rows.length; row++) {
            PrintLadder(row, col.getNumber());

            if (rows[row].getValue(col).isZero()) { continue; }
            col.move(rows[row].getValue(col).getDirection());      // 1, -1: 상수 or enum 사용
        }
        return col.getNumber();
    }

    public void PrintLadder(int row, int col) {
        for (int i=0; i < rows.length; i++) {
            if (i==row) {rows[i].PrintRowWithStar(col);}
            rows[i].PrintRow(col);
        }
    }


}
