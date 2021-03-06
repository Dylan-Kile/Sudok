package memeTeam;
import processing.core.PApplet;
import java.util.*;
import processing.event.*;
public class GUI {
	Map<String, Screen> screens = new HashMap<>();
	static String previousScreen;
	static boolean transitionTime = false;
	static String newScreen = "title";
	PApplet p;
	public GUI(PApplet p) {
		this.p = p;
		screens.put("title", new TitleScreen(p,0,0,p.width,p.height,true));
		screens.put("instructions", new InstructionsScreen(p,0,0,p.width,p.height,false));
		screens.put("difficulty", new DifficultyScreen(p,0,0,p.width,p.height,false));
		screens.put("pause", new PauseScreen(p,0,0,p.width,p.height,false));		
	}
	public void display() {
		for (String s: screens.keySet()) {
			Screen screen = screens.get(s);
			if (screen.isUp()) {
				
				screen.showScreen();
			}
		}
	}
	public void keyPressed(KeyEvent e) {
		for (String s: screens.keySet()) {
			Screen screen = screens.get(s);
			if (screen.isUp()) {
				screen.keyPressed(e);
			}
		}
		if (transitionTime) {
			transitionTo(newScreen);
		}

 	}
	public void mouseClicked(MouseEvent e) {
		for (String s: screens.keySet()) {
			Screen screen = screens.get(s);
			if (screen.isUp()) {
				screen.mouseClicked(e);
			}
		}
		if (transitionTime) {
			transitionTo(newScreen);
		}
	}
	
	public void transitionTo(String screenKey) {
		newScreen = screenKey;
		for (String s: screens.keySet()) {
			Screen screen = screens.get(s);
			if (s == screenKey) {
				screen.setStateOfScreen(true);
			} else {
				if (screen.isUp()) {
					previousScreen = s;
				}
				screen.setStateOfScreen(false);
			}
		}
		if (previousScreen == "difficulty" && screenKey == "sudoku") {
			screens.put(screenKey, new SudokuScreen(p,0,0,p.width,p.height,true));
		}
		transitionTime = false;
	}
	public void arrowInput(int keyCode) {
		for (String s: screens.keySet()) {
			Screen screen = screens.get(s); 
			if (screen.isUp()) {
				screen.arrowInput(keyCode);				
			}
		}
	}

}
	
	