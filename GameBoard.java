/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

// imports necessary libraries for Java swing
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.LinkedList;

/**
 * GameBoard class specifies the functionality of the game board
 */
public class GameBoard {
    
	int[][] ba = new int[8][8];
	
	// moves is a LinkedList containing a series of 2-digit integer. The first
	// digit represents the row of a newly-added chip, while the second digit
	// represents its column
	LinkedList<Integer> moves = new LinkedList<Integer>();
	
	public GameBoard() {
		newGame();
	}
	
	public void newGame() {
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				ba[x][y] = 0;
			}
		}
		moves.removeAll(moves);
	}
	
	public int getChipColor(int x, int y) {
		return ba[x][y];
	}
	
	public int newChipPos(int colNum) {
		// Returns the place to put a new chip. If there is no room in the
		// column, returns -1
		for (int x = 0; x < 8; x++) {
			int curPos = 7 - x;
			if (ba[curPos][colNum] == 0) {
				return curPos;
			}
		}
		return -1;
	}
	
	public void addChip(int column, int turnVal) {
		if (newChipPos(column) != -1) {
			ba[newChipPos(column)][column] = turnVal;
			moves.add(newChipPos(column)*10 + column);
		}
	}
	
	public boolean isWinner() {
		// Check for each type of win (vertical, horizontal, or diagonal) and
		// return true if a win is detected
		boolean winState = false;
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 8; y++) {
				if (ba[x][y] != 0) {
					if (ba[x][y] == ba[x+1][y] && ba[x][y] == ba[x+2][y]
					   && ba[x][y] == ba[x+3][y]) {
						winState = true;
					}
				}
			}
		}
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 5; y++) {
				if (ba[x][y] != 0) {
					if (ba[x][y] == ba[x][y+1] && ba[x][y] == ba[x][y+2]
					   && ba[x][y] == ba[x][y+3]) {
						winState = true;
					}
				}
			}
		}
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				if (ba[x][y] != 0) {
					if (ba[x][y] == ba[x+1][y+1] && ba[x][y] == ba[x+2][y+2]
					   && ba[x][y] == ba[x+3][y+3]) {
						winState = true;
					}
				}
			}
		}
		for (int x = 3; x < 8; x++) {
			for (int y = 0; y < 5; y++) {
				if (ba[x][y] != 0) {
					if (ba[x][y] == ba[x-1][y+1] && ba[x][y] == ba[x-2][y+2]
					   && ba[x][y] == ba[x-3][y+3]) {
						winState = true;
					}
				}
			}
		}
		return winState;
	}
	
	public boolean isFull() {
		boolean ans = true;
		for (int x = 3; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if (ba[x][y] == 0) {
					ans = false;
				}
			}
		}
		return ans;
	}
	
	public void undo() {
		if (moves.size() > 0) {
			int lastMove = moves.getLast();
			if (lastMove > 69) {
				ba[7][lastMove-70] = 0;
			} else if (lastMove > 59) {
				ba[6][lastMove-60] = 0;
			} else if (lastMove > 49) {
				ba[5][lastMove-50] = 0;
			} else if (lastMove > 39) {
				ba[4][lastMove-40] = 0;
			} else if (lastMove > 29) {
				ba[3][lastMove-30] = 0;
			} else if (lastMove > 19) {
				ba[2][lastMove-20] = 0;
			} else if (lastMove > 9) {
				ba[1][lastMove-10] = 0;
			} else {
				ba[0][lastMove] = 0;
			}
			moves.removeLast();
		}
	}
	
	public String getChipPositions() {
		String allPos = "";
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				allPos = allPos + ba[x][y];
			}
		}
		return allPos;
	}
	
	public void putChipsIn(String chipList) {
		int ct = 0;
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				ba[x][y] = Integer.parseInt("" + chipList.charAt(ct));
				ct++;
			}
		}
	}
	
}