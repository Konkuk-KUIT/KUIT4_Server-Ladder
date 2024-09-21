public class Ladder {

    private final int[][] positions;

    public Ladder(int height, int numberOfPerson) {
        positions = new int[height][numberOfPerson];
    }
    public void drawLine(Position pos, int direction) {
        if(direction == -1){
            drawLineToLeft(pos);
        }
        if(direction == 1){
            drawLineToRight(pos);
        }
    }
    public void drawLineToLeft(Position pos) {
        if(pos.getCol() <= 0 || pos.getCol() > (positions[0].length-1)){
            throw new IllegalArgumentException("Index Error");
        }
        positions[pos.getRow()][pos.getCol()] = -1;
        positions[pos.getRow()][pos.getCol()-1] = 1;
    }
    private void drawLineToRight(Position pos) {
        if(pos.getCol() < 0 || pos.getCol() >= (positions[0].length-1)){
            throw new IllegalArgumentException("Index Error");
        }
        positions[pos.getRow()][pos.getCol()] = 1;
        positions[pos.getRow()][pos.getCol()+1] = -1;
    }

    public int run(int pos){
        for (int i = 0; i < positions.length; i++) { // height
            pos += positions[i][pos];
        }
        return pos;
    }
}
