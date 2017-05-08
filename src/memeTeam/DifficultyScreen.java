package memeTeam;

import processing.core.PApplet;
import processing.event.*;
import java.util.*;

public class DifficultyScreen extends Screen {
	Map<String,DifficultyButton> difficulties = new HashMap<>();
	String text = "Select a difficulty";
	int textSize;
	public DifficultyScreen(PApplet p, int xPos, int yPos, int xLength, int yLength, boolean isUp) {
		super(p, xPos, yPos, xLength, yLength, isUp);
		initializeFeatures();
		textSize = super.getTextSize(text);
	}
	
	private void initializeFeatures() { //includes buttons and appropriate text
		int buttonLength = 2*super.getXLength()/3;
		int buttonHeight = (super.getYLength()/2)/4;
		int spacing = 10 + buttonHeight;
		int startX = super.getXPos() + super.getXLength()/2 - buttonLength/2; 
		int startY = super.getYPos() + super.getYLength() - spacing*4;
 
		difficulties.put("Easy", new DifficultyButton(parent,startX,startY,buttonLength,buttonHeight));
		difficulties.put("Medium", new DifficultyButton(parent,startX,startY+spacing,buttonLength,buttonHeight));
		difficulties.put("Hard", new DifficultyButton(parent,startX,startY+2*spacing,buttonLength,buttonHeight));
		difficulties.put("Expert", new DifficultyButton(parent,startX,startY+3*spacing,buttonLength,buttonHeight));
		int i = 0;
		for (String difficulty: difficulties.keySet()) {
			DifficultyButton b = difficulties.get(difficulty);
			b.setDifficulty(i);
			b.setText(difficulty);
			i++;
		}
	} 

	@Override
	public void showScreen() {
		parent.background(0);
		parent.textSize(textSize);
		float x = super.getXPos() + (super.getXLength()-parent.textWidth(text))/2;
		float y = super.getYPos() + (parent.textAscent()+parent.textDescent());
		parent.text(text,x,y);		
		for (String difficulty: difficulties.keySet()) {
			difficulties.get(difficulty).display();
		} 
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//Do nothing		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (String difficulty: difficulties.keySet()) {
			difficulties.get(difficulty).handleClick(e);
		}
		
	}

	@Override
	public void arrowInput(int keyCode) {
		// TODO Auto-generated method stub
		
	}

}
