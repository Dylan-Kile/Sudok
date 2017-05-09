package memeTeam;
import ddf.minim.*;

public class Sound {	
	Main main;
	boolean muted = false;
	Minim minim;
	AudioPlayer background;
	AudioPlayer correctSection;
	AudioPlayer correctBoard;
	AudioPlayer invalidEntry;
	
	public Sound(Main main) {
		this.main = main;
		minim = new Minim(main);
		background = minim.loadFile("background.wav");
		correctSection = minim.loadFile("chime_up.wav");
		correctBoard = minim.loadFile("fanfare3.wav");
		invalidEntry = minim.loadFile("boing_x.wav");
		background.play();
		background.loop();
	}
	
	void toggleBackground() {
		if(background.isPlaying()) {
			background.pause();
			muted = true;
		} else {
			background.play();
			muted = false;
		}
	}
	
	void correctSection() {
		if(!muted) {
			correctSection.rewind();
			correctSection.play();
		}
	}
	
	void correctBoard() {
		if(!muted && !correctBoard.isPlaying()) {
			correctBoard.rewind();
			correctBoard.play();
		}
	}
	
	void invalidEntry() {
		if(!muted) {
			invalidEntry.rewind();
			invalidEntry.play();
		}
	}
}
