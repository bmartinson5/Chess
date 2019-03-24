package pieces;

import static java.lang.Math.abs;

public class King extends Piece {

    public King(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate, "K");
    }

    @Override
    public boolean checkMove(int newXCoordinate, int newYCoordinate) {
        int xAxisChange = abs(this.xCoordinate - newXCoordinate);
        int yAxisChange = abs(this.yCoordinate - newYCoordinate);
        int coordinateCompare = abs(xAxisChange - yAxisChange);

        if(xAxisChange > 1 || yAxisChange > 1)
            return false;  //illegal move

        if(xAxisChange == 1 && yAxisChange == 1)   //moved horizontal one space
            return true;
        if(coordinateCompare == 1)	//either x change and y didn't, or vice versa (== legal move- vertical or horizontal)
            return true;

        return false;  //illegal move - no move
    }

}
