package memeTeam;
import java.util.*;
import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;
//All code in qqwing is borrowed from the following via the GNU liscense:
//stephenostermiller/qqwing, QQWing, (2014), GitHub repository, https://github.com/stephenostermiller/qqwing
//Some of the qqwing code has been adapted for this project
public class Main extends PApplet{
	GUI gui;
	VisualGrid grid;
	ArrayList<Button> buttons;
	String keyDown;
	static Sound sound;
	static ExplosionEvent endGameFireworks;
	TitleScreen titleScreen;
	public static void main(String[] args) {
		PApplet.main("memeTeam.Main");
	}
	
	public void settings() {
		size(500,500);
	}	
	
	public void setup() {
		grid = new VisualGrid(this);
		gui = new GUI(this);
		keyDown = "a";
		Main.sound = new Sound(this);
		titleScreen = new TitleScreen(this,0,0,width,height,true);
	}
	
	public void draw() {
		background(255);
		grid.display();
		gui.display();
		if(Main.endGameFireworks != null) {
			Main.endGameFireworks.display();
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		gui.mouseClicked(e);
	}
	
	public void keyPressed(KeyEvent e) {
		if(Main.endGameFireworks == null) {
			if(key == CODED) {
				gui.arrowInput(keyCode);
			}
			if (key >= '0' && key <= '9'){
				gui.keyPressed(e);
			}
			else if(key == 'm') {
				sound.toggleBackground();
			} else if (key == 'p') {
				gui.keyPressed(e);
			} 
		} else {
			if(key == 'n') {
				grid = new VisualGrid(this);
				gui = new GUI(this);
				keyDown = "a";
				titleScreen = new TitleScreen(this,0,0,width,height,true);
				Main.endGameFireworks = null;
			}
		}
	}
	
	public void keyReleased() {
		keyDown = "a";
	}	
}
