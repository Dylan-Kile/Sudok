package memeTeam;

import java.util.ArrayList;

import processing.core.*;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class TitleScreen extends Screen {
	boolean isUp = true;
	StartButton start;
	InstructionsButton instructions;
	QuitButton quit;
	String text = "SUDOKU";
	int textSize;
	TitleScreen(PApplet p,int xPos, int yPos, int xLength, int yLength,boolean isUp) {
		super(p,xPos,yPos,xLength,yLength,isUp);
		initializeFeatures();
		textSize = 1;
		int textUpper = 0; 
		int textLower = 0;
		int textWidth = 0;
		while (textUpper + textLower <= yLength  && textWidth <= xLength-parent.width/10 ) {
			parent.textSize(textSize);
			textWidth = (int)parent.textWidth(text);
			textUpper = (int)parent.textAscent(); 
			textLower = (int)parent.textDescent();
			textSize += 1;
		}
		textSize--;
	}
	
	
	public void showScreen() {
		PApplet parent = super.getPApplet();
		if (!start.getStartStatus() && !instructions.isBeingRead()) {
			parent.fill(0);
			parent.rect(xPos, yPos, xLength, yLength);
			parent.fill(255);
			parent.textSize(textSize);
			float x = super.getXPos() + (super.getXLength()-parent.textWidth(text))/2;
			float y = super.getYPos() + (parent.textAscent()+parent.textDescent());
			parent.text(text,x,y);
			start.display(); 
			instructions.display(); 
			quit.display();
		}
	}
	private void initializeFeatures() { //includes buttons and appropriate text
		int buttonLength = 2*super.getXLength()/3;
		int buttonHeight = super.getYLength()/6;
		int startX = super.getXPos() + super.getXLength()/2 - buttonLength/2; 
		int startY = super.getYPos() + super.getYLength()/2 - buttonHeight/2;
		int spacingBetweenButtons = 10; 
		start = new StartButton(parent,startX,startY,buttonLength,buttonHeight);
		instructions = new InstructionsButton(parent,startX,startY + spacingBetweenButtons+buttonHeight,buttonLength,buttonHeight);
		quit = new QuitButton(parent,startX,startY + 2*(buttonHeight + spacingBetweenButtons),buttonLength,buttonHeight);
		
	} 
	public void changeTitleScreenStatus(boolean isUp) {
		this.isUp = isUp;
		if (isUp) {
			start.resetButton(); 
			instructions.resetButton();
		}
	}
	public boolean isTitleScreenUp() {
		return isUp;
	}
	public void addButtonsToList(ArrayList<Button> buttons) {
		buttons.add(start); 
		buttons.add(instructions);
		buttons.add(quit);
	}


	public void mouseClicked(MouseEvent e) {
		start.handleClick(e);
		instructions.handleClick(e); 
		quit.handleClick(e);
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		//Do nothing
		
	}


	@Override
	public void arrowInput(int keyCode) {
		// TODO Auto-generated method stub
		
	}
	
}
