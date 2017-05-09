package memeTeam;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class SudokuScreen extends Screen {
	SudokuPuzzle puzzle;
	SudokuButton[][] board;
	PApplet parent;
	static int difficulty = 0;
	ArrayList<Button> buttons = new ArrayList<Button>();
	
	public SudokuScreen(PApplet p, int xPos, int yPos, int xLength, int yLength,boolean isUp) {
		super(p, xPos, yPos, xLength, yLength, isUp);
		this.parent = p;
		this.parent.textSize(20);
		this.puzzle = new SudokuPuzzle(difficulty);
		createSudokuButtons(puzzle.getPuzzle().length);
	}

	@Override
	public void showScreen() {
		
		parent.noStroke();
		parent.textSize(20);
		displayButtons();
		parent.stroke(0);
		
	}
	public void keyPressed(KeyEvent e) {	
		if (e.getKey() == 'p') {
			GUI.transitionTime = true; 
			GUI.newScreen = "pause";
		}
		for(int i = 0; i < SudokuPuzzle.SIZE; i++) {
			for(int j = 0; j < SudokuPuzzle.SIZE; j++) {
				if(board[i][j].isClicked()) {
					if (e.getKey() != 'p') {
						board[i][j].setValue(Character.toString(e.getKey()));
					}
					String[][] stringBoard = boardToString();
					int rowConflict = puzzle.get1DIndexOfConflictionRow(i, j, stringBoard);
					int colConflict = puzzle.get1DIndexOfConflictionColumn(i, j, stringBoard); 
					int regionConflict = puzzle.get1DIndexOfConflictionRegion(i, j, stringBoard);
					boolean row = puzzle.rowIsCorrect(i,stringBoard);
					boolean column = puzzle.columnIsCorrect(j, stringBoard);
					boolean region = puzzle.regionIsCorrect(i, j, stringBoard);
					String value = board[i][j].getValue();
					boolean valueEqualsZero = value.equals("0");
					if ((rowConflict != -1 || colConflict != -1 || regionConflict != -1) && !valueEqualsZero) {
						int newRow; 
						int newCol;
						Main.sound.invalidEntry();
						if (rowConflict != -1) {
							newRow = rowConflict/SudokuPuzzle.SIZE; 
							newCol = rowConflict%SudokuPuzzle.SIZE;
							animateConflict(i,j,newRow,newCol);
						}
						if (colConflict != -1) {
							newRow = colConflict/SudokuPuzzle.SIZE; 
							newCol = colConflict%SudokuPuzzle.SIZE; 
							animateConflict(i,j,newRow,newCol);
						}
						if (regionConflict != -1) {
							newRow = regionConflict/SudokuPuzzle.SIZE; 
							newCol = regionConflict%SudokuPuzzle.SIZE;
							animateConflict(i,j,newRow,newCol);
						}
					}					
					if(row || column || region) {
						Main.sound.correctSection();
						if(row) {
							animateCorrect(i, 0, i+1, SudokuPuzzle.SIZE);
						}
						if(column) {
							animateCorrect(0, j, SudokuPuzzle.SIZE, j+1);
						}
						if(region){
							int startRow = i - i%SudokuPuzzle.SIZESQRT;
							int startColumn = j - j%SudokuPuzzle.SIZESQRT;
							animateCorrect(startRow, startColumn, startRow + SudokuPuzzle.SIZESQRT, startColumn + SudokuPuzzle.SIZESQRT);
						}
					}
					if(puzzle.puzzleIsCorrect(stringBoard)) {
						Main.sound.correctBoard();
						Main.endGameFireworks = new ExplosionEvent(parent);
					}
				}				
			}
		}
	}
	
	private String[][] boardToString() {
		String[][] stringBoard = new String[SudokuPuzzle.SIZE][SudokuPuzzle.SIZE];
		for(int i = 0; i < SudokuPuzzle.SIZE; i++) {
			for(int j = 0; j < SudokuPuzzle.SIZE; j++) {
				stringBoard[i][j] = board[i][j].getValue();
			}
		}
		return stringBoard;
	}
	
	public void animateCorrect(int row1, int column1, int row2, int column2) {
		for(int i = row1; i < row2; i++) {
			for(int j = column1; j < column2; j++) {
				board[i][j].animateCorrect();
			}
		}
	}
	
	public void animateConflict(int row1, int column1, int row2, int column2) { //do when there is an obvious conflict in row/column/section
		board[row1][column1].animateInvalid(true);
		board[row2][column2].animateInvalid(false);
		
	}
	
	public void mouseClicked(MouseEvent e) {		
		for(Button b: buttons) {
			if(b instanceof SudokuButton) {
				((SudokuButton) b).handleClick(e, buttons);
			}
			else{
				b.handleClick(e);
			}
		}
	}	
	
	private void createSudokuButtons(int numSquares) {
		this.board = new SudokuButton[SudokuPuzzle.SIZE][SudokuPuzzle.SIZE];
		float size = parent.height/(numSquares+1);
		float buffer = parent.height/(numSquares+1)/2;
		for (int row = 0; row < SudokuPuzzle.SIZE; row++) {
			for (int col = 0; col < SudokuPuzzle.SIZE; col++) {
				String value = puzzle.getPuzzle()[row][col];
				if (value.equals("*")) {
					board[row][col] = new SudokuButton(parent,col*size+buffer,row*size+buffer,size);
					
				} else {
					board[row][col] = new SudokuButton(parent,col*size+buffer,row*size+buffer,size,value);
				}
				buttons.add(board[row][col]);
			}
		}
	}
	private void clickDirection(int row, int column, int xDirection, int yDirection) {
		for(int i = 0; i < SudokuPuzzle.SIZE; i++) {
			row += yDirection;
			column += xDirection;
			if(row < 0) {
				row = SudokuPuzzle.SIZE + row;
			}
			if(column < 0) {
				column = SudokuPuzzle.SIZE + column;
			}
			row %= SudokuPuzzle.SIZE;
			column %= SudokuPuzzle.SIZE;
			if(!board[row][column].isGiven()) {
				board[row][column].click();
				return;
			}			
		}
	}
	
	public void arrowInput(int keyCode) {
		for(int i = 0; i < SudokuPuzzle.SIZE; i++) {
			for(int j = 0; j < SudokuPuzzle.SIZE; j++) {
				if(board[i][j].isClicked()) {
					if(keyCode == Main.UP) {
						clickDirection(i,j,0,-1);
					} else if(keyCode == Main.RIGHT) {
						clickDirection(i,j,1,0);
					} else if(keyCode == Main.DOWN) {
						clickDirection(i,j,0,1);
					} else if(keyCode == Main.LEFT) {
						clickDirection(i,j,-1,0);
					}
					board[i][j].click();
					return;
				}
			}
		}
	}
	private void displayButtons() {		
		for (Button b: buttons) {
			b.display();
		}
	}
	public void changeDifficulty(int difficulty) {
		SudokuScreen.difficulty = difficulty;
	}
	

}
