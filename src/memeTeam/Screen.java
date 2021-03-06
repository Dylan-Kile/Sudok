package memeTeam;
import processing.core.*;
import processing.event.KeyEvent;
import processing.event.MouseEvent;
public abstract class Screen {
	int xPos; 
	int yPos; 
	int xLength; 
	int yLength;
	PApplet parent;
	boolean isUp;
	public Screen(PApplet p,int xPos, int yPos, int xLength, int yLength,boolean isUp) {
		this.xPos = xPos; 
		this.yPos = yPos; 
		this.xLength = xLength; 
		this.yLength = yLength;
		parent = p;
		this.isUp = isUp;
	}
	
	public abstract void showScreen(); 
	public abstract void keyPressed(KeyEvent e);
	public abstract void mouseClicked(MouseEvent e);
	public abstract void arrowInput(int keyCode);

	
	protected PApplet getPApplet() {
		return parent;
	}
	protected int getXPos() {
		return xPos;
	}
	protected int getYPos() {
		return yPos; 
	}
	protected int getXLength() {
		return xLength;
	}
	protected int getYLength() {
		return yLength;
	}
	public boolean isUp() {
		return isUp;
	}
	public void setStateOfScreen(boolean newState) {
		isUp = newState;
	}
	public int getTextSize(String text) {
		int textSize = 1;
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
		return textSize;
	}


	
}	
