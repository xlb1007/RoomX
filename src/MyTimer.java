import java.util.*;

public class MyTimer{

    Timer timer1;
    int rest;
    
    public MyTimer(int rest){
        this.rest = rest;
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
    
    // testing
//    public static void main(String args[]){
//    	MyTimer myTimer = new MyTimer(10);
//    	myTimer.resume();
//    }
}    

