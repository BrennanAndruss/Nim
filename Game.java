/**
 * Game Class for the Game of Nim 
*/
import java.util.Scanner;

public class Game 
{
    // attributes
    private Player player1;
    private Player player2;
    private Scanner s = new Scanner(System.in);
    private boolean p1Turn = true;
    private boolean autoPlay = false;

    // constructors
    public Game()
    {
        System.out.println("One-player or two-players?");
        int ans = s.nextInt();
        while (ans != 1 || ans != 2) {
            System.out.println("Type '1' or '2'.");
            ans = s.nextInt();
        }
        System.out.print("Enter a name for player 1: ");
        player1 = new Player(s.nextLine());
        if (ans == 1) {
            autoPlay = true;
        } else {
            System.out.print("Enter a name for player 2: ");
            player2 = new Player(s.nextLine());
        }
    }

    // methods
    public void play() {
        // randomly choose a first player
        if ((int) (2 * Math.random()) == 0) {
            p1Turn = true;
        } else {
            p1Turn = false;
        }

        // Run the game until only one piece is left
        while (Board.getNumPieces() > 1) {
            System.out.println("There are " + Board.getNumPieces() + " pieces.");
            
            // Determine whose turn it is
            if(p1Turn) {
                System.out.print(player1.getName());
            } else {
                System.out.print(player2.getName());
            }
            
            // Prompt user to remove a valid number pieces
            System.out.print(", how many pieces would you like to remove? ");
            int num = s.nextInt();
            while (num > Board.getNumPieces()/2 || num <= 0 ){
                System.out.println("You can only remove up to " + Board.getNumPieces()/2 + " pieces.");
                System.out.print("How many pieces would you like to remove? ");
                num = s.nextInt();
            }
            Board.removePieces(num);
            
            // Switch players
            p1Turn = !p1Turn;
        }

        // Determine winner and add score
        if (!p1Turn) {
            System.out.println(player2.getName() + " takes the last piece.");
            System.out.println(player1.getName() + " is the winner.");
            player1.addScore();
        } else {
            System.out.println(player1.getName() + " takes the last piece.");
            System.out.println(player2.getName() + " is the winner.");
            player2.addScore();
        }
        System.out.println(player1.getName() + ": " + player1.getScore() + " points");
        System.out.println(player2.getName() + ": " + player2.getScore() + " points");

        // Allow user to restart the game
        System.out.print("Would you like to play again? ");
        String ans = s.next().toLowerCase();
        while (!ans.equals("yes") && !ans.equals("no")) {
            System.out.println("Type 'yes' or 'no'.");
            System.out.print("Would you like to play again? ");
            ans = s.next().toLowerCase();
        }
        if (ans.equals("yes")) {
            System.out.println();
            playAgain();
        }
    }

    private void playAgain() {
        Board.populate();
        p1Turn = true;
        play();
    }
}
