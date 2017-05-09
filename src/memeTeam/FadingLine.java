package memeTeam;
import processing.core.*;

public class FadingLine {
	private Point start;
	private Point end;
	private float displayLength;
	private float displayFrame = 0;
	private float displayHalfLength;
	private int c;
	private float cos;
	private float sin;
	private float speed;
	private PApplet parent;
	
	public FadingLine(PApplet parent, float x, float y, float Length, float directionDegrees) {
		this.parent = parent;
		directionDegrees %= 2.0*Main.PI;
		this.cos = (float) Math.cos((double) directionDegrees);
		this.sin = (float) Math.sin((double) directionDegrees);
		this.start = new Point(x,y);
		this.end = new Point(x,y);
		parent.colorMode(Main.HSB, 360, 100, 100);
		int hue = (int) parent.random(0, 360);
		this.c = this.parent.color(hue, 100, 75);
		this.displayHalfLength = Length;
		this.displayLength = Length *2;
		this.speed = (float) 2.5;//pixels per frame
	}
	
	public void display() {
		if(displayFrame >= displayLength) {
			displayFrame = 0;
			return;
		} else if (displayFrame < displayHalfLength) {
			this.end.setX(this.end.getX() + cos*speed);
			this.end.setY(this.end.getY() + sin*speed);
		} else if (displayFrame >= displayHalfLength) {
			this.start.setX(this.start.getX() + cos*speed);
			this.start.setY(this.start.getY() + sin*speed);
		}

		parent.colorMode(Main.HSB, 360, 100, 100);
		parent.stroke(c);
		parent.strokeWeight(3);
		parent.line(start.getX(), start.getY(), end.getX(), end.getY());	
		parent.colorMode(Main.RGB, 255, 255, 255);
		parent.stroke(0);
		parent.noFill();
		displayFrame += speed;
	}
	
	public boolean midEventHaspassed() {
		return displayFrame >= displayHalfLength;
	}
	
	public boolean fullDisplayDone() {
		return displayFrame >= displayLength;
	}
}
