import java.util.ArrayList;

public class Ladder {

    private final int[][] rows;
    private ArrayList<int[]> pairs = new ArrayList<>();

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    public int validLadderIndex(int ladderIndex) {

        if (ladderIndex < 0 || ladderIndex >= rows.length) {
            System.out.println("Invalid ladder index");
            return -1;
        }

        return ladderIndex;
    }


    public int run(int ladderIndex) {

        int Pi = ladderIndex;
        int Pj = 1;

        for (int k = 1; k < rows.length; k++) {
            Pj += 1;

            for (int[] pair : pairs) {
                if (pair[0] == Pi && pair[1] == Pj) {
                    Pi += 1;
                    continue;
                }
                if (pair[0] == Pi - 1 && pair[1] == Pj) {
                    Pi -= 1;
                }
            }

        }
        return Pi;
    }

    public void drawLine(int i, int j) {
        pairs.add(new int[]{i, j});
    }
}
