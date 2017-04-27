package memeTeam;

import processing.core.*;

public abstract class Button {
	int xPos; 
	int yPos; 
	int w; 
	int h; 
	Button(int xPos, int yPos, int width, int height) {
		this.xPos = xPos; 
		this.yPos = yPos; 
		w = width; 
		h = height;
	}
	abstract void display();
	abstract void editShape();
	
	
	protected int getXPos() {
		return xPos;
	}
	protected int getYPos() {
		return yPos;
	}
	protected int getWidth() {
		return w; 
	}
	protected int getHeight() {
		return h;
	}
}
