import java.util.*;
import java.util.Timer;

import javax.swing.*;

public class Mainstream {
	Process process;
	JFrame window;
	ArrayList<Level> levels;
	Timer timer1;
    int rest;
    
	public Mainstream(ArrayList<Level> levels){
		this.levels = levels;  // initialize levels 
		window = new JFrame(); // create pane1, 2, 4 and 5
	}
    void pause(){
    	timer1.cancel();
    }
    void resume(){
        timer1 = new Timer();
        timer1.schedule(new RemindTask1(), 0, 1000);
    }
    class RemindTask1 extends TimerTask {
        public void run() {
        	System.out.println(rest--);
        	if(rest <= 0){
        		timer1.cancel();
        		System.out.println("Timer is done!");
        	}
            //timer1.cancel(); //Terminate the timer thread
        }
    }
	void initiGame(int i){
		process = new Process(levels.get(i));
		this.rest = levels.get(i).timer;
		// update pane3
	}

	void stopGame(int flag){
		// TODO pause current timer
		// CHECK may not need to clear current process and pane4
		// TODO if flag = 0 make pane4 visible, else make pane5 visible
	}
	
	public static void main(String[] args) {
		// TODO 1. Create JFrame with pane1, 2, 4 and 5 with the information of levels
		// TODO 2. When created pane1 should be visible
		ArrayList<Level> levels = null;
		Mainstream mainstream = new Mainstream(levels);
		// TODO 3. When user select level and confirm, function initiGame 
        //			will be called, Pane3 will be initialized with the given level class information
		// TODO 4. Also a Process object will be created
		// TODO 5. When user start the game, timer starts to work
		
		

	}
	
	

}

