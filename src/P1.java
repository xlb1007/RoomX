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


public class P1 extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel controlPanel;
	private JPanel displayPanel;
	private Image backgroundImage;
	private JButton lock,item1,item2,clue,pause,stop,restart;
	Integer rest;
	Timer timer1;
	JLabel timer2;
	public JFrame container;
	Level lvl1;
	
	
	public P1(JFrame container, int lvl)
	{
		//super();
		//new
		this.container = container;
		lvl1 = new Level(lvl);
		rest = lvl1.timer;
		//Read background Image
		try {
			backgroundImage = ImageIO.read(getClass().getClassLoader().getResource(lvl1.imageDir));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Create Top Panel
		controlPanel = new JPanel();
		controlPanel.setBackground(Color.LIGHT_GRAY);
		controlPanel.setBorder(new LineBorder(Color.WHITE));
		controlPanel.setLayout(new BoxLayout(controlPanel,BoxLayout.X_AXIS));
		//controlPanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		controlPanel.setSize(new Dimension(100, 100));
		
		//Add Control icons
		ImageIcon pause_icon = new ImageIcon(getClass().getClassLoader().getResource("images/pause.png"));  
		Image pauseImg = pause_icon.getImage();
		Image newPauseImg = pauseImg.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH);
		pause_icon = new ImageIcon(newPauseImg);
		pause = new JButton(pause_icon);
		pause.setFont(new Font("Tahoma", Font.BOLD, 20));
		//pause.setForeground(Color.WHITE);
		pause.setBackground(Color.DARK_GRAY);
		pause.setPreferredSize(new Dimension(75,75));
		controlPanel.add(Box.createRigidArea(new Dimension(20,0)));
		pause.setOpaque(false);
		pause.setContentAreaFilled(false);
		pause.setBorderPainted(false);
		pause.addActionListener(this);
		controlPanel.add(pause);
		
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
		
		timer2 = new JLabel();
		timer2.setFont(new Font("Tahoma", Font.BOLD, 28));
		//timer.setForeground(Color.DARK_GRAY);
		timer2.setPreferredSize(new Dimension(150, 100));
		//controlPanel.add(Box.createGlue());
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
				
		item1 = new JButton("Item1");
		item1.setBackground(new Color(153, 102, 51));
		item1.setFont(new Font("Tahoma", Font.BOLD, 27));
		item1.setMaximumSize(new Dimension(Integer.MAX_VALUE, item1.getMinimumSize().height));
		item1.setEnabled(false);
		//item1.setPreferredSize(new Dimension(120, 100));
		item1.addActionListener(this);
		displayPanel.add(item1);
		//displayPanel.add(Box.createRigidArea(new Dimension(20,20)));
		
		item2 = new JButton("Item2");
		item2.setBackground(new Color(153, 102, 0));
		item2.setFont(new Font("Tahoma", Font.BOLD, 27));
		item2.setMaximumSize(new Dimension(Integer.MAX_VALUE, item2.getMinimumSize().height));
		item2.setEnabled(false);
		//item2.setPreferredSize(new Dimension(120, 100));
		item2.addActionListener(this);
		displayPanel.add(item2);
		//displayPanel.add(Box.createRigidArea(new Dimension(20,20)));
		
		clue = new JButton("Hint");
		clue.setFont(new Font("Tahoma", Font.BOLD, 27));
		clue.setMaximumSize(new Dimension(Integer.MAX_VALUE, clue.getMinimumSize().height));
		//clue.setAlignmentY(Component.TOP_ALIGNMENT);
		//clue.setPreferredSize(new Dimension(120, 100));
		clue.setBackground(new Color(0, 102, 153));
	    clue.setForeground(Color.BLACK);
		clue.addActionListener(this);
		displayPanel.add(clue);
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
		
		
		//Adding invisible buttons for hidden clues/puzzles
		
		for(Clue a : lvl1.clues){
			JButton obj = new JButton("");
			obj.setVisible(true);
			obj.setOpaque(false);
			obj.setContentAreaFilled(false);
			obj.setBorderPainted(false);
			obj.setBounds(a.hpos,a.vpos,a.hsize,a.vsize);
			obj.addActionListener(new ActionListener()
			{
			    public void actionPerformed(ActionEvent e)
			    {
			    	a.found = true;
			    	JOptionPane.showMessageDialog( null, a.content);
			    }
			});
			add(obj);
		}
		setLayout(new BorderLayout());
			
		add(controlPanel,BorderLayout.NORTH);
		add(displayPanel,BorderLayout.EAST);
		
		setSize(700,700);
		setVisible(true);
   }

   public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    // Draw the background image.
	    g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(),this);
   }
   
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
			JOptionPane.showMessageDialog( null, "Go back?" );
		}
		else if(e.getSource().equals(restart))
		{
			this.resume();
			//JOptionPane.showMessageDialog( null, "You pressed restart button" );
		}
		else if(e.getSource().equals(lock))
	    {
			JDialog dialog = new JDialog();
	    	Container container = dialog.getContentPane();
	    	container.setLayout(new FlowLayout());
					//tf1.addActionListener(this);
			
			JPanel inputPanel = new JPanel();
			JLabel n1 = new JLabel("First");
			JTextField tf1 = new JTextField(1);
			inputPanel.add(n1,BorderLayout.WEST);
			inputPanel.add(tf1,BorderLayout.WEST);
			JLabel n2 = new JLabel("Second");
			JTextField tf2 = new JTextField(1);
			inputPanel.add(n2,BorderLayout.WEST);
			inputPanel.add(tf2,BorderLayout.WEST);
			JLabel n3 = new JLabel("Third");
			JTextField tf3 = new JTextField(1);
			inputPanel.add(n3,BorderLayout.WEST);
			inputPanel.add(tf3,BorderLayout.WEST);
			JLabel n4 = new JLabel("Fourth");
			JTextField tf4 = new JTextField(1);
			inputPanel.add(n4,BorderLayout.WEST);
			inputPanel.add(tf4,BorderLayout.WEST);
			JPanel outputPanel = new JPanel();
			JLabel textfield = new JLabel("textfield");
			outputPanel.add(textfield,BorderLayout.CENTER);
			JPanel buttonPanel = new JPanel();
			JButton NewButton1 = new JButton("Try");
			buttonPanel.add(NewButton1,BorderLayout.WEST);
			JButton NewButton2 = new JButton("Leave");
			buttonPanel.add(NewButton2,BorderLayout.WEST);
			
			NewButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			NewButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dialog.dispose();
				}
			});
			
			
			
			
			
			
			
			
			
			
			
			
	        container.add(inputPanel,
	                BorderLayout.NORTH);
	        container.add(outputPanel,
	                BorderLayout.CENTER);
	        container.add(buttonPanel,
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
    }
	
    void resume(){
        timer1 = new Timer();
        timer1.schedule(new RemindTask1(), 0, 1000);
    }
    
    class RemindTask1 extends TimerTask {
        public void run() {
        	//System.out.println(rest--);
        	rest--;
        	timer2.setText(rest.toString());
        	if(rest <= 0){
        		timer1.cancel();
        		removehere();
    			container.setContentPane(new P2(container));
        		//System.out.println("Timer is done!");
        	}
            //timer1.cancel(); //Terminate the timer thread
        }
    }
    
    void removehere(){
    	container.remove(this);
    }
    
}