package second;

public class MovePostion {
    private int nowRow;
    private int nowCol;
    private Ladder ladder;

    public MovePostion(int nowRow, int nowCol, Ladder ladder) {
        this.nowRow = nowRow;
        this.nowCol = nowCol;
        this.ladder = ladder;
    }

    public boolean isGameEnd(){
        return nowRow == ladder.rows.length-1;
    }

    public void move(){
        if(ladder.rows[nowRow][nowCol] == 0){
            moveDown();
            return;
        }
        if(ladder.rows[nowRow][nowCol] == -1){
            moveLeft();
            return;
        }
        if(ladder.rows[nowRow][nowCol] == 1){
            moveRight();
        }
    }

    private void moveDown(){
        if(nowRow == ladder.rows.length-1) throw new ArrayIndexOutOfBoundsException();
        nowRow++;
    }

    private void moveLeft(){
        if(nowCol == 0 || nowRow == ladder.rows.length-1) throw new ArrayIndexOutOfBoundsException();
        nowRow++;
        nowCol--;
    }

    private void moveRight(){
        if(nowCol == ladder.rows[0].length || nowRow == ladder.rows.length-1) throw new ArrayIndexOutOfBoundsException();
        nowRow++;
        nowCol++;
    }

    public int getNowCol() {
        return nowCol;
    }
}
