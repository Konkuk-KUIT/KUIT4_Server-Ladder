package ladder;

public class LadderPrinter {
    private final Row[] rows;

    public LadderPrinter(Row[] rows) {
        this.rows = rows;
    }

    public void printLadder(Position position, int currentRow, boolean isAfter) {
        StringBuilder sb = new StringBuilder();
        sb.setLength(0); // StringBuilder 초기화

        for (int i = 0; i < rows.length; i++) {
            sb.append(addPositionMarker(rows[i].rowToString(), position, i == currentRow));
            sb.append("\n");
        }

        System.out.println(isAfter ? "After" : "Before");
        System.out.print(sb.toString());
        System.out.println();
    }

    private String addPositionMarker(String rowString, Position position, boolean isCurrentRow) {
        String[] parts = rowString.split(" ");
        StringBuilder rowSb = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            if (i == position.getValue() && isCurrentRow) {
                rowSb.append(parts[i].equals("-1") ? "-1*" : parts[i] + "*");
            } else {
                rowSb.append(parts[i]);
            }
            if (i < parts.length - 1) {
                rowSb.append(" ");
            }
        }
        return rowSb.toString();
    }
}