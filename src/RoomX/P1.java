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

public class P1 extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel controlPanel;
	private JPanel displayPanel;
	private Image backgroundImage;
	private JButton lock,item1,item2,item3,clue,pause,stop,restart,obj1,obj2,obj3;
	private JLabel timer;
	
	public P1()
	{
		//Read background Image
		try {
			backgroundImage = ImageIO.read(getClass().getClassLoader().getResource("images/room.jpg"));
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
		
		timer = new JLabel("06:06:25");
		timer.setFont(new Font("Tahoma", Font.BOLD, 28));
		timer.setForeground(Color.DARK_GRAY);
		timer.setPreferredSize(new Dimension(150, 100));
		controlPanel.add(Box.createGlue());
		controlPanel.add(timer);

		//Create right panel
		displayPanel = new JPanel();
		displayPanel.setBackground(Color.LIGHT_GRAY);
		displayPanel.setForeground(new Color(0, 0, 0));
		displayPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		//displayPanel.setLayout(new BoxLayout(outputPanel,BoxLayout.Y_AXIS));
		displayPanel.setLayout(new GridLayout(6,1,5,5));
		displayPanel.setPreferredSize(new Dimension(150, 600));
				
		item1 = new JButton("Item1");
		item1.setBackground(Color.GRAY);
		item1.setFont(new Font("Tahoma", Font.BOLD, 27));
		item1.setMaximumSize(new Dimension(Integer.MAX_VALUE, item1.getMinimumSize().height));
		item1.setEnabled(false);
		//item1.setPreferredSize(new Dimension(120, 100));
		item1.addActionListener(this);
		displayPanel.add(item1);
		//displayPanel.add(Box.createRigidArea(new Dimension(20,20)));
		
		item2 = new JButton("Item2");
		item2.setBackground(Color.GRAY);
		item2.setFont(new Font("Tahoma", Font.BOLD, 27));
		item2.setMaximumSize(new Dimension(Integer.MAX_VALUE, item2.getMinimumSize().height));
		item2.setEnabled(false);
		//item2.setPreferredSize(new Dimension(120, 100));
		item2.addActionListener(this);
		displayPanel.add(item2);
		//displayPanel.add(Box.createRigidArea(new Dimension(20,20)));
		
		item3 = new JButton("Item3");
		item3.setBackground(Color.GRAY);
		item3.setFont(new Font("Tahoma", Font.BOLD, 27));
		item3.setMaximumSize(new Dimension(Integer.MAX_VALUE, item2.getMinimumSize().height));
		item3.setEnabled(false);
		//item2.setPreferredSize(new Dimension(120, 100));
		item3.addActionListener(this);
		displayPanel.add(item3);
		//displayPanel.add(Box.createRigidArea(new Dimension(20,20)));
		
		clue = new JButton("Hint");
		clue.setFont(new Font("Tahoma", Font.BOLD, 27));
		clue.setMaximumSize(new Dimension(Integer.MAX_VALUE, clue.getMinimumSize().height));
		//clue.setAlignmentY(Component.TOP_ALIGNMENT);
		//clue.setPreferredSize(new Dimension(120, 100));
		clue.setBackground(new Color(0, 102, 153));
		clue.setForeground(Color.WHITE);
		clue.addActionListener(this);
		displayPanel.add(clue);
		//displayPanel.add(Box.createRigidArea(new Dimension(20,20)));
		
		//displayPanel.add(Box.createVerticalGlue());
		lock = new JButton("Lock");
		lock.setFont(new Font("Tahoma", Font.BOLD, 27));
		lock.setMaximumSize(new Dimension(Integer.MAX_VALUE, lock.getMinimumSize().height));
		//lock.setPreferredSize(new Dimension(120, 100));
		lock.setForeground(Color.WHITE);
		lock.setBackground(new Color(255, 102, 0));
		lock.addActionListener(this);
		displayPanel.add(lock);
		
		//Adding invisible buttons for hidden clues/puzzles
		obj1 = new JButton("");
		obj1.setVisible(true);
		obj1.setOpaque(false);
		obj1.setContentAreaFilled(false);
		obj1.setBorderPainted(false);
		obj1.setBounds(240,420,15,20);
		obj1.addActionListener(this);
		add(obj1);
		
		obj2 = new JButton("");
		obj2.setVisible(true);
		obj2.setOpaque(false);
		obj2.setContentAreaFilled(false);
		obj2.setBorderPainted(false);
		obj2.setBounds(415,520,20,20);
		obj2.addActionListener(this);
		add(obj2);
		
		obj3 = new JButton("");
		obj3.setVisible(true);
		obj3.setOpaque(false);
		obj3.setContentAreaFilled(false);
		obj3.setBorderPainted(false);
		obj3.setBounds(330,130,30,30);
		obj3.addActionListener(this);
		add(obj3);

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
			JOptionPane.showMessageDialog( null, "You pressed pause button" );
		}
		else if(e.getSource().equals(stop))
		{
			JOptionPane.showMessageDialog( null, "You pressed stop button" );
		}
		else if(e.getSource().equals(restart))
		{
			JOptionPane.showMessageDialog( null, "You pressed restart button" );
		}
		else if(e.getSource().equals(lock))
	    {
			JOptionPane.showMessageDialog( null, "You pressed lock button" );
		}
		else if(e.getSource().equals(obj1))
		{
			Object[] options = {"SAVE"};
			int n = JOptionPane.showOptionDialog(null,
			                   "2+3+4*8 = ?","Puzzle1",
			                   JOptionPane.PLAIN_MESSAGE,
			                   JOptionPane.QUESTION_MESSAGE,
			                   null,
			                   options,
			                   options[0]);
		   if(n == 0)
		   {
			   if(!item1.isEnabled())
			   {
				   item1.setEnabled(true);
				   item1.setBackground(Color.CYAN);
			   }
		   }
		   
		   //JOptionPane.showMessageDialog( null, "You pressed obj-1 button" );
		}
		else if(e.getSource().equals(obj2))
		{
			Object[] options = {"SAVE"};
			int n = JOptionPane.showOptionDialog(null,
			                   "8*8*9 = ?","Puzzle2",
			                   JOptionPane.PLAIN_MESSAGE,
			                   JOptionPane.QUESTION_MESSAGE,
			                   null,
			                   options,
			                   options[0]);
		    if(n == 0)
		    {
		       if(!item2.isEnabled())
			   {
		    	   item2.setEnabled(true);
		    	   item2.setBackground(Color.CYAN);
			   }
		    }
			//JOptionPane.showMessageDialog( null, "You pressed obj-2 button" );
		}
		else if(e.getSource().equals(obj3))
		{
			Object[] options = {"SAVE"};
			int n = JOptionPane.showOptionDialog(null,
			                   "8*6*9+1-3+4 = ?","Puzzle3",
			                   JOptionPane.PLAIN_MESSAGE,
			                   JOptionPane.QUESTION_MESSAGE,
			                   null,
			                   options,
			                   options[0]);
		    if(n == 0)
		    {
		       if(!item3.isEnabled())
			   {
		    	   item3.setEnabled(true);
		    	   item3.setBackground(Color.CYAN);
			   }
		    }
			//JOptionPane.showMessageDialog( null, "You pressed obj-3 button" );
		}
   }
}
