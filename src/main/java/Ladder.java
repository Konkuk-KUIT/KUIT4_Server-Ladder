public class Ladder {

    public final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    public void drawline(){
    }

    public int run(int i){
        return i;
    }
}
