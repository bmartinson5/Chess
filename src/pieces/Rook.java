package pieces;

public class Rook extends Piece{
    public Rook(int xCoordinate, int yCoordinate, String name, String id) {
        super(xCoordinate, yCoordinate, name, id);
    }

    @Override
    public boolean checkMove(LocationInfo locInfo) {
        return locInfo.checkVerticalHorizontalMove();
    }
}
