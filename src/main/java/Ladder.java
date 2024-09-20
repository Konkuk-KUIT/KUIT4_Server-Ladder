public class Ladder {
    private final NaturalNumber row;
    private final NaturalNumber numberOfPerson;
    private final int[][] rows;

    public Ladder(NaturalNumber row, NaturalNumber numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
        this.row = row;
        rows = new int[row.getNaturalNumber()][numberOfPerson.getNaturalNumber()];
    }

    public void drawLine(NaturalNumber row, NaturalNumber position) {
        checkValidPosition(row.getNaturalNumber(),position.getNaturalNumber());
        rows[row.getNaturalNumber()][position.getNaturalNumber()] = 1;
    }

    private void checkValidPosition(int row, int position) {
        if (position >= numberOfPerson.getNaturalNumber() || row >= this.row.getNaturalNumber()) {
            throw new IllegalArgumentException();
        }
    }

    public void initLines(){
        for(int i = 0 ; i < row.getNaturalNumber() ; i++){
            initNegativeLines(i);
            initZeroLines(i);
        }
    }

    private void initZeroLines(int i) {
        for(int j = 0; j < numberOfPerson.getNaturalNumber() - 1 ; j++){
            makeZeroIfBothLineFilled(i, j);
        }
    }

    private void initNegativeLines(int i) {
        for(int j = 1 ; j < numberOfPerson.getNaturalNumber() ; j++){
            makeNegativeIfLeftFilled(i, j);
        }
    }

    private void makeZeroIfBothLineFilled(int i, int j) {
        if(rows[i][j] == 1 && rows[i][j + 1] == 1 && rows[i][j - 1] == 1){
            rows[i][j] = 0;
        }
    }

    private void makeNegativeIfLeftFilled(int i, int j) {
        if(rows[i][j] == 1 && rows[i][j - 1] == 1){
            rows[i][j] = -1;
        }
    }

    public int run(int position){
        int currentPosition = position - 1;
        for (int i = 0; i < row.getNaturalNumber(); i++) {
            currentPosition += rows[i][currentPosition];
        }
        return currentPosition + 1;
    }




}
