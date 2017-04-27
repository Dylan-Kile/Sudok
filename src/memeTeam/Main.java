package memeTeam;
import processing.core.PApplet;
public class Main extends PApplet{

	public static void main(String[] args) {
		PApplet.main("memeTeam.Main");
	}
	public void settings() {
		size(500,500);
	}
	
	public void setup() {
		SudokuPuzzle puzzle = new SudokuPuzzle(0);
		puzzle.printPuzzle();
	}
	public void draw() {

	}

}
