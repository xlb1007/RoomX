public class Clues {
	int content_type;
	String content;
	int found;
    	public Clues(int type, String content)
   	 {
    		this.content = content;
    		this.content_type = type;
    		this.found = 0;
   	 }
    
   	 public int get_type()
   	 {
    		return content_type;
   	 }
    
    	public String get_content()
   	 {
    		return content;
    	}
    	
    	public int get_found()
    	{
    		return found;
    	}
}