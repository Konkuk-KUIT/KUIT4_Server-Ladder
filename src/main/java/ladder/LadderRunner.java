package ladder;

public class LadderRunner {
    LadderWrapper ladderWrapper;

    private LadderRunner(LadderWrapper ladderWrapper) {
        this.ladderWrapper = ladderWrapper;
    }

    public static LadderRunner from(LadderWrapper ladderWrapper) {
        return new LadderRunner(ladderWrapper);
    }

    public int run(Position position) {
        LadderPosition ladderPosition = LadderPosition.of(Position.from(0), position);
        while(!ladderWrapper.isLadderPositionAtLastRow(ladderPosition)){
            moveTurnPrinting(ladderPosition);
        }
        Position lastColPosition = ladderPosition.getColPos();
        return lastColPosition.getValue();
    }

    private void moveTurnPrinting(LadderPosition ladderPosition){
        ladderWrapper.printRowsWithLabel(ladderPosition, "Before");
        ladderWrapper.changeLadderPositionHorizontally(ladderPosition);
        ladderWrapper.printRowsWithLabel(ladderPosition, "After");
        ladderWrapper.changeLadderPositionVertically(ladderPosition);
        System.out.println();
    }
}
