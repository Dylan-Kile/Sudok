package memeTeam;
import java.util.ArrayList;

import processing.core.*;
import processing.event.MouseEvent;
public class SudokuButton extends Button {
	String value;
	private boolean isClicked = false;
	boolean isGiven = false;
	boolean clear = false;
	private int textFill;
	private static final int xBuffer = -5;
	private static final int yBuffer = 10;
	private int animationCounter = 0;
	private boolean correct = false;
	private static final int animationMaxCount = 30;
	
	public SudokuButton(PApplet p,float xPos, float yPos, float size) {
		super(p,xPos, yPos, size, size);
		this.value = "0";
		this.textFill = p.color(50,50,220);
	}
	
	public SudokuButton(PApplet p,float xPos, float yPos, float size, String value) {
		super(p,xPos, yPos, size, size);
		this.isGiven = true;
		this.value = value;
		this.textFill = p.color(0);
	}
	
	@Override
	void display() {
		PApplet p = super.getPApplet();
		if(animationCounter == 0) {
			if (isClicked) {
				p.fill(255,255,4,80);
			} else {
				p.fill(255,255,255,30);
			}			

		} else {
			animationCounter += 1;
			if(this.correct) {
				p.fill(50,255,50,80);
			} else {
				p.fill(255,50,50,80);
				if(animationCounter == SudokuButton.animationMaxCount && this.clear) {
					this.value = "0"; //clear invalid value
				}
			}
			if(animationCounter == SudokuButton.animationMaxCount) {
				animationCounter = 0;
			}
		}
		super.getPApplet().rect(super.getXPos(), super.getYPos(), super.getWidth(), super.getHeight());
		if (!this.value.equals("0")) {
			p.fill(this.textFill);
			p.text(this.value, super.getXPos() + super.getWidth()/2 + xBuffer, super.getYPos() + super.getHeight()/2 + yBuffer);
		}
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void animateCorrect() {
		this.correct = true;
		animationCounter = 1;
	}
	
	public void animateInvalid(boolean clear) {
		this.clear = clear;
		this.correct = false;
		animationCounter = 1;
	}
	
	public void handleClick(MouseEvent e, ArrayList<Button> buttons) {
		if(!isGiven) {
			if(this.wasClicked(e)) {
				for(Button b : buttons) {
					if(b instanceof SudokuButton) {
						((SudokuButton) b).isClicked = false;
					}
				}
				this.isClicked = !this.isClicked;
			}
		}
	}
	
	public boolean isClicked() {
		return this.isClicked;
	}
	
	public boolean isGiven() {
		return this.isGiven;
	}
	
	public void click() {
		if(!this.isClicked) {
			this.isClicked = true;
		} else {
			this.isClicked = false;
		}
	}

	@Override
	void handleClick(MouseEvent e) {
		//TODO
	}
}
