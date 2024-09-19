package second;

public class LadderOrigin {

    public final int[][] rows;

    public LadderOrigin(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    public void drawline(int row1, int col1, int row2, int col2){
        if(col1+1 == col2) {
            rows[row1][col1] = 1;
            rows[row2][col2] = -1;
        }
        if(col1-1 == col2) {
            rows[row1][col1] = -1;
            rows[row2][col2] = 1;
        }
    }

    public int run(int i){
        int nRow = 0; int nCol = i-1;
        while(nRow != rows.length-1){
            if(rows[nRow][nCol] == 0) nRow++;
            if(rows[nRow][nCol] == 1) { nCol++; nRow++; }
            if(rows[nRow][nCol] == -1) { nCol--; nRow++; }
        }
        return nCol+1;
    }
}
