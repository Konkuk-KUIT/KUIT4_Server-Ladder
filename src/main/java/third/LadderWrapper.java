package third;

public class LadderWrapper {
    private final int[][] rows;

    private LadderWrapper(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    public static LadderWrapper rowPersonOf(int row, int numberOfPerson){
        return new LadderWrapper(row, numberOfPerson);
    }

    public int getValue(Position pos){
        int row = pos.getRow();
        int col = pos.getCol();
        validatePosition(row, col);
        return rows[row][col];
    }

    public void setValue(Position pos, int value){
        int row = pos.getRow();
        int col = pos.getCol();
        validatePosition(row, col);
        checkUsedPosition(row, col);
        rows[row][col] = value;
    }

    public int getRows(){
        return rows.length;
    }

    private void validatePosition(int row, int col){
        if(row <= -1 || row >= rows.length) throw new IllegalArgumentException();
        if(col <= -1 || col >= rows[0].length) throw new IllegalArgumentException();
    }

    private void checkUsedPosition(int row, int col){
        if(rows[row][col] != 0) throw new IllegalArgumentException();
    }
}
