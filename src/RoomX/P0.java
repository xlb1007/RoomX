package RoomX;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class P0 extends JPanel implements ActionListener{
	JButton b1, exit;
	JFrame container;
	JRadioButton Level1, Level2;
	int lvl;

	public P0(JFrame container) {

		this.container = container;
		setLayout(null);
		setVisible(true);
		setBackground(Color.orange);
		this.container.add(this);
	
		JTextArea instructions = new JTextArea();
		instructions.setEditable(false);
		instructions.setText("Room-escape is a adventure game.");
		instructions.setBounds(200,50,120,40);
		instructions.setSize(300,300);
		add(instructions);
	
		//JRadioButton
		Level1 = new JRadioButton("Level-1");
		Level1.setBounds(300,370,120,35);
			
		Level2 = new JRadioButton("Level-2");
		Level2.setBounds(300,470,120,35);
	
		ButtonGroup Group = new ButtonGroup();
		Group.add(Level1);
		Group.add(Level2);
			
		add(Level1);
		add(Level2);
	
		b1 = new JButton("Start");
		b1.setBounds(280,550,120,35);
		b1.setVisible(true);
	 
		b1.setFocusable(false);
		add(b1);
	
		//bug2
		exit = new JButton("Exit");	
		exit.setBounds(480,550,120,35);			
		exit.setVisible(true);			
		
		exit.setFocusable(false);			
		add(exit);
	
		b1.addActionListener(this);
		//bug2
		exit.addActionListener(this);
		Level1.addActionListener(this);
		Level2.addActionListener(this);
		
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
			if(lvl == 0) return;
			container.setContentPane(new P1(container, lvl, this));
			container.remove(this);
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
	}
    
}
