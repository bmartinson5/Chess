package pieces;

import static java.lang.Math.abs;

abstract public class Piece {

    protected int xCoordinate;
    protected int yCoordinate;
    protected String name;
    protected String id;

    public String getId() {
        return id;
    }

    public Piece(int xCoordinate, int yCoordinate, String name) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.name = name;
        this.id = " ";
    }

    public Piece(int xCoordinate, int yCoordinate, String name, String id) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.name = name;
        this.id = id;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public String getName() {
        return name;
    }

    abstract public boolean checkMove(int newXCoordinate, int newYCoordinate);

    public void changeLocation(int newXCoordinate, int newYCoordinate){
        this.xCoordinate = newXCoordinate;
        this.yCoordinate = newYCoordinate;
    }

    protected boolean checkDiagonalMove(int newXCoordinate, int newYCoordinate){

        //used by bishop and queen

        int xAxisChange = abs(this.xCoordinate - newXCoordinate);
        int yAxisChange = abs(this.yCoordinate - newYCoordinate);
        int coordinateCompare = abs(xAxisChange - yAxisChange);

        if(coordinateCompare == 0)  //legal diagonal move; x and y change are equal
            return true;
        return false;
    }

    protected boolean checkVerticalHorizontalMove(int newXCoordinate, int newYCoordinate){

        int xAxisChange = abs(this.xCoordinate - newXCoordinate);
        int yAxisChange = abs(this.yCoordinate - newYCoordinate);

        if(xAxisChange > 0 && yAxisChange == 0)  //vertical change
            return true;

        if(yAxisChange > 0 && xAxisChange == 0)  //horizontal change
            return true;

        return false; //illegal move
    }


}
