/*
Game of Nim
Brennan and Derek
12/5/2022
AP Computer Science A Trimester 2 Woldseth

Description: Play a game of nim with two players or against a computer
*/

/**
 * GameRunner Class for the Game of Nim 
*/

public class GameRunner
{
  public static void main(String[] args)
  {
    System.out.println("Welcome to the Game of Nim!");

    Board.populate(); // static method call
    
    Game nim = new Game(); 
    nim.play();
  }
}