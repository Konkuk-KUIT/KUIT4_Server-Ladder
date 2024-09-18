public class LadderP {

    public final int[][] rows;
    private final int numOfRow;
    private final int numOfPeople;

    public LadderP(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson+2];
        numOfRow = row;
        numOfPeople = numberOfPerson;
    }

    private void checkValidPosition(PositionP position){
        if(position.atStartRow() || position.atEndRow(numOfRow)){
            throw new IllegalArgumentException("첫 줄과 마지막 줄에는 선을 그을 수 없습니다.");
        }
        if(position.isNotVaildRow(numOfRow)){
            throw new IllegalArgumentException("입력 가능한 범위의 위치 값이 아닙니다.");
        }
        if(position.isNotVaildCol(numOfPeople)){
            throw new IllegalArgumentException("입력 가능한 범위의 위치 값이 아닙니다.");
        }
        if(position.isUsedPosition(rows)){
            throw new IllegalArgumentException("이미 선이 생성된 좌표입니다.");
        }
    }

    private void checkValidPositionPair(PositionP position1, PositionP position2){
        boolean isVaild = true;
        if(position1.getRowNum() != position2.getRowNum()) isVaild = false;
        if(Math.abs(position1.getColNum() - position2.getColNum()) != 1) isVaild = false;
        if(!isVaild) throw new IllegalArgumentException("인접한 좌표가 아닙니다.");
    }

    public void drawline(PositionP position1, PositionP position2){
        checkValidPosition(position1);
        checkValidPosition(position2);

        checkValidPositionPair(position1, position2);

        rows[position1.getRowNum()][position1.getColNum()] = 1;
        rows[position2.getRowNum()][position2.getColNum()] = 1;
    }

    public int run(int i){
        PositionP positionNow = new PositionP(0, i);
        while(!positionNow.atEndRow(numOfRow)){
            positionNow.move(rows);
        }
        return positionNow.getColNum();
    }
}
