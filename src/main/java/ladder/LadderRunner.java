package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {

        for (int i = 0; i < rows.length; i++) {

            printWholeLine(LadderPosition.from(Position.from(i), position));
            rows[i].nextPosition(position);
            printWholeLine(LadderPosition.from(Position.from(i), position));

        }

        return position.getValue();
    }


    // 전체 라인 출력
    private void printWholeLine(LadderPosition ladderPosition) {
        StringBuilder sb = new StringBuilder();

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
