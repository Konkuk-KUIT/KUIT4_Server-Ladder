package ladder;

public class Ladder {

    private final Row[] rows;

//    todo 자연수 래퍼 클래스
    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new Row[numberOfRow];
        for (int i = 0; i < numberOfRow; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

//    사다리 가로줄을 긋는 로직
//    todo LadderCreator 분리
    public void drawLine(int row, int col) {
        rows[row].drawLine(col);
    }

//    사다리에 position값을 넣어주고 반복문을 통해
//    메세지를 보내면서 다음 좌표가 어딨는지 질문을 함
//    todo 포지션 래퍼 클래스
//    todo LadderRunner 분리
    public int run(int position) {
        for (int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }
        return position;
    }
}
