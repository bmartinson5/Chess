package pieces;

public class Bishop extends Piece{

    public Bishop(int xCoordinate, int yCoordinate, String name, String id) {
        super(xCoordinate, yCoordinate, name, id);
    }

    @Override
    public boolean checkMove(LocationInfo locInfo) {
        return locInfo.checkDiagonalMove();
    }
}
