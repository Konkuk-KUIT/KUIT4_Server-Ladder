public class Ladder {
    Validation validation;
    private final int numberOfPerson;
    private final int row;
    private int[][] rows;
    private final int RIGHT=1;
    private final int LEFT=-1;

    //high 이 Y크기
    public Ladder(NaturalNumber row, NaturalNumber numberOfPerson){
        this.numberOfPerson=numberOfPerson.getNaturalNumber();
        this.row=row.getNaturalNumber();
        rows = new int[row.getNaturalNumber()][numberOfPerson.getNaturalNumber()];

        this.validation=new Validation(rows,row.getNaturalNumber(),numberOfPerson.getNaturalNumber());
    }

    public void drawLine(NaturalNumber x,NaturalNumber y) {
        int coordinateX=x.getNaturalNumber();
        int coordinateY=y.getNaturalNumber();
        validation.rangeValidation(coordinateX,coordinateY);
        //줄 그어져 있나 체크 해야함
        validation.lineExistence(coordinateX,coordinateY);

        //만약 조건 충족시
        rows[coordinateX-1][coordinateY-1]=RIGHT;
        rows[coordinateX-1][coordinateY]=LEFT;
    }



    public int run(NaturalNumber position) {
        //배열은 0부터 시작이나 받는건 자연수 범위로 생각
        int userPosition=position.getNaturalNumber();
        validation.positionRange(userPosition);

        for(int i=0;i<row;i++){
            if (rows[i][userPosition-1] == 0) { continue; }
            userPosition += rows[i][userPosition-1];
        }
        return userPosition;
    }


//
//    private void lineExistence(int x,int y) {
//        if(coordinate[x-1][y-1]!=0 && coordinate[x-1][y]!=0){
//            throw new IllegalArgumentException();
//        }
//    }
//
//    private void positionRange(int userPosition) {
//        if(userPosition>numberOfPerson){
//            throw new IllegalArgumentException();
//        }
//    }
//
//    private void rangeValidation(int x,int y) {
//        if((y>row||x>numberOfPerson)){
//            throw new IllegalArgumentException();
//        }
//    }



    public int checkLine(int x,int y){
        return rows[x-1][y-1];
    }

    public int checkRow(){
        return rows.length;
    }
    public int checkNumberOfPerson(){
        return rows[0].length;
    }
}
