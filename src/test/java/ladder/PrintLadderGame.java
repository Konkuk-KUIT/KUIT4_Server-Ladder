package ladder;

import ladder.creator.LadderCreator;
import org.junit.jupiter.api.Test;

class PrintLadderGame {

//    @Test
//    void 열_하나_출력(){
//
//        GreaterThanOne numberOfRow = new GreaterThanOne(5);
//        Row row = new Row(numberOfRow);
//        Position positionOfRunner = Position.from(1);
//
//        row.printLine(Position.from(2));
//        StringBuilder sb = new StringBuilder();
//
//        row.printRow(sb, numberOfRow, positionOfRunner);
//        System.out.println(sb);
//    }

//    @Test
//    void 열_여러개_출력(){
//        GreaterThanOne numberOfCol = new GreaterThanOne(5);
//        GreaterThanOne numberOfRow = new GreaterThanOne(4);
//        Row row = new Row(numberOfRow);
//
//        for(int i=0; i<numberOfCol.getNumber(); i++){
//            StringBuilder sb = new StringBuilder();
//            row.printRow(sb, numberOfRow);
//            System.out.println(sb);
//        }
//
//    }

    @Test
    void 사다리_출력(){
        GreaterThanOne numberOfRow = new GreaterThanOne(5);
        GreaterThanOne numberOfCol = new GreaterThanOne(5);

        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfCol);
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        //ladderCreator.drawLine(Position.from(1),Position.from(2));
        ladderCreator.drawLine(Position.from(2),Position.from(1));
        ladderCreator.drawLine(Position.from(3),Position.from(0));
        ladderRunner.run(Position.from(1));

    }


}
