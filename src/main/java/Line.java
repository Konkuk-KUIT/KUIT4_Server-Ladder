public class Line {

    private int x;
    private int y;
    private int t;
    private int[][] rows;

    public Line(int x, int y, int i, int[][] rows) {

        sort(x, y);
        this.rows=rows;

        if (this.x >= 0 && this.x <= rows.length && i >= 0 && i < rows[0].length) {
            this.rows[i][this.x - 1] = 1;
        }
        if (this.y >= 0 && this.y <= rows.length && i >= 0 && i < rows[0].length) {
            this.rows[i][this.y -1] = 1;
        }

    }

    public void sort(int x, int y) {

        this.x=x;
        this.y=y;

        if (this.x > this.y) {
            this.t = y;
            this.y = x;
            this.x = t;
        }
    }
}
