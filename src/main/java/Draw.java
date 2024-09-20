class Draw {
    private int row, col;
    private int[][] rows;

    public Draw(int[][] rows, int row, int col) {
        this.rows = rows;
        this.row = row;
        this.col = col;
    }

    public boolean canDrawLine(int row, int position) {
        if (row < 0 || row >= this.row || position < 0 || position >= this.col - 1) {
            return false;
        }
        // 이미 선이 그어져 있으면 그릴 수 없음
        if (rows[row][position] == 1) {
            return false;
        }
        // 인접한 위치에 선이 있으면 그릴 수 없음 ( 중복선 방지 )
        if (position > 0 && rows[row][position - 1] == 1) {
            return false;
        }
        else if (position < this.col - 2 && rows[row][position + 1] == 1) {
            return false;
        }
        return true;
    }

    //사다리 출력
    public void printLadder() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("|");
                if (j < col - 1) {
                    System.out.print(rows[i][j] == 1 ? "--" : "  ");
                }
            }
            System.out.println();
        }
    }
}