package memeTeam;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class DifficultyButton extends Button {
	int difficulty;
	String text;
	int textSize;
	DifficultyButton(PApplet p, float xPos, float yPos, float width, float height) {
		super(p, xPos, yPos, width, height);
		// TODO Auto-generated constructor stub
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
			SudokuScreen.difficulty = this.difficulty;
			GUI.transitionTime = true;
			GUI.newScreen = "sudoku";
		}
	
		
	}
	void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	void setText(String text) {
		this.text = text;
		textSize = super.initializeTextSize(text);
	}

}
