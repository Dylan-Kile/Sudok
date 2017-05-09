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
		String text = "CONGRATULATIONS!\nPress \"n\" to start a new game";
		
		Map<Integer,String> lines = new HashMap<Integer,String>();
		float spacing = 10 + (parent.textAscent()+parent.textDescent());
		lines.put(0, "CONGRATULATIONS!");
		lines.put(1, "Press \"n\" to start a new game"); 
		parent.fill(parent.color(255,0,255));
		parent.textSize(30);
		float x = (parent.width-parent.textWidth(text))/2;
		for (int i = 0; i < lines.size(); i++) {
			float y = parent.height/2 + (parent.textAscent()+ parent.textDescent()) + spacing*i;
			parent.text(lines.get(i),x,y);
		}
		
		
		
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
