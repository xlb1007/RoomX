package RoomX;
public class Clue {
	//int type;
	String content;
	boolean found;
	String hint;
	int vpos;
	int hpos;
	int vsize;
	int hsize;
	int id;
    //public Clue(int type, String content, int found, String hint, int vpos, int hpos, int vsize, int hsize){
    public Clue(int id, String content, int hpos, int vpos, int hsize, int vsize, String hint){
        this.id = id;
    	this.content = content;
    	//this.type = type;
    	//this.found = 0;
    	//this.hint = hint;
    	this.vpos = vpos;
    	this.hpos = hpos;
    	this.vsize = vsize;
    	this.hsize = hsize;
    	this.hint = hint;
    	//size
   	}
    
}