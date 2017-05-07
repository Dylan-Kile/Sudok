package memeTeam;

import java.util.ArrayList;

import processing.core.PApplet;

public class Explosion {
	ArrayList<ExplodingLine> lines;
	int numberOfLines = 12;
	static float centerLineLength = 50;
	float x;
	float y;
	PApplet parent;
	
	public Explosion(PApplet parent) {
		this.lines = new ArrayList<ExplodingLine>();
		this.parent = parent;
		this.x = parent.random(Explosion.centerLineLength, parent.width - Explosion.centerLineLength);
		this.y = parent.random(Explosion.centerLineLength, parent.height - Explosion.centerLineLength);
		populateLines();
	}
	
	private void populateLines() {
		for(int i = 0; i < numberOfLines; i++) {
			float direction = (float) (((Math.PI*2.0*(double) i)/ (double) numberOfLines));
			ExplodingLine line = new ExplodingLine(parent, x, y, Explosion.centerLineLength, direction, 6);
			lines.add(line);
		}
	}
	
	public void display() {
		if(lines.get(0).isDone() && lines.get(0).children.get(0).fullDisplayDone()) {
			return;
		}
		for(ExplodingLine e : lines) {
			e.display();
		}
	}
	
	public boolean isDone() {
		return lines.get(0).isDone() && lines.get(0).children.get(0).fullDisplayDone();
	}
}
