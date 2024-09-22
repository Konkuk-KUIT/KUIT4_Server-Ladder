package ladder;

public class Ladder {

    private final Row[] rows;

    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new Row[numberOfRow];
        for (int i = 0; i < numberOfRow; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

//    사다리 가로줄을 긋는 로직
    public void drawLine(int row, int col) {
        rows[row].drawLine(col);
    }

//    사다리에 position값을 넣어주고 반복문을 통해
//    메세지를 보내면서 다음 좌표가 어딨는지 질문을 함
    public int run(int position) {
        for (int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }
        return position;
    }
}
