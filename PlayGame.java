import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class PlayGame {

  private BufferedReader input;
	private GameBoard board;
  // Bot player random moves
  private Random random; 
  
  // New game object
  public PlayGame(int height, int width) {
    input = new BufferedReader(new InputStreamReader(System.in));
    new Random();
    // Set up new board with values from the main
    board = new GameBoard(height, width);
  }
  // Implemantation of user's and bot's moves. Game process
  public void beginGame() {
    // Call method to print game instructions
    gameInstructions();
    // Initialize win variable
    boolean win = false;
    // If there is no winner, continue playing
    while (!win) {
      board.printBoard();
      System.out.println("\n");
			// player 1
      // Ask for user's column choice
      System.out.println("Red it's your turn!!\nPlease type the number of the column you want to drop your counter:");
      // Get users input / Store it as integer value into 'move' variable
      int move = getUserInput();

      // Call method to implement user's move 
      board.placeCounter('r', move);
      
      // Check for player's 1 win
      if (board.winner('r')) {
        win = true;
        board.checkWinner('r', "Red");
      } 
      else {
        int autoMove = randomNumber(1, 7);
        // Call method to implement bot's move
        board.placeCounter('y', autoMove);
        // Check winning situation vertically for bot
        board.vertical('y');
        // Check winning situation horizontally for bot
        board.horizontal('y');
        // Check for bot's win
        if (board.winner('y')) {
          win = true;
          board.checkWinner('y', "Yellow");
        }
      }  
    }
  }
  // Print game instructions
  private void gameInstructions() {
    System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players, Red and Yellow");
		System.out.println("Player 1 (you) is Red, Player 2 (computer) is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in"); 
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		System.out.println("");
  }
  // Return user's input as a string/ Check input correctness
  private int getUserInput() {
		String userInput = null;
    int userMove = 0;
	  try {
		  userInput = input.readLine();
      userMove = Integer.parseInt(userInput);
	  }
	  catch(Exception e) {
      System.out.println("Something went wrong. The input must always be a number.");
      System.out.println(e);
      System.out.println("Please try again.");
	  }
    System.out.print("\033[H\033[2J");
	  return userMove;
	}
  // Generate random numbers
  private static int randomNumber(int min, int max) {
    Random rand = new Random();
    return rand.nextInt((max - min) + 1) + min;
  }
}
  
  
