
/**
 * Project 2.5.11
 *
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
    // constructors
    public Game()
    {
        System.out.println("Enter a name for player 1: ");
        player1 = new Player(s.nextLine());
        System.out.println("Enter a name for player 2: ");
        player2 = new Player(s.nextLine());

    }

    public void play () {
        while(Board.getNumPieces()>=1){
            System.out.println("There are " + Board.getNumPieces() + " pieces.");
            if(p1Turn) {
                System.out.print(player1.getName());
            } else {
                System.out.print(player2.getName());
            }
            System.out.print(", how many pieces would you like to remove?");
            int num = s.nextInt();
            while(num>Board.getNumPieces()/2||num<=0){
                System.out.println("You can only remove up to " + Board.getNumPieces()/2 + " pieces.");
                System.out.println("How many pieces would you like to remove?");
                num = s.nextInt();
            }
            Board.removePieces(num);
            p1Turn = !p1Turn;
        }
        if(p1Turn) {
            System.out.println(player1.getName() + " is the winner.");
        } else {
            System.out.println(player2.getName() + " is the winner.");
        }

    }


}
