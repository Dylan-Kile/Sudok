package memeTeam;
import processing.core.*;
import java.util.*;

public class ExplosionEvent {
	Queue<Explosion> explosions;
	Timer newFireWork;
	PApplet parent;
	public ExplosionEvent(PApplet parent) {
		explosions = new ArrayDeque<Explosion>();
		newFireWork = new Timer(parent, 250);
		this.parent = parent;
		explosions.add(new Explosion(parent));
	}
	
	public void display() {
		String text = "CONGRATULATIONS!";
		parent.textSize(parent.displayWidth/(text.length()*4));
		float x = (parent.width-parent.textWidth(text))/2;
		float y = (parent.textAscent()+parent.textDescent());
		parent.fill(0);
		parent.text(text, x, y);
		for(Explosion e: explosions) {
			e.display();
		}
		for(Explosion e: explosions) {
			if(e.isDone()) {
				explosions.remove();
				break;
			}
		}
		if(newFireWork.isTime()) {
			explosions.add(new Explosion(parent));
		}
	}
}
