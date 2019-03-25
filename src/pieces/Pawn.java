package pieces;

public class Pawn extends Piece{

    private boolean firstMove = true;

    public Pawn(int xCoordinate, int yCoordinate, String name, String id) {
        super(xCoordinate, yCoordinate, name, id);
    }

    @Override
    public boolean checkMove(LocationInfo locInfo) {
        return true;
    }
}
