/**
 * Project 2.5.11
 *
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

    public void addScore()
    {
        score++;
    }
}
