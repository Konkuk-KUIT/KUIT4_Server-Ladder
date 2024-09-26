package ladder.creator;

import java.util.HashSet;
import java.util.Random;
import ladder.*;

public class RandomLadderCreator extends WrapperLadderCreator {

    Random random = new Random();
    private static final double ladderCreateRatio = 0.3;

    private RandomLadderCreator(LadderWrapper ladderWrapper) {
        super(ladderWrapper);
    }

    public static RandomLadderCreator from(LadderSize ladderSize) {
        LadderWrapper ladderWrapper = createLadderWrapper(ladderSize);
        return makeRandomLadderCreator(ladderWrapper);
    }

    public static RandomLadderCreator emptyLadderFrom(LadderSize ladderSize) {
        LadderWrapper ladderWrapper = createLadderWrapper(ladderSize);
        return new RandomLadderCreator(ladderWrapper);
    }

    public static RandomLadderCreator makeRandomLadderCreator(LadderWrapper ladderWrapper) {
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(ladderWrapper);

        int maxCreateLine = (int) Math.floor(ladderWrapper.getRowsSize() * ladderWrapper.getColsSize() * ladderCreateRatio);
        randomLadderCreator.createRandomLinesOnLadder(maxCreateLine);

        return randomLadderCreator;
    }

    private void createRandomLinesOnLadder(int maxCreateLine) {
        HashSet<LadderPosition> hashSet = new HashSet<>();
        while (hashSet.size() < maxCreateLine) {
            makeRandomLine(hashSet);
        }
    }

    public LadderPosition makeRandomLine(HashSet<LadderPosition> hashSet) {
        int maxRow = ladderWrapper.getRowsSize();
        int maxCol = ladderWrapper.getColsSize() - 1;
        int randomRow = random.nextInt(maxRow);
        int randomCol = random.nextInt(maxCol);
        LadderPosition ladderPosition = LadderPosition.of(Position.from(randomRow), Position.from(randomCol));

        try {
            drawLine(ladderPosition);
            hashSet.add(ladderPosition);
            return ladderPosition;
        } catch (IllegalArgumentException e) {
            return makeRandomLine(hashSet);
        }
    }

    public int getInLadderValue(LadderPosition ladderPosition){
        return ladderWrapper.getLadderValue(ladderPosition);
    }
}
