package memeTeam;

import processing.core.*;
import processing.event.MouseEvent;

public class InstructionsButton extends Button {
	int textSize; 
	String text = "HELP";
	boolean isBeingRead = false;
	InstructionsButton(PApplet p, float xPos, float yPos, float width, float height) {
		super(p, xPos, yPos, width, height);
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
			isBeingRead = true;
			System.out.println("display instructions");
		}
		
	}
	public void resetButton() {
		isBeingRead = false;
	}

	public boolean isBeingRead() {
		return isBeingRead;
	}

}
