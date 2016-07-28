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
    
//    
//   	public int getType(){
//    	return type;
//   	}
//    
//    public String getContent(){
//    	return content;
//    }
//    	
//    public int getFound(){
//    	return found;
//    }
//    public int getVpos(){
//    	return vpos;
//    }
//    public int getHpos(){
//    	return hpos;
//    } 
//    public String getHint(){
//    	return hint;
//    } 
//   	void setType(int type){
//    	this.type = type;
//   	}
//    
//    void setContent(String content){
//    	this.content = content;
//    }
//    	
//    void setFound(int found){
//    	this.found = found;
//    }
//    void setVpos(int vpos){
//    	this.vpos = vpos;
//    }
//    void setHpos(int hpos){
//    	this.hpos = hpos;
//    }  
}