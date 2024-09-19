package third;

public class LadderGameController {
    private Position nowPosition;
    private LadderWrapper ladder; //게임판 역할을 하는 LadderWrapper 객체

    public LadderGameController(LadderWrapper ladder) {
        this.ladder = ladder;
    }

    public void drawline(Position pos1, Position pos2){
        validatePostionPair(pos1, pos2);
        if(pos1.getCol() < pos2.getCol()) {
            ladder.setValue(pos1, 1);
            ladder.setValue(pos2, -1);
        }
        if(pos1.getCol() > pos2.getCol()) {
            ladder.setValue(pos1, -1);
            ladder.setValue(pos2, 1);
        }
    }

    public int run(int startCol){
        this.nowPosition = new Position(0, startCol-1);
        while(!isGameEnd()) {
            move();
        }
        return nowPosition.getCol()+1;
    }

    private void validatePostionPair(Position pos1, Position pos2){
        // 서로 인접한 Postion 인지 확인
        if(pos1.getRow() != pos2.getRow()) throw new IllegalArgumentException();
        if(Math.abs(pos1.getCol() - pos2.getCol())!= 1) throw new IllegalArgumentException();
    }

    private boolean isGameEnd(){
        return nowPosition.getRow() == ladder.getRows()-1;
    }

    private void move(){
        if(ladder.getValue(nowPosition) == 0) nowPosition.moveDown();
        if(ladder.getValue(nowPosition) == 1) nowPosition.moveRight();
        if(ladder.getValue(nowPosition) == -1) nowPosition.moveLeft();
    }
}
