package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            LadderPosition ladderPosition = new LadderPosition(Position.from(i), position);

            System.out.println("Before");
            printLadder(ladderPosition);

            rows[i].nextPosition(position);

            System.out.println("After");
            printLadder(ladderPosition);

        }
        return position.getValue();
    }

    private void printLadder(LadderPosition ladderPosition){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < rows.length; i++){
            if( i == ladderPosition.getX().getValue()){
                sb.append(rows[i].convertPositionRowToString(ladderPosition.getY())).append("\n");
                continue;
            }
            sb.append(rows[i].convertRowtoString()).append("\n");
        }
        System.out.println(sb);
    }
}
