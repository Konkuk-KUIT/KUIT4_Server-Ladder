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
        validateDrawLinePosition(position);
        setDirectionBetweenNextPosition(position); //현위치에 가로선
    }

    public void nextPosition(LadderPosition position) {
        validatePosition(position);
        nodes[position.getX()].move(position);
    }

    private void setDirectionBetweenNextPosition(LadderPosition position) {
        int currentIndex = position.getX();
        if (currentIndex < nodes.length - 1) {
            Node currentNode = nodes[currentIndex];
            Node nextNode = nodes[currentIndex + 1];

            if (!currentNode.isAlreadySetDirection() && !nextNode.isAlreadySetDirection()) {
                currentNode.setDirection(Direction.RIGHT);
                nextNode.setDirection(Direction.LEFT);
            } else {
                throw new IllegalArgumentException("Line already drawn between these positions.");
            }
        }
    }

    private void validatePosition(LadderPosition position) {
        if (!isValidPosition(position) ) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }
    private void validateDrawLinePosition(LadderPosition position) {
        int x = position.getX();
        if (x < 0 || x >= nodes.length - 1) {
            throw new IllegalArgumentException("Cannot draw line at this position.");
        }
        //현재 위치와 다음 위치가 이미 연결되었는지 확인
        if (nodes[x].isAlreadySetDirection() || nodes[x + 1].isAlreadySetDirection()) {
            throw new IllegalArgumentException("Line already drawn at this position or adjacent.");
        }
    }
    private boolean isValidPosition(LadderPosition position) {
        return position.getX() >= 0 && position.getX() < nodes.length;
    }
    /*private boolean isValidDrawLinePosition(LadderPosition position) {
        return isValidPosition(position) && position.getX() < nodes.length - 1;
    }*/

}