package first;

public class PositionP {
    private int rowNum;
    private int colNum;

    public PositionP(int row, int col) {
        this.rowNum = row;
        this.colNum = col;
    }

    public int getRowNum() {
        return rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public boolean atStartRow(){
        return this.rowNum == 0;
    }

    public boolean atEndRow(int numOfRow){
        return this.rowNum == numOfRow-1;
    }

    public boolean isNotVaildRow(int numOfRow){
        return this.rowNum <= -1 || this.rowNum >= numOfRow;
    }

    public boolean isNotVaildCol(int numOfPeople){
        return this.colNum <= 0 || this.colNum >= numOfPeople+1;
    }

    public boolean isUsedPosition(int[][] rows) {
        return rows[rowNum][colNum] == 1;
    }

    public void move(int[][] rows) {
        if(rows[rowNum][colNum] != 1){
            rowNum++;
            return;
        }
        if(rows[rowNum][colNum+1] == 1){
            colNum++; rowNum++;
            return;
        }
        if(rows[rowNum][colNum-1] == 1){
            colNum--; rowNum++;
        }
    }
}
