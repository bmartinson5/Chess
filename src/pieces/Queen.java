package pieces;

public class Queen extends Piece{


    public Queen(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate, "Q");
    }

    @Override
    public boolean checkMove(int newXCoordinate, int newYCoordinate) {
        if(checkDiagonalMove(newXCoordinate, newYCoordinate) ||
                checkVerticalHorizontalMove(newXCoordinate, newYCoordinate))
            return true;
        return false;
    }

}

