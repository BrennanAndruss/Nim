/**
 * Player Class for the Game of Nim 
*/
public class Player 
{
    // attributes
    private String name;
    private int score = 0;

    // constructors
    public Player(String name)
    {
        this.name = name;
        score = 0;
    }

    // accessors
    public String getName()
    {
        return name;
    }

    public int getScore()
    {
        return score;
    }

    // methods
    public void addScore()
    {
        score++;
    }

    // autoplay AI
    public int autoPlay()
    {
        // Take a number of pieces that puts the computer at an advantage state
        int num = 1;
        int targetNum = 0;
        while (num < Board.getNumPieces()) {
            targetNum = num;
            num = num * 2 + 1;
        }
        int numRemove = Board.getNumPieces() - targetNum;
        
        // Take the ideal number of pieces if valid
        if (numRemove > Board.getNumPieces()/2) {
            return numRemove;
        } else {
            return (int) (Math.random() * (Board.getNumPieces()/2));
        }
    }
}
