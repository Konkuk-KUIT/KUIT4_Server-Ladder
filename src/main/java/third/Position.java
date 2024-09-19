package third;

public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void moveDown(){
        row++;
    }

    public void moveRight(){
        row++;
        col++;
    }

    public void moveLeft(){
        row++;
        col--;
    }
}
