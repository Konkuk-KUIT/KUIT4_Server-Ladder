package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(LadderPosition ladderPosition) {
        for (int i = 0; i < rows.length; i++) {
            printLadder("Before", ladderPosition);
            rows[i].nextPosition(ladderPosition);
            printLadder("After", ladderPosition);
            ladderPosition.goDown();
        }
        return ladderPosition.getValueY();
    }

    private void printLadder(String title, LadderPosition ladderPosition) {
        String printString = title
                + '\n'
                + getLadderString(ladderPosition);
        System.out.println(printString);
    }

    private String getLadderString(LadderPosition ladderPosition) {
        StringBuilder ladderStringBuilder = new StringBuilder();

        for (int i = 0; i < rows.length; i++) {
            ladderStringBuilder.append(getNthRowString(i, ladderPosition))
                    .append('\n');
        }
        return ladderStringBuilder.toString();
    }

    private String getNthRowString(int n, LadderPosition ladderPosition) {
        String rowString = rows[n].getRowString();
        if (ladderPosition.isNthRow(n)) {
            rowString = insertAsterisk(rowString, ladderPosition);
        }
        return rowString;
    }

    private String insertAsterisk(String rowString, LadderPosition ladderPosition) {
        String[] nodeStrings = rowString.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < nodeStrings.length; i++) {
            stringBuilder.append(nodeStrings[i])
                    .append(ladderPosition.isNthNode(i) ? "* " : " ");
        }
        return stringBuilder.toString();
    }
}
