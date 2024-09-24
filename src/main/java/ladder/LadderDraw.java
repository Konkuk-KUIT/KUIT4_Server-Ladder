package ladder;

public class LadderDraw {

    private final Row[] rows;
    private final StringBuilder line = new StringBuilder();

    public LadderDraw(Row[] rows) {
        this.rows=rows;
    }

    public void drawLadderState(Position positionX,Position positionY,String State) {

        line.append(State+"\n");
        for (int i = 0; i < rows.length; i++) {
            LadderStateUpdate(positionX,positionY, i);
        }
        System.out.println(line.toString());
        line.setLength(0);
    }

    private void LadderStateUpdate(Position positionX,Position positionY, int currentY) {

        Node[] nodes = rows[currentY].getNodes();

        for (int j = 0; j < nodes.length; j++) {

            if (nodes[j].isRight())
                line.append(1);
            if (nodes[j].isLeft())
                line.append(-1);
            if (nodes[j].isNone())
                line.append(0);
            if (positionX.isCurrentPosition(j) && positionY.isCurrentPosition(currentY))
                line.append("*");
            line.append(" ");
        }
        line.append("\n");
    }


}
