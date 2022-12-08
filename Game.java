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
    private boolean autoPlay = false;

    // constructors
    public Game()
    {
        System.out.println("1-player or 2-players? ");
        String ans = s.nextLine();
        while (!ans.equals("1") && !ans.equals("2")) {
            System.out.println("Type '1' or '2'.");
            ans = s.nextLine();
        }
        System.out.print("Enter a name for player 1: ");
        String name = s.nextLine();
        player1 = new Player(name);
        if (ans.equals("1")) {
            autoPlay = true;
            player2 = new Player("Computer");
        } else {
            System.out.print("Enter a name for player 2: ");
            player2 = new Player(s.nextLine());
        }
    }

    // methods
    public void play() {
        Player currentPlayer;
        Player prevPlayer;

        // Randomly choose a first player
        if ((int) (2 * Math.random()) == 0) {
            currentPlayer = player1;
            prevPlayer = player2;
        } else {
            currentPlayer = player2;
            prevPlayer = player1;
        }

        // Run the game until only one piece is left
        while (Board.getNumPieces() > 1) {
        System.out.println("\nThere are " + Board.getNumPieces() + " pieces.");
            
            // Prompt current player to remove a valid number of pieces
            String input = "";
            int num = 0;
            if (!(currentPlayer == player2 && autoPlay))
            {
                // Check for valid selection
                while((num > Board.getNumPieces()/2 || num <= 0)) 
                {
                    System.out.println("You can remove up to " + Board.getNumPieces()/2 + " pieces.");
                    System.out.print(currentPlayer.getName() + ", how many pieces would you like to remove?: ");
                    input = s.nextLine();
                    // Check for valid integer input
                    try
                    {
                        num = Integer.parseInt(input);
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Enter a valid integer.");
                    }
                }
                Board.removePieces(num);
            }
            // Computer automatically makes a selection
            else
            {
                num = currentPlayer.autoPlay();
                System.out.println(currentPlayer.getName() + " removes " + num + " pieces.");
                Board.removePieces(num);
            }
            
            // Switch players
            Player temp = prevPlayer;
            prevPlayer = currentPlayer;
            currentPlayer = temp;
        }

        // Announce the winner and add score
        System.out.println(currentPlayer.getName() + " takes the last piece.");
        System.out.println(prevPlayer.getName() + " is the winner");
        currentPlayer.addScore();

        System.out.println("\n" + player1.getName() + ": " + player1.getScore() + " points");
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
        play();
    }
}
