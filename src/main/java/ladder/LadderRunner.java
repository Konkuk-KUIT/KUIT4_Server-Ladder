package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            System.out.println("Before");
            drawLadder(Position.from(i),position);

            rows[i].nextPosition(position);

            System.out.println("After");
            drawLadder(Position.from(i),position);

        }
        return position.getValue();
    }

    private void drawLadder(Position x, Position y){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < rows.length; i++){
            if( i == x.getValue()){
                sb.append(rows[i].convertPositionRowtoString(y)).append("\n");
                continue;
            }
            sb.append(rows[i].convertRowtoString()).append("\n");
        }
        System.out.println(sb);
    }
}
