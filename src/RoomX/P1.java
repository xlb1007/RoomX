package RoomX;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

//new
import javax.swing.text.AttributeSet;	
import javax.swing.text.BadLocationException;			
import javax.swing.text.PlainDocument;




public class P1 extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel controlPanel;
	private JPanel displayPanel;
	private JPanel wallPanel;
	private JButton lock,clue,pause,stop,restart;
	ArrayList<JButton> items;
	ArrayList<JButton> otherJButtons;
	Integer rest;
	Timer timer1;
	JLabel timer2;
	public JFrame container;
	Level lvl1;
	JPanel P0;
	boolean isRunning;
	
	public P1(JFrame container, int lvl, JPanel P0)
	{

		this.P0 = P0;
		this.container = container;
		lvl1 = new Level(lvl);
		rest = lvl1.timer;
	    items = new ArrayList<JButton>();
	    otherJButtons = new ArrayList<JButton>();
		
		wallPanel = new imagePanel(lvl1);

		
		//Create Top Panel
		controlPanel = new JPanel();
		controlPanel.setBackground(Color.LIGHT_GRAY);
		controlPanel.setBorder(new LineBorder(Color.WHITE));
		controlPanel.setLayout(new BoxLayout(controlPanel,BoxLayout.X_AXIS));
		controlPanel.setSize(new Dimension(100, 100));
		
		//Add Control icons
		ImageIcon pause_icon = new ImageIcon(getClass().getClassLoader().getResource("images/pause.png"));  
		Image pauseImg = pause_icon.getImage();
		Image newPauseImg = pauseImg.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH);
		pause_icon = new ImageIcon(newPauseImg);
		pause = new JButton(pause_icon);
		pause.setFont(new Font("Tahoma", Font.BOLD, 20));
		pause.setBackground(Color.DARK_GRAY);
		pause.setPreferredSize(new Dimension(75,75));
		controlPanel.add(Box.createRigidArea(new Dimension(20,0)));
		pause.setOpaque(false);
		pause.setContentAreaFilled(false);
		pause.setBorderPainted(false);
		pause.addActionListener(this);
		controlPanel.add(pause);
		otherJButtons.add(pause);

		
		ImageIcon stop_icon = new ImageIcon(getClass().getClassLoader().getResource("images/stop.png"));  
		Image stopImg = stop_icon.getImage();
		Image newStopImg = stopImg.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH);
		stop_icon = new ImageIcon(newStopImg);
		stop = new JButton(stop_icon);
		stop.setFont(new Font("Tahoma", Font.BOLD, 20));
		stop.setForeground(Color.WHITE);
		stop.setBackground(Color.DARK_GRAY);
		stop.setPreferredSize(new Dimension(75, 75));
		controlPanel.add(Box.createRigidArea(new Dimension(20,0)));
		stop.setOpaque(false);
		stop.setContentAreaFilled(false);
		stop.setBorderPainted(false);
		stop.addActionListener(this);
		controlPanel.add(stop);
		
		otherJButtons.add(stop);

		
		ImageIcon restart_icon = new ImageIcon(getClass().getClassLoader().getResource("images/play.png"));  
		Image restartImg = restart_icon.getImage();
		Image newRestartImg = restartImg.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH);
		restart_icon = new ImageIcon(newRestartImg);
		restart = new JButton(restart_icon);
		restart.setFont(new Font("Tahoma", Font.BOLD, 20));
		restart.setForeground(Color.WHITE);
		restart.setBackground(Color.DARK_GRAY);
		restart.setPreferredSize(new Dimension(75, 75));
		controlPanel.add(Box.createRigidArea(new Dimension(20,0)));
		restart.setOpaque(false);
		restart.setContentAreaFilled(false);
		restart.setBorderPainted(false);
		restart.addActionListener(this);
		controlPanel.add(restart);
		
		otherJButtons.add(restart);
		
		timer2 = new JLabel();
		timer2.setFont(new Font("Tahoma", Font.BOLD, 28));
		//timer.setForeground(Color.DARK_GRAY);
		timer2.setPreferredSize(new Dimension(150, 100));
		controlPanel.add(Box.createGlue());
		controlPanel.add(timer2);
		this.resume();

		//Create right panel
		displayPanel = new JPanel();
		displayPanel.setBackground(Color.LIGHT_GRAY);
		displayPanel.setForeground(new Color(0, 0, 0));
		displayPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		//displayPanel.setLayout(new BoxLayout(outputPanel,BoxLayout.Y_AXIS));
		displayPanel.setLayout(new GridLayout(6,1,5,5));
		displayPanel.setPreferredSize(new Dimension(150, 600));
				
		
		
		for(Clue a : lvl1.clues){
		 
			JButton item = new JButton("?");
			item.setBackground(new Color(153, 102, 51));
			item.setFont(new Font("Tahoma", Font.BOLD, 27));
			item.setMaximumSize(new Dimension(Integer.MAX_VALUE, item.getMinimumSize().height));
			item.setEnabled(false);
			//item1.setPreferredSize(new Dimension(120, 100));
			item.addActionListener(new ActionListener(){			
				public void actionPerformed(ActionEvent e){			
					JOptionPane.showMessageDialog( null, a.content,"Puzzle "+String.valueOf(a.id),JOptionPane.PLAIN_MESSAGE);			
				}        			
			});
			items.add(item);
			displayPanel.add(item);
			
			
			//Adding invisible buttons for hidden clues/puzzles
			JButton obj = new JButton("");
			otherJButtons.add(obj);
			/*obj.setVisible(true);
			obj.setOpaque(false);
			obj.setContentAreaFilled(false);
			obj.setBorderPainted(false);*/
			obj.setBounds(a.hpos,a.vpos,a.hsize,a.vsize);
			obj.addActionListener(new ActionListener()
			{
			    public void actionPerformed(ActionEvent e)
			    {
			    	a.found = true;
					JDialog dialog = new JDialog();
			    	Container window = dialog.getContentPane();
			    	JPanel dialogPanel = new JPanel();
			    	JButton save = new JButton("SAVE");
			    	JLabel puzzle = new JLabel();
			    	puzzle.setText(a.content);
			    	dialogPanel.add(puzzle);
			    	dialogPanel.add(save);	    	
			    	dialog.setUndecorated(true);
			    	window.add(dialogPanel);
			    	dialog.setVisible(true);
			    	dialog.setSize(200, 200);
                    
			    	save.addActionListener(new ActionListener() { 
						public void actionPerformed(ActionEvent e) { 
							 if(a.id == 1)
							   {
								   if(!items.get(0).isEnabled())
								   {
									   items.get(0).setEnabled(true);
									   items.get(0).setBackground(Color.CYAN);
									   items.get(0).setText("Clue 1");
								   }
							   }
							   else if(a.id == 2)
							   {
								   if(!items.get(1).isEnabled())
								   {
									   items.get(1).setEnabled(true);
									   items.get(1).setBackground(Color.CYAN);
									   items.get(1).setText("Clue 2");
								   }
							   }
							   else if(a.id == 3)
							   {
								   if(!items.get(2).isEnabled())
								   {
									   items.get(2).setEnabled(true);
									   items.get(2).setBackground(Color.CYAN);
									   items.get(2).setText("Clue 3");
								   }
							   }
							 dialog.dispose();
						  } 
					} );
			    }
			});
			wallPanel.add(obj);
		}
		

		clue = new JButton("Hint");
		clue.setFont(new Font("Tahoma", Font.BOLD, 27));
		clue.setMaximumSize(new Dimension(Integer.MAX_VALUE, clue.getMinimumSize().height));
		//clue.setAlignmentY(Component.TOP_ALIGNMENT);
		//clue.setPreferredSize(new Dimension(120, 100));
		clue.setBackground(new Color(0, 102, 153));
	    clue.setForeground(Color.BLACK);
		clue.addActionListener(this);
		displayPanel.add(clue);
		
		otherJButtons.add(clue);
		//displayPanel.add(Box.createRigidArea(new Dimension(20,20)));
		
		//displayPanel.add(Box.createVerticalGlue());
		lock = new JButton("Lock");
		lock.setFont(new Font("Tahoma", Font.BOLD, 27));
		lock.setMaximumSize(new Dimension(Integer.MAX_VALUE, lock.getMinimumSize().height));
		//lock.setPreferredSize(new Dimension(120, 100));
		lock.setForeground(Color.BLACK);
		lock.setBackground(new Color(255, 102, 0));		
		lock.setSize(140,550);
		lock.addActionListener(this);
		displayPanel.add(lock);	
		
		otherJButtons.add(lock);
		
		wallPanel.setLayout(new BorderLayout());
		
		setLayout(new BorderLayout());
		add(wallPanel,BorderLayout.CENTER);
		add(controlPanel,BorderLayout.NORTH);
		add(displayPanel,BorderLayout.EAST);
		
		setSize(1000,666);
		setVisible(true);
   }

   /*public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    // Draw the background image.
	    g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(),this);
   }*/
   
   public void actionPerformed(ActionEvent e) 
   {		
	    if(e.getSource().equals(pause))
	    {
	   	 	this.pause();
			//JOptionPane.showMessageDialog( null, "You pressed pause button" );
		}
		else if(e.getSource().equals(stop))
		{   
			this.pause();
			//JOptionPane.showMessageDialog( null, "Go back?" );
			
			JDialog dialog = new JDialog();
	    	Container window = dialog.getContentPane();
	    	window.setLayout(new FlowLayout());
			JPanel stopmsg = new JPanel();
			stopmsg.setSize(100,100);
			window.add(stopmsg);
			JButton Continue = new JButton("Continue");
			Continue.setVisible(true);
			stopmsg.add(Continue);
			//bug2
            dialog.setUndecorated(true);	

			window.add(stopmsg);
	        
	    	dialog.setSize(400, 300);
	    	//pack();
	        dialog.setVisible(true);
			//JOptionPane.showMessageDialog( null, "Go back?" );
	        Continue.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					dialog.removeAll();
					dialog.setVisible(false);
					resume();
					
				} 
			} );
			
			JButton Quit = new JButton("Quit");
			Quit.setVisible(true);
			stopmsg.add(Quit);
			Quit.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					
					container.setContentPane(P0);
					dialog.removeAll();
					dialog.setVisible(false);
				}
			} );
			
		}
		else if(e.getSource().equals(restart))
		{
			this.resume();
			//JOptionPane.showMessageDialog( null, "You pressed restart button" );
		}
		else if(e.getSource().equals(lock))
	    {
			JDialog dialog = new JDialog();
	    	Container container2 = dialog.getContentPane();
	    	container2.setLayout(new BorderLayout());
			//tf1.addActionListener(this);
            dialog.setUndecorated(true);	

            JPanel inputPanel = new JPanel();
			inputPanel.setLayout(new FlowLayout());
			JLabel n1 = new JLabel("First");
			JTextField tf1 = new JTextField(1);
			inputPanel.add(n1);
			inputPanel.add(tf1);
			tf1.setDocument(new JTextFieldLimit(1));
			
			JLabel n2 = new JLabel("Second");
			JTextField tf2 = new JTextField(1);
			inputPanel.add(n2);
			inputPanel.add(tf2);
			tf2.setDocument(new JTextFieldLimit(1));
			
			JLabel n3 = new JLabel("Third");
			JTextField tf3 = new JTextField(1);
			inputPanel.add(n3);
			inputPanel.add(tf3);
			tf3.setDocument(new JTextFieldLimit(1));
			
			JLabel n4 = new JLabel("Fourth");
			JTextField tf4 = new JTextField(1);
			inputPanel.add(n4);
			inputPanel.add(tf4);
			tf4.setDocument(new JTextFieldLimit(1));
			
			JPanel outputPanel = new JPanel();
			JLabel textfield = new JLabel("Enter Lock Code");
			textfield.setVisible(false);
			outputPanel.add(textfield);
			
			
			JPanel buttonPanel = new JPanel();
			JButton NewButton1 = new JButton("Try");
			buttonPanel.add(NewButton1,BorderLayout.WEST);
			JButton NewButton2 = new JButton("Leave");
			buttonPanel.add(NewButton2,BorderLayout.WEST);
			
			NewButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String temp_res = tf1.getText() + tf2.getText() + tf3.getText() + tf4.getText();
					if(temp_res.equals(lvl1.passcode)){
		        		timer1.cancel();
		        	    dialog.removeAll();	
		        	    dialog.setVisible(false);
		        		removehere();
		    			container.setContentPane(new P2(container, P0));
					}else{
						if(!temp_res.isEmpty())
						{
							textfield.setVisible(true);
							textfield.setText("Wrong answer..Try again!");
						}
						else{
							textfield.setVisible(true);
							textfield.setText("Please enter 4 digit lock code!");
						}
						//JOptionPane.showMessageDialog( null, "Wrong answer!");

					}
				}
			});
			NewButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dialog.dispose();
				}
			});
			
	        container2.add(inputPanel,
	                BorderLayout.NORTH);
	        container2.add(outputPanel,
	                BorderLayout.CENTER);
	        container2.add(buttonPanel,
	                BorderLayout.SOUTH);
	        
	    	dialog.setSize(400, 300);
	    	//pack();
	        dialog.setVisible(true);
		}
		else if(e.getSource().equals(clue))
	    {
			ArrayList<Clue> clues = lvl1.clues;
			String hint = "You have found all clues!";
			for(Clue a: clues){
				if(a.found == true) continue;
				else{
					hint = a.hint;
			    	//JOptionPane.showMessageDialog( null, hint);
			    	break;
				}
			}
			JOptionPane.showMessageDialog( null, hint);
			
	    }
   }
   
	void pause(){
    	timer1.cancel();
    	isRunning = false;
    	disablebuttons(restart);
    }
	
    void resume(){
    	if(isRunning == true) return;
        timer1 = new Timer();
        timer1.schedule(new RemindTask1(), 0, 1000);
        isRunning = true;
        enablebuttons();
    }
    
    class RemindTask1 extends TimerTask {
    	
        public void run() {
        	//System.out.println(rest--);
        	rest--;
        	timer2.setText(rest.toString());
        	if(rest <= 0){
        		timer1.cancel();
        		removehere();
    			container.setContentPane(new P3(container, P0));
        		//System.out.println("Timer is done!");
        	}
            //timer1.cancel(); //Terminate the timer thread
        }
    }
    
    void removehere(){
    	this.removeAll();
    	container.remove(this);
    }
    
    void disablebuttons(JButton st){
    	for(JButton a: otherJButtons){
    		if(a == st) continue;
    		else a.setEnabled(false);
    	}
    	for(JButton a: items){
    		a.setEnabled(false);
    	}
    }
    
    void enablebuttons(){
    	for(JButton a: otherJButtons){
    			a.setEnabled(true);
    	}
    	for(JButton a: items){
    			if(a.getText() != "?") a.setEnabled(true);
    	}    	
    }
    
    
    
    
}

class imagePanel extends JPanel{
	private Image backgroundImage;
    public imagePanel(Level lvl1) {
    	//Read background Image
		try {
			backgroundImage = ImageIO.read(getClass().getClassLoader().getResource(lvl1.imageDir));
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }

	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    // Draw the background image.
	    g.drawImage(backgroundImage, 0, 0,this.getWidth(),this.getHeight(), this);
	  }
}


class JTextFieldLimit extends PlainDocument {
	  private int limit;
	  JTextFieldLimit(int limit) {
	    super();
	    this.limit = limit;
	  }

	  JTextFieldLimit(int limit, boolean upper) {
	    super();
	    this.limit = limit;
	  }

	  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	    if (str == null)
	      return;

	    if ((getLength() + str.length()) <= limit) {
	      super.insertString(offset, str, attr);
	    }
	  }
}
