package memeTeam;

import processing.core.*;

public abstract class Button {
	float xPos; 
	float yPos; 
	float w; 
	float h; 
	PApplet parent;
	boolean clicked;
	int valueToBeShown;
	Button(PApplet p,float xPos, float yPos, float width, float height) {
		this.xPos = xPos; 
		this.yPos = yPos; 
		w = width; 
		h = height;
		parent = p;
		clicked = false;
		valueToBeShown = 0;
	}
	
	abstract void display();
	abstract void editShape();
	abstract void giveValue(int num);
	abstract int getValue();
	
	
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
	protected boolean isClicked() {
		return clicked;
	}
	
	protected PApplet getPApplet() {
		return parent;
	}
	public void click() {
		clicked =! clicked;
	}
	public boolean mouseHovering() {
		boolean withinX = parent.mouseX>=xPos && parent.mouseX<=xPos+w; 
		boolean withinY = parent.mouseY>=yPos && parent.mouseY<=yPos+h; 
		return withinX && withinY;
	}


}
