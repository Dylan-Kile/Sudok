package memeTeam;

import processing.core.PApplet;

class Timer { 
	  int timeInterval; 
	  int currentTime;
	  PApplet parent;

	  Timer(PApplet parent, int timeInterval) {
	    currentTime = 0; 
	    this.timeInterval = timeInterval;
	    this.parent = parent;	    
	  }

	  public boolean isTime() {
	    boolean isTime = parent.millis() - currentTime>= timeInterval;
	    if (isTime) {
	      currentTime = parent.millis();
	    }
	    return isTime;
	  }
	  public void updateInterval(int interval) {
	    timeInterval = interval;
	  }
	}