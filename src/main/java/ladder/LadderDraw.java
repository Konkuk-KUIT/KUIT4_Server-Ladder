package ladder;

public class LadderDraw {

    private final Row[] rows;
    private final StringBuilder line = new StringBuilder();

    public LadderDraw(Row[] rows) {
        this.rows=rows;
    }

    public void drawLadderState(int x, int y,String State) {

        line.append(State+"\n");
        for (int i = 0; i < rows.length; i++) {

            Position position = Position.of(x, y);
            LadderStateUpdate(position, i);
            line.append("\n");
        }
        System.out.println(line.toString());
        line.setLength(0);
    }

    private void LadderStateUpdate(Position position, int i) {

        Node[] nodes = rows[i].getNodes();

        for (int j = 0; j < nodes.length; j++) {

            if (nodes[j].isRight())
                line.append(1);
            if (nodes[j].isLeft())
                line.append(-1);
            if (nodes[j].isNone())
                line.append(0);
            if (position.isCorrectPosition(j,i))
                line.append("*");
            line.append(" ");

        }
    }


}
