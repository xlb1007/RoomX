import java.util.*;

public class timer {


    Timer timer1;
    int reminder;
    
    public timer(int reminder){
        this.reminder = reminder;
	}
    
    void pause(){
    	timer1.cancel();
    }
    void resume(){
        timer1 = new Timer();
        timer1.schedule(new RemindTask(), 0, 1000);
    }

    class RemindTask extends TimerTask {
        public void run() {
        	System.out.println("timer working");
        	reminder --;
        	if(reminder <= 0){
        		timer1.cancel();
        		System.out.println("Time's up!");
        	}
            //timer1.cancel(); //Terminate the timer thread
        }
    }

    public static void main(String args[]) {
        timer timer1 = new timer(5);
        timer1.resume();
        System.out.format("Task scheduled.%n");
    }
}    

