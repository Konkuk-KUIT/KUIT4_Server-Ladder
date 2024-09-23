package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public void drawLadderState(Position position,int rowcnt) {

        StringBuilder line = new StringBuilder();
        for (int i = 0; i < rows.length; i++) {
            Node[] nodes = rows[i].getNodes();
            //LadderStateUpdate(line,position,nodes);
            for(int j = 0; j < nodes.length; j++) {
                if (nodes[j].isRight())
                    line.append(1);
                if (nodes[j].isLeft())
                    line.append(-1);
                if (nodes[j].isNone())
                    line.append(0);
                if(position.getValue() == j && rowcnt==i)
                    line.append("*");
                line.append(" ");
            }
            line.append("\n");
        }
        System.out.println(line.toString());
    }

//    public void LadderStateUpdate(StringBuilder line,Position position,Node[] nodes) {
//        for(int j = 0; j < nodes.length; j++) {
//            if (nodes[j].isRight())
//                line.append(1);
//            if (nodes[j].isLeft())
//                line.append(-1);
//            if (nodes[j].isNone())
//                line.append(0);
//            if(position.getValue() == j)
//                line.append("*");
//            line.append(" ");
//        }
//
//    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            drawLadderState(position,i);
            rows[i].nextPosition(position);
            drawLadderState(position,i);
        }
        return position.getValue();
    }
}
