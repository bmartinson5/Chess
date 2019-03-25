package pieces;

public class Queen extends Piece{


    public Queen(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate, "Q");
    }

    @Override
    public boolean checkMove(LocationInfo locInfo) {
        if(locInfo.checkDiagonalMove() ||
                locInfo.checkVerticalHorizontalMove())
            return true;
        return false;
    }

}

