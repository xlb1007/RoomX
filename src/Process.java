import java.util.ArrayList;

public class Process {

	public ArrayList<Clue> clues = new ArrayList<Clue>();  
	public String imageDir;
    public String passcode;
    
    public String get_passcode(){
    	return passcode;
    }
   
    public Process(Level curLevel){
    	//this.clues.addAll(curLevel.clues);
    	imageDir = curLevel.imageDir;
    	passcode = curLevel.passcode;
    }
    
}





	
