public class GameBoard {
  char[][] board;
  int height;
  int width;
  
  // New game object
  public GameBoard(int height, int width) {
    board = new char[height][width];
    this.height = height;
    this.width = width;
  }
  // Print game Board
  public void printBoard() {
    for(int i = 0; i <= height - 1; i++) {
			for(int j = 0; j <= width - 1; j++) {
				if(board[i][j] == 'r') {
					System.out.print("| r ");
				}
				else if(board[i][j] == 'y') {
					System.out.print("| y ");
				}
				else{
					System.out.print("|   ");
				}
			}
			System.out.println("|");
		}
    System.out.println("+---+---+---+---+---+---+---+");
		System.out.println("  1   2   3   4   5   6   7");
    System.out.println("+---+---+---+---+---+---+---+");
	}
  // Place counter
  public void placeCounter(char counter, int position) {
    boolean placed = false;
    // Place counter for the first player
		if (counter == 'r') {
      // Interate from the bottom to the top 
			for (int i = (height - 1); i >= 0; i--) {
				if (!placed) {
          // Check if the spot is already full
					if (board[i][position - 1] == 'y') {
						// skip
					}
          // if not throw the letter
					else if (board[i][position - 1] != 'r') {
						board[i][position - 1] = 'r';
						placed = true;
					}
				}
			}
		}
		else {
      // Place counter for the second player
			for (int i = (height-1); i >= 0; i--) {
				if (!placed) {
					if (board[i][position-1] == 'r') {
					 // skip
					}
					else if (board[i][position-1] != 'y') {
						board[i][position-1] = 'y';
						placed = true;
					} 
				}
			}
		}
	}
  
  // Check winning situation vertically
  public boolean vertical(char counter) {
    int count;
    // Iterate the width of the board
    for (int i = 0; i < width; i++) {
      count = 0;
      // Iterate the height of the board
      for (int j = 0; j < height; j++) {
        if (board[j][i] == counter) {
          count = count + 1;
          if (count >= 4) {
            return true;
          }
        } 
        else {
          count = 0;
        }
      }
      if (count >= 4) {
        return true;
      }
    }
    return false;
  }
  // Check winning situation horizontally
  public boolean horizontal(char counter) {
    int count;
    // Iterate the height of the board
    for (int i = 0; i < height; i++) {
      count = 0;
      // Iterate the width of the board
      for (int j = 0; j < width; j++) {
        if (board[i][j] == counter) {
          count = count + 1;
          if (count >= 4) {
            return true;
          }
        } 
        else {
          count = 0;
        }
      }
      if (count >= 4) {
        return true;
      }
    }
    return false;
  }

  // Check if there is a winner
  boolean winner(char counter) {
    if (vertical(counter) || horizontal(counter)) {
      return true;
    } 
    else {
      return false;
    }
  }
  // Display the winner or print the board
  public void checkWinner(char counter, String player) {
    if (winner(counter)) {
      printBoard();
      System.out.println("You are the winner " + player);
    }
    else {
      printBoard();
    }
  }



}
