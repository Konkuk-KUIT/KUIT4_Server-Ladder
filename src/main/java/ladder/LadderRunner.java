package ladder;

public class LadderRunner {
    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            //System.out.println("Before");
            //printLadder(i, position);
            rows[i].nextPosition(position);
            //System.out.println("After");
            //printLadder(i, position);
            //System.out.println();
        }
        return position.getPosition();
    }
    /*
    private void printLadder(int nowRowIndex, Position position){
        for(int i=0; i<rows.length; i++){
            if(i==nowRowIndex) rows[i].printStarLine(position);
            else rows[i].printNonStarLine();
            System.out.println();
        }
    }
     */
}
