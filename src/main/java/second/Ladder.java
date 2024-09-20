package second;

public class Ladder {

    public final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    public void drawline(int row1, int col1, int row2, int col2){
        DrawPosition pos1 = new DrawPosition(row1, col1, this);
        DrawPosition pos2 = new DrawPosition(row2, col2, this);
        validatePositionPair(pos1, pos2);
        if(pos1.getCol()+1 == pos2.getCol()) {
            rows[pos1.getRow()][pos1.getCol()] = 1;
            rows[pos2.getRow()][pos2.getCol()] = -1;
        }
        if(pos1.getCol()-1 == pos2.getCol()) {
            rows[pos1.getRow()][pos1.getCol()] = -1;
            rows[pos2.getRow()][pos2.getCol()] = 1;
        }
    }

    public int run(int startCol){
        if(startCol <= 0 || startCol > rows[0].length) throw new IllegalArgumentException();
        MovePostion movePostion = new MovePostion(0, startCol-1, this);
        while(!movePostion.isGameEnd()){
            movePostion.move();
        }
        return movePostion.getNowCol()+1;
    }

    private void validatePositionPair(DrawPosition pos1, DrawPosition pos2){
        //같은 행에 있지 않은 Position
        if(pos1.getRow() != pos2.getRow()) throw new IllegalArgumentException();
        //인접한 열에 있지 않은 Position
        if(Math.abs(pos1.getCol() - pos2.getCol()) != 1) throw new IllegalArgumentException();
    }
}
