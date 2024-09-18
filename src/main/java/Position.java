public class Position {

    private int row;
    private int col;

    public static Position createPosition(int row, int col) {
       Position position =new Position(row,col);
       return position;
    }

    private Position(int row, int col){
        if(row < 0 || col < 0){
            throw new IllegalArgumentException("행렬값은 음수값이 될 수 없습니다.");
        }
        this.row=row;
        this.col=col;
    }

    public int getRow() {
        return row;
    }

    public int getCol()
    {
        return col;
    }



}
