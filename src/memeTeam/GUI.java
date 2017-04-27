package memeTeam;
import processing.core.PApplet;
import java.util.*;
public class GUI {
	String[][] board;
	String[][] playerBoard;
	PApplet parent;
	ArrayList<Button> buttons;
	public GUI(PApplet p,String[][] board) {
		this.board = board;		
		parent = p;		
		createSudokuButtons(board.length);

		playerBoard = new String[board.length][]; 
		for (int i = 0; i < board.length; i++) {
			playerBoard[i] = board[i].clone();
		}

	}
	public void display() {
		displayNumbers();
		displayButtons();
	}
	
	public void displayNumbers() {
		int boardSideSize = playerBoard.length;
		float buffer = parent.height/(boardSideSize+1);
		parent.textSize(20);
		for (int row = 0; row < boardSideSize; row++) {
			for (int col = 0; col < boardSideSize; col++) {
				String entry = playerBoard[row][col];
				if (board[row][col] == playerBoard[row][col]) {
					parent.fill(0);
				} else {
					parent.fill(255,50,50);
				}
				if (entry != "*") {
					float spacingX = -parent.textWidth(entry)/2;
					float spacingY = (parent.textAscent()+parent.textDescent())/2;
					parent.text(entry, spacingX+buffer+col*buffer,spacingY+buffer+row*buffer);
				}
			}
		}
	}
	private void createSudokuButtons(int numSquares) {
		float size = parent.height/(numSquares+1);
		float buffer = parent.height/(numSquares+1)/2;
		buttons = new ArrayList<Button>();
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (board[row][col] == "*") {
					SudokuButton b = new SudokuButton(parent,col*size+buffer,row*size+buffer,size,size);
					buttons.add(b);
				} 
			} 
		}
	}
	public void displayButtons() {
		for (Button b: buttons) {
			b.display();
		}
	}
	public ArrayList<Button> getButtons() {
		return buttons;
	}
	private void changeValue() {
		
	}
}
