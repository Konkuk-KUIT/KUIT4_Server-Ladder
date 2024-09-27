package ladder.creator;

import ladder.exception.ExceptionMessage;
import ladder.info.Ladder;
import ladder.info.LadderSize;
import ladder.Position;

import java.util.HashSet;
import java.util.Random;

public class LadderAutoCreator implements LadderCreator {

    private final Ladder ladder;

    private LadderAutoCreator(LadderSize ladderSize) {
        this.ladder = Ladder.create(ladderSize);
    }

    @Override
    public void drawLine(Position position) {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_DRAW_AUTO.getMessage());
    }

    public void drawLine(LadderSize ladderSize) {

        //자동생성 되는 사다리 좌표 값 수
        //실제로 라인은 하나가 생성되지만 이 클래스에서는 사다리가 라인을 가지고 있는걸 1,-1 값으로 표현하기 때문에
        int lineNum = getLineNum(ladderSize);

        //중복 검증할 포지션 집합
        HashSet<Position> set = new HashSet<>();

        while(set.size()< lineNum){

            Position[] startPosition = getRandomPosition(ladderSize);

            //포함되어있지않다면 == 라인이 생성되어있지않다면(오른쪽 생성했을때)
            //오른쪽에도 라인이 생성되어있다면 그릴수 없기때문에 오른쪽 위치도 같이 확인
            if(!isDrawLine(startPosition,set)){

                ladder.getRows()[startPosition[0].getRow()].drawLine(startPosition[0]);
                set.add(Position.of(startPosition[0].getRow(),startPosition[0].getCol()-1)); //포지션이 객체라 col값이 올라가서 그전값으로 확인
                set.add(startPosition[1]);
            }
        }

    }
    private boolean isDrawLine(Position[] startPosition,HashSet<Position> set){
        return (set.contains(startPosition[0]) || set.contains(startPosition[1]));
    }

    private Position[] getRandomPosition(LadderSize ladderSize) {

        Random random = new Random();

        //사다리 범위내에서 랜덤생성
        int randomRow = random.nextInt(ladderSize.getRow());
        //사다리 생성로직이 오른쪽으로 선을 긋기때문에 맨 마지막 열에서는 사다리 라인생성 불가
        int randomCol = random.nextInt(ladderSize.getCol()-1);

        //사다리 자동생성 시작값
        Position startPosition = Position.of(randomRow,randomCol);
        //사다리가 자동생성되면 라인이 왼쪽에 그려지는 값
        Position startPositionplus = Position.of(randomRow,randomCol+1);

        return new Position[]{startPosition, startPositionplus};

    }

    private int getLineNum(LadderSize ladderSize) {
        int lineNum = (int) Math.floor(ladderSize.getRow() * ladderSize.getCol() * 0.3) * 2 ;
        return lineNum;
    }

    public static LadderAutoCreator of (LadderSize ladderSize) {
        return new LadderAutoCreator(ladderSize);
    }

    @Override
    public Ladder getLadder() {
        return this.ladder;
    }

}
