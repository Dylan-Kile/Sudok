package memeTeam;
import processing.core.*;
public class SudokuButton extends Button {
	PApplet parent;
	int valueToBeShown;
	public SudokuButton(PApplet p,float xPos, float yPos, float width, float height) {
		super(p,xPos, yPos, width, height);
		parent = super.getPApplet();
		valueToBeShown = 0;
	}



	void display() {
		parent.noStroke();
		if (super.isClicked()) {
			parent.fill(255,255,4,50);
		} else {
			parent.fill(255,255,255,30);
		}
		
		parent.rect(super.getXPos(), super.getYPos(), super.getWidth(), super.getHeight());
		
		parent.stroke(0);
		
	}
	public void giveValue(int num) {
		valueToBeShown = num;
		
	}

	void editShape() {
		// TODO Auto-generated method stub
		
	}

}
