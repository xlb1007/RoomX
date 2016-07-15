import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BorderWindow extends JFrame {
     
    public BorderWindow() {
	
		setTitle("BorderLayout");
		Container contentPane = getContentPane();
   		contentPane.setLayout(new BorderLayout(30, 30));

        contentPane.add(new JButton("TIMER"),
                        BorderLayout.NORTH);
        contentPane.add(new JButton("ABORT"),
                        BorderLayout.CENTER);
        contentPane.add(new JButton("PAUSE"),
                        BorderLayout.WEST);
        contentPane.add(new JButton("UNLOCK"),
                        BorderLayout.SOUTH);
        contentPane.add(new JButton("CLUE"),
                        BorderLayout.EAST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

		pack();
		setVisible(true);
    }

    public static void main(String args[]) {
        BorderWindow window = new BorderWindow();
    }
}
