package second;

public class DrawPosition {
    private int row;
    private int col;
    private Ladder ladder;

    public DrawPosition(int row, int col, Ladder ladder){
        validatePosition(row, col, ladder);
        this.row = row;
        this.col = col;
        this.ladder = ladder;
    }

    private void validatePosition(int inputRow, int inputCol, Ladder inputLadder){
        // row 범위 초과
        if(inputRow <= -1 || inputRow >= inputLadder.rows.length) throw new IllegalArgumentException();
        // col 범위 초과
        if(inputCol <= -1 || inputCol >= inputLadder.rows[0].length) throw new IllegalArgumentException();
        // 0이 아니면 쓰인 자리니까
        if(inputLadder.rows[inputRow][inputCol] != 0) throw new IllegalArgumentException();
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
