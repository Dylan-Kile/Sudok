package memeTeam;
import java.util.*;
import processing.core.PApplet;
public class Main extends PApplet{
	GUI gui;
	VisualGrid grid;
	ArrayList<Button> buttons;
	String keyDown;
	public static void main(String[] args) {
		PApplet.main("memeTeam.Main");
	}
	public void settings() {
		size(500,500);
	}
	
	public void setup() {
		SudokuPuzzle puzzle = new SudokuPuzzle(0);
		grid = new VisualGrid(this);
		gui = new GUI(this,puzzle.getPuzzle());
		buttons = gui.getButtons();
		keyDown = "a";

	}
	public void draw() {
		background(255);
		grid.display();		
		gui.display();

	}
	public void mouseClicked() {
		Button tempButton = null;
		for (Button b: buttons) {
			if (b.mouseHovering()) {
				tempButton = b;
				b.click();
			}
		}
		for (Button b: buttons) {
			if (b instanceof SudokuButton && b.isClicked() && !b.equals(tempButton) && tempButton != null) {
				b.click();
			}
		}
	}
	public void keyPressed() {
		if (isNumeric(Character.toString(key))) {
			keyDown = Character.toString(key);
			for (Button b: buttons) {
				if (b instanceof SudokuButton && b.isClicked()) {
					b.giveValue(Integer.parseInt(keyDown));
					System.out.println(keyDown);
				}
			}
		}
	}
	public void keyReleased() {
		keyDown = "a";
	}
	private static boolean isNumeric(String s) {
		return s.matches("-?\\d+(\\.\\d+)?");
	}
	
}
