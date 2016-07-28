import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class P0 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton b1;
	JFrame container;
	JRadioButton Level1, Level2;
	JPanel P0;
	//new
	int lvl;
	//Constructor
	public P0() {
		super("P0  Demo");
		container = this;
		container.setSize(700,700);
		container.setResizable(false);
		container.setBackground(Color.orange);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		P0 = new JPanel();
		P0.setLayout(null);
		P0.setVisible(true);
		P0.setBackground(Color.orange);
		container.add(P0);
		
		JTextArea instructions = new JTextArea();
		instructions.setEditable(false);
		//instructions.setHorizontalAlignment(JTextField.LEFT);
		//instructions.setVerticalAlignment(JTextField.TOP);
		instructions.setText("Room-escape is a adventure game.");
		instructions.setBounds(200,50,120,40);
		instructions.setSize(300,300);
		P0.add(instructions);
		
		//JRadioButton
		Level1 = new JRadioButton("Level-1");
		Level1.setBounds(300,370,120,35);
				
		Level2 = new JRadioButton("Level-2");
		Level2.setBounds(300,470,120,35);
		
		ButtonGroup Group = new ButtonGroup();
		Group.add(Level1);
		Group.add(Level2);
				
		P0.add(Level1);
		P0.add(Level2);
		
		b1 = new JButton("Start");
		b1.setBounds(280,550,120,35);
		b1.setVisible(true);
		//b1.setOpaque(false);
		//b1.setContentAreaFilled(false);
		//b1.setBorderPainted(false);
		b1.setFocusable(false);
		P0.add(b1);
		
		b1.addActionListener(this);
		Level1.addActionListener(this);
		Level2.addActionListener(this);

	
		container.getContentPane().add(P0);
		container.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			//new
			container.setContentPane(new P1(container, lvl));
			container.remove(P0);
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
	//Main Program that starts Execution
	public static void main(String args[]) {
		P0 test = new P0();
		
	}
}