package ladder;

import ladder.wrapper.ArrayIndex;
import ladder.wrapper.unsignedInt;

public class Player {

    unsignedInt currentDepth;
    ArrayIndex currentLadderIndex;

    public int getCurrentDepth() {
        return currentDepth.getValue();
    }

    private Player(ArrayIndex currentLadderIndex) {
        this.currentDepth = currentDepth.from(0);
        this.currentLadderIndex = currentLadderIndex;
    }

    public static Player startingFrom(ArrayIndex currentLadderIndex) {
        return new Player(currentLadderIndex);
    }

    public boolean isAtBottom(int rowLength) {
        return currentDepth.getValue() == rowLength;
    }

    public void moveToBottom() {
        currentDepth.increment();
    }

    public void moveIfThereIsLineIn(Row row) {
            //오른쪽에 있을 경우
            if(row.hasRightLine(currentLadderIndex)) {
                currentLadderIndex.increment();
            } else if (row.hasLeftLine(currentLadderIndex)){
                currentLadderIndex.decrement();
            }
    }

    public int getCurrentLadderIndex() {
        return currentLadderIndex.getIndex();
    }
}
