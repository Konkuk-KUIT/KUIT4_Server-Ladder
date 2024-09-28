package ladder;

import ladder.enumclass.ExceptionMessage;

public class Position {
    private int position;

    private Position(int position) {
        this.position = position;
    }
    public int getPosition(){
        return position;
    }
    public void next(){
        position++;
    }

    public void prev(){
        position--;
    }

    public static Position from(int position){
        validatePosition(position);
        return new Position(position);
    }
    public boolean isBiggerThan(int position){
        return this.position > position;
    }

    public boolean isSmallerThan(int position){
        return this.position < position;
    }

    private static void validatePosition(int position) {
        if(!isPosition(position)){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_POSITION.getMessage());
        }
    }

    private static boolean isPosition(int position) {
        return position >= 0;
    }
}
