package memeTeam;

import java.io.*;

public class SudokuPuzzle {
	
	final int SIZE = 9;
	String[][] puzzle; 
	String[][] finishedPuzzle;
	
	public SudokuPuzzle(int difficulty) {
		puzzle = new String[SIZE][SIZE];
		finishedPuzzle = new String[SIZE][SIZE];
		qqwing.QQWing.generateSudokuPuzzle(difficulty);
		fileReader();
		
	}
	
	private void fileReader() {
		String file = "puzzle.txt"; 
		
		try {
			
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader); 
			String board = bufferedReader.readLine().trim();
			createPuzzle(puzzle,board);
			String solution = bufferedReader.readLine().trim();
			createPuzzle(finishedPuzzle,solution);
			
			bufferedReader.close();
			
		} catch(FileNotFoundException e) {
			System.out.println("Unable to open file");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void createPuzzle(String[][] puzzle, String line) {
		String[] characterArray = line.split(""); 
		for (int elt = 0; elt < characterArray.length; elt++) {
			int row = elt/SIZE; 
			int column = elt%SIZE;
			if (characterArray[elt] == ".") {
				puzzle[row][column] = "*";
			} else {
				puzzle[row][column] = characterArray[elt];
			}
		}
	}
	  public void printPuzzle() {
		    System.out.print("["); 
		    for (int row = 0; row < puzzle.length; row++) {
		      for (int col = 0; col < puzzle.length; col++) {
		        System.out.print(puzzle[row][col]);
		        System.out.print(", ");
		      }
		      System.out.print("]\n[");
		    }
		  }

}
