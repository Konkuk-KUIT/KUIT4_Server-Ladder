package ladder.creator;

import ladder.wrapper.unsignedInt;

public class pureLadderCreator extends LadderCreator {


    private pureLadderCreator(unsignedInt row, unsignedInt column) {
        super(row, column);
    }

    public static pureLadderCreator from(unsignedInt row, unsignedInt column) {
        return new pureLadderCreator(row,column);
    }


}
