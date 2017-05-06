package memeTeam;

import processing.core.*;
import processing.event.MouseEvent;

public abstract class Button {
	float xPos; 
	float yPos; 
	float w; 
	float h; 
	PApplet parent;
	int valueToBeShown;
	Button(PApplet p,float xPos, float yPos, float width, float height) {
		this.xPos = xPos; 
		this.yPos = yPos; 
		w = width; 
		h = height;
		parent = p;
		valueToBeShown = 0;
	}
	
	abstract void display();
	abstract void handleClick(MouseEvent e);
	
	protected int initializeTextSize(String word) {
		int textSize = 1;
		int textUpper = 0; 
		int textLower = 0;
		int textWidth = 0;
		while (textUpper + textLower <= h && textWidth <= w-20 ) {
			parent.textSize(textSize);
			textWidth = (int)parent.textWidth(word);
			textUpper = (int)parent.textAscent(); 
			textLower = (int)parent.textDescent();
			textSize += 1;
		}
		return textSize - 1;
	}
	
	public float getXPos() {
		return xPos;
	}
	public float getYPos() {
		return yPos;
	}
	protected float getWidth() {
		return w; 
	}
	protected float getHeight() {
		return h;
	}
	protected PApplet getPApplet() {
		return parent;
	}
	public boolean wasClicked(MouseEvent e) {
		boolean withinX = e.getX()>=xPos && e.getX()<=xPos+w; 
		boolean withinY = e.getY()>=yPos && e.getY()<=yPos+h; 
		return withinX && withinY;
	}
}
