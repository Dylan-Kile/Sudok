package memeTeam;
import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;
public class Main extends PApplet{
	GUI gui;
	VisualGrid grid;
	String keyDown;
	static Sound sound;
	TitleScreen titleScreen;
	static boolean duringGame;
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
		duringGame = false;
	}
	public void draw() {
		background(255);
		grid.display();		
		gui.display();	
	}
	
	public void mouseClicked(MouseEvent e) {
		gui.mouseClicked(e);
		
	}
	public void keyPressed(KeyEvent e) {

		if (key >= '0' && key <= '9'){
			gui.keyPressed(e);
		}
		else if(key == 'm') {
			sound.toggleBackground();
		} else if (key == 'p' && duringGame) {
			gui.transitionTo("pause");
		}
	}
	
	public void keyReleased() {
		keyDown = "a";
	}
}
