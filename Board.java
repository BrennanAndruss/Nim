/**
 * Board Class for the Game of Nim 
*/

public class Board 
{
    // attributes
    public static int pieces;

    // accessors
    public static int getNumPieces()
    {
        return pieces;
    }

    // methods
    public static void populate()
    {
        pieces = (int) (41 * Math.random()) + 10;
    }

    public static void removePieces(int num)
    {
        pieces -= num;
    }
}
