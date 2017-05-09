package memeTeam;
import java.util.*;
import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;
public class Main extends PApplet{
	GUI gui;
	VisualGrid grid;
	ArrayList<Button> buttons;
	String keyDown;
	static Sound sound;
	static ExplosionEvent explosionEvent;
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
		if(Main.explosionEvent != null) {
			Main.explosionEvent.display();
		}
	}
	public void mouseClicked(MouseEvent e) {
		gui.mouseClicked(e);
		
	}
	public void keyPressed(KeyEvent e) {
		if(key == CODED) {
			gui.arrowInput(keyCode);
		}
		if (key >= '0' && key <= '9'){
			gui.keyPressed(e);
		}
		else if(key == 'm') {
			sound.toggleBackground();
		} else if (key == 'e') { //trigger explosion
			Main.explosionEvent = new ExplosionEvent(this);
		} else if (key == 'p') {
			gui.keyPressed(e);
		} else if (key == 'n') {
			if(Main.explosionEvent != null) {
				grid = new VisualGrid(this);
				gui = new GUI(this);
				keyDown = "a";
				Main.sound = new Sound(this);
				titleScreen = new TitleScreen(this,0,0,width,height,true);
			}
		}
	}
	public void keyReleased() {
		keyDown = "a";
	}	
}
