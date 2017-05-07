package memeTeam;

import java.util.ArrayList;

import processing.core.PApplet;

public class ExplodingLine {
	FadingLine self;
	ArrayList<FadingLine> children;
	boolean done = false;
	public ExplodingLine(PApplet parent, float x, float y, float Length, float directionDegrees, int numberOfChildren) {
		self = new FadingLine(parent, x, y, Length, directionDegrees);
		children = new ArrayList<FadingLine>();
		directionDegrees %= 2.0*Main.PI;
		float cos = (float) Math.cos((double) directionDegrees) * Length;
		float sin = (float) Math.sin((double) directionDegrees) * Length;
		
		for(int i = 0; i < numberOfChildren; i++) {
			float direction = (float) (((Math.PI*2.0*(double) i)/ (double) numberOfChildren));
			children.add(new FadingLine(parent, x+cos, y+sin, Length/10, direction));
		}
	}
	
	public void display() {
		if(!self.fullDisplayDone()) {
			self.display();
		}
		if(self.midEventHaspassed()) {
			for(FadingLine l: children) {
				l.display();
			}
		}
		if(children.get(0).fullDisplayDone() && self.fullDisplayDone()) {
			done = true;
		}
	}
	
	public boolean isDone() {
		return done;
	}
}
