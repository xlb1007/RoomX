package window;

import javax.swing.*;

public class swing {
	
public static void main (String[] args){
	JFrame frame = new JFrame("test");
	frame.setVisible(true);
	frame.setSize(500, 500);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JLabel label = new JLabel("Congratulations! You successfully escaped!");
	JPanel panel = new JPanel();
	frame.add(panel);
	panel.add(label);
	
	JButton button = new JButton("Quit");
	panel.add(button);
}

}
