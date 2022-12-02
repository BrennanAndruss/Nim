/**
 * Project 2.5.11
 *
 * Board Class for the Game of Nim 
*/
public class Board 
{
    // attributes
    public static int pieces;

    // accessors
    public static void populate()
    {
        pieces = (int) (41 * Math.random()) + 10;
    }

    public static int getNumPieces()
    {
        return pieces;
    }

    public static void removePieces(int num)
    {
        // num should not be more than half of pieces
        pieces -= num;
    }
}
