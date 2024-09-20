public class Validation {
    private int[][] rows;
    int row;
    int numberOfPerson;

    public Validation(int[][] coordinate,int row, int numberOfPerson){
        this.rows=coordinate;
        this.row=row;
        this.numberOfPerson=numberOfPerson;
    }
    public void lineExistence(int x,int y) {
        if(rows[x-1][y-1]!=0 && rows[x-1][y]!=0){
            throw new IllegalArgumentException();
        }
    }

    public void positionRange(int userPosition) {
        if(userPosition>numberOfPerson){
            throw new IllegalArgumentException();
        }
    }

    public void rangeValidation(int x,int y) {
        if((y>row||x>numberOfPerson)){
            throw new IllegalArgumentException();
        }
    }


}
