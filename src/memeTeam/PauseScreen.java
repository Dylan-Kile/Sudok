package memeTeam;

import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class PauseScreen extends Screen {

	public PauseScreen(PApplet p, int xPos, int yPos, int xLength, int yLength,boolean isUp) {
		super(p, xPos, yPos, xLength, yLength,isUp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showScreen() {
		parent.background(0);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKey() == 'p') {
			GUI.transitionTime = true; 
			GUI.newScreen = GUI.previousScreen;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void arrowInput(int keyCode) {
		//Do nothing
		
	}

}
