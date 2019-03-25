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

    abstract public boolean checkMove(LocationInfo locInfo);

    public void changeLocation(LocationInfo locInfo){
        this.xCoordinate = locInfo.newX;
        this.yCoordinate = locInfo.newY;
    }





}



