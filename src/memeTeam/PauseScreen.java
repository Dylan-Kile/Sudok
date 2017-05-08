package memeTeam;

import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class PauseScreen extends Screen {
	Button[] buttons = new Button[2];
	String text = "Paused"; 
	int textSize;
	public PauseScreen(PApplet p, int xPos, int yPos, int xLength, int yLength,boolean isUp) {
		super(p, xPos, yPos, xLength, yLength,isUp);
		initializeFeatures();
		textSize = super.getTextSize(text);
		
	}
	
	public void initializeFeatures() {
		int buttonLength = super.getXLength()/3;
		int buttonHeight = (super.getYLength()/2)/4;
		int spacing = 5 + buttonHeight; 
		int startX = super.getXLength()/2-buttonLength/2; 
		int startY = parent.height - (buttons.length)*(spacing);
		
		buttons[0] = new InstructionsButton(parent,startX,startY,buttonLength,buttonHeight);
		buttons[1] = new QuitToMenuButton(parent,startX,startY+(spacing),buttonLength,buttonHeight);
		
	}
	@Override
	public void showScreen() {
		parent.background(0);
		parent.textSize(textSize);
		float x = super.getXPos() + (super.getXLength()-parent.textWidth(text))/2;
		float y = super.getYPos() + (parent.textAscent()+parent.textDescent());
		parent.text(text,x,y);
		for (Button b : buttons) {
			b.display();
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKey() == 'p') {
			GUI.transitionTime = true; 
			GUI.newScreen = "sudoku";
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (Button b: buttons) {
			b.handleClick(e);
		}
		
	}

	@Override
	public void arrowInput(int keyCode) {
		//Do nothing
		
	}

}
