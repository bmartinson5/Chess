import pieces.King;
import pieces.Piece;
import pieces.Queen;

import java.util.ArrayList;

public class Player {

    private String name;
    private int id;
    private ArrayList<Piece> pieces = new ArrayList<>();

    public Piece checkLocationForPiece(int xCoordinate, int yCoordinate){
        for(Piece p: pieces){
            if(p.getxCoordinate() == xCoordinate && p.getyCoordinate() == yCoordinate)
                return p;
        }
        return null;
    }

    public Player(String name, int id) {
        this.name = name;
        this.id = id;

        this.setUpPieces();
    }

    public boolean movePlayer(int xCoord, int yCoord, int newXCoord, int newYCoord){
        //already know that new location is inbounds and whether empty or not

        //first locate Piece
        Piece pieceToMove = checkLocationForPiece(xCoord, yCoord);

        //Check if there is a piece there, and if it can move to the new Coordinates
        if(pieceToMove == null || !pieceToMove.checkMove(newXCoord, newYCoord))
            return false;

        pieceToMove.changeLocation(newXCoord, newYCoord);
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
