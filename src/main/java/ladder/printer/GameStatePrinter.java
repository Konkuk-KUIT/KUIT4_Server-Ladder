package ladder.printer;

import ladder.Player;
import ladder.Row;
import ladder.constants.PrintTiming;
import ladder.constants.nodeState;

public class GameStatePrinter {

    private final Row[] rows;
    private final Player player;

    public GameStatePrinter(Row[] rows, Player player) {
        this.rows = rows;
        this.player = player;
    }

    public void print(PrintTiming printTiming){

        printTitle(printTiming.get());

        for(int i=0;i<rows.length; i++){
            for(int j = 0; j < rows[0].LineLength(); j++){

                printState(rows[i].currentState(j));

                printStarIfUserIsHere(i,j);

                printIfThereIsLine(rows[i].currentState(j));

            }

            lineBreak();
        }

        lineBreak();
    }

    private void lineBreak() {
        System.out.println();
    }

    private void printTitle(String title) {
        System.out.println(title);
    }

    private void printState(nodeState currentState) {
        System.out.print(currentState.getState());
    }

    private void printStarIfUserIsHere(int i, int j) {
        if(i == player.getCurrentDepth() && j == player.getCurrentLadderIndex()){
            System.out.print("*");
        }
    }

    private void printIfThereIsLine(nodeState currentState) {
        if(currentState == nodeState.LEFT){
            System.out.print("-");
        } else {
            System.out.print(" ");
        }
    }

}
