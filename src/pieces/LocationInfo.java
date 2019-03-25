package pieces;

import static java.lang.Math.abs;

public class LocationInfo{
    public int oldX;
    public int oldY;
    public int newX;
    public int newY;
    public int xAxisChange;
    public int yAxisChange;

    public LocationInfo(int x, int y, int newX, int newY){
        this.oldX = x;
        this.oldY = y;
        this.newX = newX;
        this.newY = newY;

        this.xAxisChange = abs(x - newX);
        this.yAxisChange = abs(y - newY);
    }

    public boolean checkDiagonalMove(){

        //used by bishop and queen

        int coordinateCompare = abs(this.xAxisChange - this.yAxisChange);

        if(coordinateCompare == 0)  //legal diagonal move; x and y change are equal
            return true;
        return false;
    }

    public boolean checkVerticalHorizontalMove(){

        if(this.xAxisChange > 0 && this.yAxisChange == 0){ //vertical change
            return true;
        }

        if(this.yAxisChange > 0 && this.xAxisChange == 0)  //horizontal change
            return true;

        return false; //illegal move
    }
}
