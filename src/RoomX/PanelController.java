package RoomX;

import javax.swing.JPanel;

public class PanelController {
	P0 p0;
	P1 p1;
	P2 p2;
	P3 p3;
	JPanel cur;
	Frame frame;
	
	public PanelController(){
		cur = null;
	}
	
	public void addFrame(Frame frame){
		this.frame = frame;
	}
	
	public void addPanel(JPanel jp){
		
		if(jp instanceof P0){
			this.p0 = (P0) jp;
		}else if(jp instanceof P1){
			this.p1 = (P1) jp;
		}else if(jp instanceof P2){
			this.p2 = (P2) jp;
		}else if(jp instanceof P3){
			this.p3 = (P3) jp;
		}
	}
	
	public void switchPanel(int next, int acc){
		
//		if(cur instanceof P0){
//			//this.p0.removeAll();;
//		}else if(cur instanceof P1){
//			this.p1.removeAll();
//		}else if(cur instanceof P2){
//			//this.p2.removeAll();
//		}else if(cur instanceof P3){
//			//this.p3.removeAll();
//		}		
		//frame.removeAll();
		//frame.dispose();

		//if(cur != null) frame.remove(cur);
		switch(next){
		case 0:
			if(p0 == null) p0 = new P0(this);
			frame.setContentPane(p0);
			frame.setVisible(true);
			cur = p0;
			break;
		case 1: 
			p1 = new P1(acc, this);
			frame.setContentPane(p1);
			//frame.setVisible(true);
			cur = p1;
			break;
		case 2: 
			p2 = new P2(this);
			frame.setContentPane(p2);
			//frame.setVisible(true);
			cur = p2;
			break;
		case 3: 
			p3 = new P3(this);
			frame.setContentPane(p3);
			//frame.setVisible(true);
			cur = p3;
			break;
		}
		
		
	}
	

}
