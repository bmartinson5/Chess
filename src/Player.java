import pieces.King;
import pieces.LocationInfo;
import pieces.Piece;
import pieces.Queen;

import java.util.ArrayList;

public class Player {

    private String name;
    private int id;
    private ArrayList<Piece> pieces = new ArrayList<>();

    public Player(String name, int id) {
        this.name = name;
        this.id = id;

        this.setUpPieces();
    }

    public Piece checkLocationForPiece(int newX, int newY){
        for(Piece p: pieces){
            if(p.getxCoordinate() == newX && p.getyCoordinate() == newY)
                return p;
        }
        return null;
    }

    public boolean removePiece(Piece piece){
        pieces.remove(piece);
        return true;
//        int idx = 0;
//        while(idx < pieces.size()){
//            if(pieces.get(idx) == piece){
//                pieces.remove
//                return true;
//            }
//        }
    }

    public boolean checkForPieceBetween(LocationInfo locInfo){
        //first check which kind of move it is, then increment x and/or y values to check spots
        //in between old and new coordinates


        int xChange = (locInfo.newX < locInfo.oldX) ? -1 : 1;
        int yChange = (locInfo.newY < locInfo.oldY) ? -1 : 1;
        int xIdx = locInfo.oldX+xChange;
        int yIdx = locInfo.oldY+yChange;

        if(locInfo.checkDiagonalMove()){
            while(xIdx != locInfo.newX && yIdx != locInfo.newY){
                if(checkLocationForPiece(xIdx, yIdx) != null)
                    return true;
                xIdx += xChange;
                yIdx += yChange;
            }
        }
        else if(locInfo.checkVerticalHorizontalMove()){
            if(locInfo.xAxisChange > 0){
                while(xIdx != locInfo.newX){
                    if(checkLocationForPiece(xIdx, locInfo.oldY) != null)
                        return true;
                    xIdx += xChange;

                }
            }
            else{
                while(xIdx != locInfo.newX){
                    if(checkLocationForPiece(locInfo.oldX, yIdx) != null)
                        return true;
                    yIdx += yChange;
                }
            }
        }
        //no piece found between move that was strictly horizontal, vertical or diagonal -- Horse can jump over
        return false;
    }



    public boolean movePlayer(LocationInfo locInfo){
        //already know that new location is inbounds and whether empty or not

        //first locate Piece
        Piece pieceToMove = checkLocationForPiece(locInfo.oldX, locInfo.oldY);

        //Check if there is a piece there, and if it can legally move to the new Coordinates
        if(pieceToMove == null || !pieceToMove.checkMove(locInfo))
            return false;

        pieceToMove.changeLocation(locInfo);
        return true;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    private void setUpPieces(){

        if(this.id == 1){
            pieces.add(new King(4, 1));
            pieces.add(new Queen(5, 1));
        }
        else{
            pieces.add(new King(5, 8));
            pieces.add(new Queen(4, 8));
        }
    }


}
