public class Position {
    private int rowNum;
    private int colNum;
    private Ladder ladder;

    public Position(int row, int col, Ladder ladder) {
        this.rowNum = row;
        this.colNum = col;
        this.ladder = ladder;
    }
}
