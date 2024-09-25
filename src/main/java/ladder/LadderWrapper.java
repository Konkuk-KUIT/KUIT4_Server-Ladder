package ladder;

public class LadderWrapper {
    private final Row[] rows;

    private LadderWrapper(Row[] rows) {
        this.rows = rows;
    }

    public static LadderWrapper from(Row[] rows){
        return new LadderWrapper(rows);
    }

    public void changeLadderPositionHorizontally(LadderPosition ladderPosition){
        Position rowPosition = ladderPosition.getRowPos();
        rows[rowPosition.getValue()].nextPosition(ladderPosition.getColPos());
    }

    public void changeLadderPositionVertically(LadderPosition ladderPosition){
        Position rowPosition = ladderPosition.getRowPos();
        rowPosition.next();
    }

    public boolean isLadderPositionAtLastRow(LadderPosition ladderPosition){
        Position rowPosition = ladderPosition.getRowPos();
        return rowPosition.getValue() == rows.length;
    }

    public void printRowsWithLabel(LadderPosition ladderPosition, String label){
        System.out.println(label);
        printRows(ladderPosition);
    }

    private void printRows(LadderPosition ladderPosition){
        Position nowRowPosition = ladderPosition.getRowPos();
        for(int rowIndex=0; rowIndex<rows.length; rowIndex++){
            if(rowIndex != nowRowPosition.getValue()) { rows[rowIndex].printRow(); continue; }
            rows[rowIndex].printStarRow(ladderPosition.getColPos());
        }
    }

    public void drawLine(LadderPosition pos){
        Position rowPos = pos.getRowPos();
        Position colPos = pos.getColPos();
        rows[rowPos.getValue()].drawLine(colPos);
    }

    public int getRowsSize(){
        return rows.length;
    }

    public int getColsSize(){
        return rows[0].getNodesSize();
    }
}
