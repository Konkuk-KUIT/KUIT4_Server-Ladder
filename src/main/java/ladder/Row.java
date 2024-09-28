package ladder;

import ladder.enumclass.ExceptionMessage;

import static ladder.enumclass.Direction.*;

public class Row {
    private final Node[] nodes;
    private LadderPosition ladderPosition;

    public Row(GreaterThanOne numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()];
        for(int i=0;i< numberOfPerson.getNumber();i++){
            nodes[i]=Node.from(NONE);
        }
    }

    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);
        setDirectionBetweenNextPosition(startPosition);
    }

    private void setDirectionBetweenNextPosition(Position position) {
        nodes[position.getPosition()].setRightNodes(position);
        position.next();
        nodes[position.getPosition()].setLeftNodes(position);
    }

    public void nextPosition(Position position) {
        validatePosition(position);
        nodes[position.getPosition()].move(position);
    }

    public void validatePosition(Position position) {
        if (position.isBiggerThan(nodes.length-1)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    private void validateDrawLinePosition(Position startPosition) {
        if (isInvalidPosition(startPosition) || isLineAtPosition(startPosition) || isLineAtNextPosition(startPosition)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }

    public String printLine() {
        StringBuilder rowString = new StringBuilder();

        for (int i = 0; i < nodes.length; i++) {
            addingValue(rowString,i);
            rowString.append(" ");
        }
        return rowString.toString();
    }

    public String printStarLine(LadderPosition ladderPosition) {
        this.ladderPosition=ladderPosition;
        StringBuilder rowString = new StringBuilder();
        for (int i = 0; i < nodes.length; i++) {
            addingValue(rowString,i);
            rowString.append(printStar(i));
        }
        return rowString.toString();
    }
    private void addingValue(StringBuilder builder,int i){

        if (nodes[i].isLeft()) {
            builder.append(LEFT.getValue());
        } else if (nodes[i].isRight()) {
            builder.append(RIGHT.getValue());
        } else {
            builder.append(NONE.getValue());
        }


    }
    public String printStar(int i) {
       if(i==ladderPosition.getCol().getPosition()){
           return "*";
       }
        return " ";
    }



    private boolean isLineAtPosition(Position startPosition) {
        return !nodes[startPosition.getPosition()].isAlreadySetDirection();
    }

    private boolean isInvalidPosition(Position startPosition) {
        return startPosition.isBiggerThan(nodes.length-1) ;
    }

    private boolean isLineAtNextPosition(Position startPosition) {
        startPosition.next();
        boolean IsLineAtPosition= !nodes[startPosition.getPosition()].isAlreadySetDirection();
        startPosition.prev();

        return IsLineAtPosition;
    }
}
