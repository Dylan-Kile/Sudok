package memeTeam;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class CloseInstructionsButton extends Button {

	CloseInstructionsButton(PApplet p, float xPos, float yPos, float width, float height) {
		super(p, xPos, yPos, width, height);
	
	}

	@Override
	void display() {
		parent.rect(super.getXPos(),super.getYPos(),super.getWidth(),super.getHeight()); 
		float spacingX = super.getWidth()/10; 
		float spacingY = super.getHeight()/10;
		float startX = super.getXPos() + spacingX;
		float startY = super.getYPos() + spacingY;
		float endX = super.getXPos() + super.getWidth() - spacingX; 
		float endY = super.getYPos() + super.getHeight() - spacingY;
		parent.line(startX,startY, endX, endY);
		parent.line(startX, endY, endX, startY);
		
	}

	@Override
	void handleClick(MouseEvent e) {
		if (super.wasClicked(e)) {
			GUI.transitionTime = true; 
			GUI.newScreen = GUI.previousScreen;
		}
	}

}
