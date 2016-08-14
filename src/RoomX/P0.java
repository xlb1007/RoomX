package RoomX;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class P0 extends JPanel implements ActionListener{
	JButton b1, exit;
	JRadioButton Level1, Level2;
	int lvl;
	PanelController pc;
	//m
	JButton inst;
	private Image backgroundImage;
	
	public P0(PanelController pc) {

		setLayout(null);
		setVisible(true);
		//setBackground(Color.orange);
		this.pc = pc;

		try {
			backgroundImage = ImageIO.read(getClass().getClassLoader().getResource("images/Img1.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		//JRadioButton
		Level1 = new JRadioButton("Level-1");
		Level1.setBounds(550,370,120,35);
		Level1.setVisible(true);	
		Level1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		Level1.setBackground(new Color(255,222,173));
        Level1.setOpaque(true);
        Level1.setBorderPainted(false);
				
		Level2 = new JRadioButton("Level-2");
		Level2.setBounds(550,470,120,35);
		Level2.setVisible(true);	
		Level2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		Level2.setBackground(new Color(255,222,173));
        Level2.setOpaque(true);
        Level2.setBorderPainted(false);
	
		ButtonGroup Group = new ButtonGroup();
		Group.add(Level1);
		Group.add(Level2);
			
		add(Level1);
		add(Level2);
	
		b1 = new JButton("Start");
		b1.setBounds(420,550,120,35);
		b1.setVisible(true);
		b1.setOpaque(true);
		b1.setBorderPainted(false);
		b1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		b1.setBackground(new Color(255,222,173));
		add(b1);
	
		inst = new JButton("Instructions");
		inst.setBounds(800,50,150,35);
		inst.setVisible(true);
		inst.setOpaque(true);
		inst.setBorderPainted(false);
		inst.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		inst.setBackground(new Color(255,222,173));
		add(inst);
		
		//bug2
        exit = new JButton("Exit");	
        exit.setBounds(680,550,120,35);			
        exit.setVisible(true);	
		exit.setOpaque(true);
		//b1.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		exit.setBackground(new Color(255,222,173));
			
        //exit.setFocusable(false);
        add(exit);
	
		b1.addActionListener(this);
		//bug2
		exit.addActionListener(this);
		Level1.addActionListener(this);
		Level2.addActionListener(this);
		inst.addActionListener(this);

		setVisible(true);
	}
	
	
//	ActionListener actionListener = new ActionListener() {
//	    @Override
//	    public void actionPerformed(ActionEvent e) {
//	        boolean enable = check1.isSelected() && check3.isSelected();
//	        buttonToBeEnabled.setEnabled(enable);
//	    }
//	};
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			//new
			if(lvl == 0){
				JOptionPane.showMessageDialog( null, "Please select the level" );
				return;
			};
			pc.switchPanel(1, lvl);
		}
		if (e.getSource() == exit) {			
			System.exit(0);			
		}
		if (e.getSource() == Level1) {
			//new
			lvl = 1;	
		}
		if (e.getSource() == Level2) {
			//new
			lvl = 2;	
		}
		if (e.getSource() == inst) {			
			
			JDialog dialog = new JDialog();
			dialog.getContentPane().setBackground(new Color(255, 255, 204));
			dialog.setBounds(370, 0, 500, 750);
	    	Container window = dialog.getContentPane();
	        window.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
			dialog.setLocationRelativeTo(this);
			
	        window.add(Box.createVerticalGlue());
			JPanel instmsg = new JPanel();
			//window.setLocation(null);
				
			
			JTextArea instructions = new JTextArea();
			instructions.setEditable(false);
			//instructions.setHorizontalAlignment(JTextField.LEFT);
			//instructions.setVerticalAlignment(JTextField.TOP);
			instructions.setText("Room-escape is a adventure game.");
			instructions.setBounds(450,50,120,40);
			instructions.setOpaque(false);
			instructions.setSize(300,300);
			instmsg.add(instructions);
			
			instmsg.setBackground(new Color(255, 255, 204));
			JButton Continue = new JButton("Continue");
			//Continue.setForeground(new Color(255, 255, 255));
			Continue.setBackground(new Color(153, 0, 0));
			Continue.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			Continue.setVisible(true);
			Continue.setFocusPainted(false);
			//Continue.setPreferredSize(new Dimension(120,50));
			Continue.setBounds(0,700,120,50);	
			instmsg.add(Continue);
			
			Continue.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					dialog.removeAll();
					dialog.setVisible(false);
								
				} 
			} );
			window.add(instmsg);
	        dialog.setUndecorated(true);	   
	    	//dialog.setSize(500, 666);
	    	
	    	dialog.setVisible(true);

		}
		
		
		
	}
	
	public void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    // Draw the background image.
		    g.drawImage(backgroundImage, 0, 0,this.getWidth(),this.getHeight(), this);
	}
    
}
