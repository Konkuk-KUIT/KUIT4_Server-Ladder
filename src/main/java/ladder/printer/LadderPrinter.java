package ladder.printer;


import ladder.component.LadderPosition;
import ladder.component.Position;
import ladder.component.Row;
import ladder.constant.TimeLine;

// 사다리를 출력해주는 클래스
public class LadderPrinter {

    private final Row[] rows;

    private LadderPrinter(Row[] rows) {
        this.rows = rows;
    }

    public static LadderPrinter from(Row[] rows) {
        return new LadderPrinter(rows);
    }


    public void printWholeLine(LadderPosition ladderPosition, TimeLine timeLine) {
        StringBuilder sb = new StringBuilder();

        sb.append(timeLine.getValue()).append("\n");

        for (int i = 0; i < rows.length; i++) {
            if(ladderPosition.isCurrentRow(Position.from(i))) {
                sb.append(rows[i].printAsteroidLine(ladderPosition.getCol())).append("\n");
                continue;
            }

            sb.append(rows[i].printNormalLine()).append("\n");
        }

        System.out.println(sb);
    }
}
