package ladder;

import static ladder.enumclass.State.AFTER;
import static ladder.enumclass.State.BEFORE;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }
    //before after enum
    //random 따로 사다리 그리기 따로
    //interface 밑에 추상 밑에 구형클래스 은근 많다 참고하기

    public int run(Position position) {
       for(int j=0;j<rows.length;j++){
         //  rows[j].validatePosition(position);

           System.out.println(BEFORE.getState());

           printLadder(LadderPosition.from(Position.from(j),position));

           System.out.println(AFTER.getState());
           rows[j].nextPosition(position);
           printLadder(LadderPosition.from(Position.from(j),position));
       }
        return position.getPosition();
    }

    private void printLadder(LadderPosition getCoordinate){
        for (int i = 0; i < rows.length; i++) {
            System.out.println(checkStarLine(getCoordinate,i));
        }
    }
    private String checkStarLine(LadderPosition getCoordinate,int i){
        String ladder;

        if(getCoordinate.getRow().getPosition()==i){
            ladder =rows[i].printStarLine(getCoordinate);
        }else{
            ladder=rows[i].printLine();
        }
        return ladder;
    }

}
