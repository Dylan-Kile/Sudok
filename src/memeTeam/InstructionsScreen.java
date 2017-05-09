package memeTeam;

import processing.core.PApplet;
import processing.event.*;
import java.util.*;

public class InstructionsScreen extends Screen{
	String text = "How to Play"; 
	int textSize;
	CloseInstructionsButton close;
	public InstructionsScreen(PApplet p, int xPos, int yPos, int xLength, int yLength,boolean isUp) {
		super(p, xPos, yPos, xLength, yLength,isUp);
		textSize = super.getTextSize(text);
		float buttonSize = super.getXLength()/15;
		float x = super.getXPos() + super.getXLength()-buttonSize;
		close = new CloseInstructionsButton(parent,x,super.getYPos(),buttonSize,buttonSize);
	}

	@Override
	public void showScreen() {
		parent.background(0);
		parent.textSize(textSize);
		float x = super.getXPos() + (super.getXLength()-parent.textWidth(text))/2;
		float y = super.getYPos() + (parent.textAscent()+parent.textDescent());
		parent.text(text,x,y);
		displayRules();
		close.display();
		
	}
	public void displayRules() {
		Map<Integer,String> lines = new HashMap<Integer,String>();
		parent.textSize(16);
		float spacing = 2 + (parent.textAscent()+parent.textDescent());
		lines.put(0, "Sudoku: ");
		lines.put(1, "The sudoku board is split into 9 miniature 3x3 boxes."); 
		lines.put(2, "A number 1-9 must go into each cell."); 
		lines.put(3, "To place a number, click a cell and press 1-9.");
		lines.put(4, "You can cycle through cells by using the arrow keys.");
		lines.put(5, "To remove a number from a cell, press 0.");
		lines.put(6,"Each number can only appear once in a row, column, or box.");
		lines.put(7, "If a number conflicts, it will turn red and disappear.");
		lines.put(8, "If you get a row, column or box correct, it will light up.");
		lines.put(9, "To win, you must fill all cells with a number.");
		lines.put(10, "General Information:"); 
		lines.put(11, "Press 'p' to pause and unpause."); 
		lines.put(12, "Press 'm' to mute and unmute the music.");
		lines.put(13, "If you win, press 'n' to start a new game.");
		float x = super.getXPos()+super.getXLength()/24;
		for (int i = 0; i < lines.size(); i++) {
			float y = super.getYPos()+super.getYLength()/3 + spacing*i;
			parent.text(lines.get(i),x,y);
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		//Do Nothing
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		close.handleClick(e);
		
	}

	@Override
	public void arrowInput(int keyCode) {
		//Do Nothing
		
	}

}
