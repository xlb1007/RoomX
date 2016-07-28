import java.util.ArrayList;

//import java.util.ArrayList;

public class Level {
	int level;
	int timer;
	ArrayList<Clue> clues;
	String passcode;
	String imageDir;
	
	public Level(int level){
		if(level == 1){
		    this.timer = 60;
		    this.passcode = "4444";
		    this.imageDir = "images/room.jpg";
		    clues = new ArrayList<Clue>();
		    clues.add(new Clue("clue1", 240,420,20,20, "hint1"));
		    clues.add(new Clue("clue2", 415,520,20,20, "hint2"));
		    clues.add(new Clue("clue3", 330,130,20,20, "hint3"));
		}
	}
		
}
