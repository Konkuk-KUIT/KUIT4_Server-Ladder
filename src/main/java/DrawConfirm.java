public class DrawConfirm {

    private final int[][] rows;
    private final int row;
    private final int numberOfPerson;

    public DrawConfirm(int[][] rows, int row, int numberOfPerson) {
        this.rows = rows;
        this.row = row;
        this.numberOfPerson = numberOfPerson;
    }

    public boolean confirm(int row, int column){
        //선을 그리는 범위가 벗어나는 것을 방지
        if (row >= this.row || column >= this.numberOfPerson - 1) {
            return false;
        }
        
        //선을 그리려는 곳에 이미 선이 있는 상황을 방지
        if (this.rows[row][column] == 1) {
            return false;
        }

        //연속가로선 방지
        if (column > 0 && rows[row][column - 1] == 1) {
            return false;
        }
        //연속 가로선 방지
        if (column < this.numberOfPerson - 2 && rows[row][column + 1] == 1) {
            return false;
        }

        return true;
    }


}
