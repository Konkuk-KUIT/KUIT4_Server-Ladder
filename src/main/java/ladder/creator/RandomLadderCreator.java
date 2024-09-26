package ladder.creator;

import java.util.HashSet;
import java.util.Random;
import ladder.*;

public class RandomLadderCreator implements LadderCreator {
    private final LadderWrapper ladderWrapper;

    Random random = new Random();
    private static final double ladderCreateRatio = 0.3; // enum?

    private RandomLadderCreator(LadderWrapper ladderWrapper) {
        this.ladderWrapper = ladderWrapper;
    }

    public static RandomLadderCreator from(LadderSize ladderSize){
        LadderWrapper ladderWrapper = setFieldLadderWrapper(ladderSize);
        return makeRandomLadderCreator(ladderWrapper);
    }

    private static LadderWrapper setFieldLadderWrapper(LadderSize ladderSize){
        GreaterThanOne numberOfRow = ladderSize.getNumberOfRow();
        GreaterThanOne numberOfPerson = ladderSize.getNumberOfPerson();
        Row[] rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = Row.from(numberOfPerson);
        }
        return LadderWrapper.from(rows);
    }

    public static RandomLadderCreator makeRandomLadderCreator(LadderWrapper ladderWrapper){
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(ladderWrapper);

        int maxCreateLine = (int)Math.floor(ladderWrapper.getRowsSize() * ladderWrapper.getColsSize() * ladderCreateRatio);
        randomLadderCreator.createRandomLinesOnLadder(maxCreateLine);

        return randomLadderCreator;
    }

    public void drawLine(LadderPosition ladderPosition) {
        ladderWrapper.drawLine(ladderPosition);
    }

    public LadderWrapper getLadderWrapper() {
        return ladderWrapper;
    }

    private void createRandomLinesOnLadder(int maxCreateLine){
        HashSet<LadderPosition> hashSet = new HashSet<LadderPosition>();
        while(hashSet.size() < maxCreateLine){
            LadderPosition newPosition = makeRandomLine();
            if(newPosition == null) continue;
            hashSet.add(newPosition);
        }
    }

    // todo 재귀로 구현해보기
    // LadderPosition에서 마지막 열을 제외한 좌표를 랜덤으로
    // 전체 칸수 *0.3 내림 정수 만큼 생길 때 까지 무한 반복
    private LadderPosition makeRandomLine(){
        int maxRow = ladderWrapper.getRowsSize();
        int maxCol = ladderWrapper.getColsSize()-1;
        int randomRow = random.nextInt(maxRow);
        int randomCol = random.nextInt(maxCol);

        LadderPosition ladderPosition = LadderPosition.of(Position.from(randomRow), Position.from(randomCol));
        try{
            drawLine(ladderPosition);
            return ladderPosition;
        }catch(IllegalArgumentException e){
            return null;
        }
    }
}
