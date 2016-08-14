package RoomX;
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
			this.level = 1;
		    this.timer = 10;
		    this.passcode = "4444";
		    this.imageDir = "images/catoon child room.jpg";
		    clues = new ArrayList<Clue>();
		    clues.add(new Clue(1, "clue1", 500,165,40,40, "hint1",2));
		    clues.add(new Clue(2, "clue2", 250,125,45,45, "hint2",1));
		    clues.add(new Clue(3, "clue3", 85,70,30,30, "hint3",2));
		    clues.add(new Clue(4,"clue4", 610,390,40,40,"hint4",1));
		    clues.add(new Clue(5,"clue4", 400,390,40,40,"hint4",0));
		    clues.add(new Clue(6,"clue4", 200,390,40,40,"hint4",0));
		}
		if(level == 2){
			this.level = 2;
		    this.timer = 100;
		    this.passcode = "2222";
		    this.imageDir = "images/Level2.jpg";
		    clues = new ArrayList<Clue>();
		    clues.add(new Clue(1, "clue1", 515,30,50,50, "hint1",1));
		    clues.add(new Clue(2, "clue2", 750,130,45,45, "hint2",1));
		    clues.add(new Clue(3, "clue3", 0,290,40,40, "hint3",2));
		    clues.add(new Clue(4,"clue4", 650,390,40,40,"hint4",1));
		    clues.add(new Clue(5,"clue4", 400,390,40,40,"hint4",0));
		    clues.add(new Clue(6,"clue4", 200,390,40,40,"hint4",0));
		}
	}		
}
