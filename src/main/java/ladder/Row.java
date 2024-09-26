package ladder;

import static ladder.Direction.*;

public class Row {
    private final Node[] nodes;

    private Row(GreaterThanOne numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()];
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            nodes[i] = Node.from(NONE);
        }
    }

    public static Row from(GreaterThanOne numberOfPerson){
        return new Row(numberOfPerson);
    }

    public StringBuilder buildRowString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Node node : nodes){
            stringBuilder.append(node.getDirectionValue()).append(" ");
        }
        return stringBuilder;
    }

    public StringBuilder buildStarRowString(Position position){
        StringBuilder stringBuilder = new StringBuilder();

        for(int colIndex=0; colIndex<nodes.length; colIndex++){
            stringBuilder.append(nodes[colIndex].getDirectionValue());
            if(colIndex == position.getValue()) stringBuilder.append("*");
            stringBuilder.append(" ");
        }
        return stringBuilder;
    }

    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);

        setDirectionBetweenNextPosition(startPosition);
    }

    public void nextPosition(Position position) {
        validatePosition(position);

        nodes[position.getValue()].move(position);
    }

    public int getNodesSize(){
        return nodes.length;
    }

    private void setDirectionBetweenNextPosition(Position position) {
        nodes[position.getValue()].setRightNode();
        position.next();
        nodes[position.getValue()].setLeftNode();
        position.prev();
    }

    private void validatePosition(Position position) {
        if (isInvalidPosition(position) ) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    private void validateDrawLinePosition(Position startPosition) {
        validatePosition(startPosition);
        if (isLineAtPosition(startPosition) || isLineAtNextPosition(startPosition)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isInvalidPosition(Position position) {
        return position.isBiggerThan(nodes.length - 1) ;
    }

    private boolean isLineAtPosition(Position position) {
        return nodes[position.getValue()].isAlreadySetDirection();
    }

    private boolean isLineAtNextPosition(Position position) {
        position.next();
        boolean lineAtPosition = isLineAtPosition(position);
        position.prev();
        return lineAtPosition;
    }

    public int getRowValue(Position colPosition){
        return nodes[colPosition.getValue()].getDirectionValue();
    }
}