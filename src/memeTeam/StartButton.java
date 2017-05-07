package memeTeam;

import processing.core.*;
import processing.event.MouseEvent;

public class StartButton extends Button{
	PApplet parent;
	boolean start = false;
	String text = "START";
	int textSize = 1;
	StartButton(PApplet p, float xPos, float yPos, float width, float height) {
		super(p, xPos, yPos, width, height);
		parent = super.getPApplet();
		textSize = super.initializeTextSize(text);
	}

	@Override
	void display() {
		
		parent.rect(super.getXPos(), super.getYPos(), super.getWidth(), super.getHeight());	
		parent.fill(0);
		parent.textSize(textSize);
		float x = super.getXPos() + (super.getWidth()-parent.textWidth(text))/2;
		float y = super.getYPos() + (parent.textAscent()+parent.textDescent()+super.getHeight()/2)/2;
		parent.text(text, x, y);
		parent.fill(255);
		
	}

	@Override
	void handleClick(MouseEvent e) {
		if (super.wasClicked(e)) {
			start = true;
			GUI.transitionTime = true; 
			GUI.newScreen = "difficulty";
		}
	}

	
	public boolean getStartStatus() {
		return start;
	}
	public void resetButton() {
		start = false;
	}

}
