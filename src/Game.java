import pieces.LocationInfo;
import pieces.Piece;

import java.util.Scanner;

public class Game {

    private static Player player1 = new Player("Player 1", 1);
    private static Player player2 = new Player("Player 2", 2);


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean gameContinue = true;
        Player turn = player1;
        Player other = player2;

        while(gameContinue){
            printBoard();

            boolean validMove = true;

            do {
                validMove = gameTurn(turn, other, scanner);
            } while(!validMove);

            //change turn
            turn = (turn == player1) ? player2 : player1;
            other = (other == player1) ? player2 : player1;

        }

    }

    public static boolean gameTurn(Player turn, Player other, Scanner scanner){
        System.out.println("It's " + turn.getName() + "'s turn");

        System.out.print("X value of piece you want to move: ");
        int x = scanner.nextInt();
        System.out.print("Y value of piece you want to move: ");
        int y = scanner.nextInt();

        if(turn.checkLocationForPiece(x, y) == null){
            System.out.println("\nYou do not have a piece at that location! Try Again.\n");
            return false;
        }

        System.out.print("X value of location you want to move this piece to: ");
        int newX = scanner.nextInt();
        System.out.print("Y value of location you want to move this piece to: ");
        int newY = scanner.nextInt();

        if(!checkInBounds(newX, newY)){
            System.out.println("\nNot a valid location! Try Again.\n");
            return false;
        }
        LocationInfo locationInfo = new LocationInfo(x, y, newX, newY);

        return checkPlayerMove(turn, other, locationInfo);
    }


    public static boolean checkPlayerMove(Player turn, Player other, LocationInfo locationInfo){
        //complete move if valid
        //check for opponent piece at new location and in between,
        // and then move player, which validates further
        if(turn.checkForPieceBetween(locationInfo)
                || other.checkForPieceBetween(locationInfo)
                || turn.checkLocationForPiece(locationInfo.newX, locationInfo.newY) != null
                || !turn.movePlayer(locationInfo)
            ){

            System.out.println("\nIllegal move! Try Again.\n");
            return false;
        }
        else{
            Piece defeatedPiece = other.checkLocationForPiece(locationInfo.newX, locationInfo.newY);
            if(defeatedPiece != null){
                System.out.println(other.getName() + " has lost a piece!");
                other.removePiece(defeatedPiece);
            }
            return true;
        }
    }

    public static boolean checkInBounds(int x, int y){
        if(x < 1 || y < 1 || x > 8 || y > 8)
            return false;
        return true;
    }

    public static void printBoard(){
        System.out.print("\n\t\t" + player2.getName() + "'s Pieces");

        System.out.print("\n  ------------------------------------------------\n");
        for(int i = 8; i > 0; --i){
            System.out.print(i);
            for(int j = 0; j < 8; ++j){
                System.out.print(" | ");
                Piece player1Piece = player1.checkLocationForPiece(j+1, i);
                Piece player2Piece = player2.checkLocationForPiece(j+1, i);
                if(player1Piece != null)
                    System.out.print(player1Piece.getName() + player1Piece.getId() + " ");
                else if(player2Piece != null)
                    System.out.print(player2Piece.getName() + player2Piece.getId() + " ");
                else{
                    System.out.print("   ");
                }
            }
            System.out.print("|\n  ------------------------------------------------\n");
        }

        System.out.print("    1     2     3     4     5     6     7     8\n");
        System.out.print("\n\t\t" + player1.getName() + "'s Pieces\n\n");
    }


}
