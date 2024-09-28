package ladder.creator;

import ladder.*;

import java.util.HashSet;
import java.util.Random;

public class LadderAutoCreator implements LadderCreator{

    private final Row[] rows;
    private final LadderSize ladderSize;
    private int createdLadderLineNumber=0;


    private HashSet<String> createdLadderLine=new HashSet<>();

    public LadderAutoCreator(LadderSize ladderSize) {
        this.ladderSize=ladderSize;
        rows = new Row[ladderSize.getNumberOfRow().getNumber()];
        for (int i = 0; i < ladderSize.getNumberOfRow().getNumber(); i++) {
            rows[i] = new Row(ladderSize.getNumberOfPerson());
        }
        //여기서 이제 line을 AUTO로 그려줘야하는건
        lineAutoDraw();
    }

    private void lineAutoDraw() {
        //로직부터 생각
        //hashset에 나온 숫자담기고, 나온 숫자의 오른쪽으로 사다리 그어지게
        //hashset 안에 들어간 좌표중 +-자신 이렇게 안되게 만들어야함
        //while문 사용하면 좋을 듯?
        Random randomNumber=new Random();
        int numberOfLadder= (int) (ladderSize.getNumberOfRow().getNumber()*ladderSize.getNumberOfPerson().getNumber()*0.3);


        while(createdLadderLineNumber!=numberOfLadder){
            //어떻게 저장하지 int??13 이면 +-1 안되게 설정하는 방식 어떰?->10넘으면 예외가 생기니 String 처리?

            int rowNumber=randomNumber.nextInt(ladderSize.getNumberOfRow().getNumber());
            int personNumber=randomNumber.nextInt(ladderSize.getNumberOfPerson().getNumber()-1);


            if(lineValidation(rowNumber,personNumber)){
                continue;
            }
            //drawLine 가져오기
            drawLine(Position.from(rowNumber),Position.from(personNumber));

            createdLadderLineNumber++;
        }

    }

    private boolean lineValidation(int rowNumber,int personNumber) {
        String str1 = new StringBuilder().append(rowNumber).append("/").append(personNumber).toString();
        String str2 = new StringBuilder().append(rowNumber).append("/").append(personNumber - 1).toString();
        String str3 = new StringBuilder().append(rowNumber).append("/").append(personNumber + 1).toString();
        if(createdLadderLine.contains(str1)||createdLadderLine.contains(str2)||createdLadderLine.contains(str3)){
            return true;
        }
        addLineInHashSet(str1,str2,str3);
        return false;

    }

    private void addLineInHashSet(String str1, String str2, String str3) {
        createdLadderLine.add(str1);
        createdLadderLine.add(str2);
        createdLadderLine.add(str3);
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }
    @Override
    public Row[] getRows() {
        return rows;
    }
    public int getCreatedLadderLineNumber(){
        return createdLadderLineNumber;
    }
}
