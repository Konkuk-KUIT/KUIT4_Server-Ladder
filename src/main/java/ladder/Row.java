package ladder;

import static ladder.Direction.*;

public class Row {
    private final Node[] nodes;

    public Row(GreaterThanOne numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()];
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            //nodes[i] = Node.from(NONE);
            nodes[i] = new Node();
        }
    }

    public Node[] getNodes(){
        return nodes;
    }
    public void drawLine(LadderPosition position) {
        //validateDrawLinePosition(position);
        setDirectionBetweenNextPosition(position); //현위치에 가로선
    }

    public void nextPosition(LadderPosition position) {
        validatePosition(position);
        nodes[position.getX()].move(position);
    }

    private void setDirectionBetweenNextPosition(LadderPosition position) {
        int currentIndex = position.getX();
        if (currentIndex < 0 || currentIndex >= nodes.length - 1) {
            throw new IllegalArgumentException("선을 생성할 수 없는 위치입니다.");
        }
        Node currentNode = nodes[currentIndex];
        Node nextNode = nodes[currentIndex + 1];
        if (!currentNode.isAlreadySetDirection() && !nextNode.isAlreadySetDirection()) {
            currentNode.setDirection(Direction.RIGHT);
            nextNode.setDirection(Direction.LEFT);
        } else {
            throw new IllegalArgumentException("이미 생성된 선이 존재합니다.");
        }
    }

    private void validatePosition(LadderPosition position) {
        if (!isValidPosition(position) ) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    private boolean isValidPosition(LadderPosition position) {
        return position.getX() >= 0 && position.getX() < nodes.length;
    }
    /*private boolean isValidDrawLinePosition(LadderPosition position) {
        return isValidPosition(position) && position.getX() < nodes.length - 1;
    }*/

}