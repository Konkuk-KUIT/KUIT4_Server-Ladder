public class Line {
    private int fromLine;
    private int toLine;
    private int t;
    private int[][] rows;

    public Line(int fromLine, int toLine, int currentRow, int[][] rows) {
        sort(fromLine, toLine);
        this.rows = rows;

        if (validateFromLine(rows) && currentRow >= 0 && validateCurrentRow(currentRow, rows)) {
            this.rows[currentRow][this.fromLine] = 1;
        }
        if (validateToLine(rows) && currentRow >= 0 && validateCurrentRow(currentRow, rows)) {
            this.rows[currentRow][this.toLine] = - 1;
        }
    }

    private static boolean validateCurrentRow(int currentRow, int[][] rows) {
        if(currentRow < rows.length){
            return true;
        }
        else{
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LINE_POSITION.getMessage());
        }
    }

    private boolean validateToLine(int[][] rows) {
        if(this.toLine >= 0 && this.toLine <= rows[0].length){
            return true;
        }
        else{
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LINE_POSITION.getMessage());
        }
    }

    private boolean validateFromLine(int[][] rows) {
        if(this.fromLine >= 0 && this.fromLine <= rows[0].length){
            return true;
        }
        else{
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LINE_POSITION.getMessage());
        }
    }

    public void sort(int x, int y) {
        this.fromLine = x;
        this.toLine = y;

        if (this.fromLine > this.toLine) {
            this.t = y;
            this.toLine = x;
            this.fromLine = t;
        }
    }

}