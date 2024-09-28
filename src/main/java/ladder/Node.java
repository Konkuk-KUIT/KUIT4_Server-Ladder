package ladder;

import ladder.enumclass.Direction;

import static ladder.enumclass.Direction.*;
import static ladder.enumclass.Direction.LEFT;

public class Node {
    private Direction direction;
    private Node(Direction direction) {
        this.direction=direction;
    }
    public static Node from (Direction direction){
        return new Node(direction);
    }
    public void setRightNodes(Position position){
        direction= RIGHT;
    }
    public void setLeftNodes(Position position){
        direction= LEFT;
    }
    public void move(Position position) {
        switch (this.direction) {
            case RIGHT:
                position.next();
                break;
            case LEFT:
                position.prev();
                break;
            default:
                break;
        }
    }


    public boolean isAlreadySetDirection(){
        return isNone();
    }
    public boolean isRight(){
        return direction==RIGHT;
    }

    public boolean isLeft(){
        return direction==LEFT;
    }


    private boolean isNone() {
        return direction == NONE;
    }

}
