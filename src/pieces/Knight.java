package pieces;

public class Knight extends Piece{
    public Knight(int xCoordinate, int yCoordinate, String name, String id) {
        super(xCoordinate, yCoordinate, name, id);
    }

    @Override
    public boolean checkMove(LocationInfo locInfo) {
        if((locInfo.xAxisChange == 2 && locInfo.yAxisChange == 1) ||
                (locInfo.yAxisChange == 2 && locInfo.xAxisChange == 1))
                return true;
        return false;
    }
}
