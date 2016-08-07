package RoomX;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	JFrame container;
	JPanel P0;
	public Frame() {
		super("P0  Demo");
		container = this;
		container.setSize(1000,666);
		container.setResizable(false);
		container.setBackground(Color.orange);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		P0 = new P0(container);
		container.add(P0);
		

	
		//container.getContentPane().add(P0);
		container.setVisible(true);
	}
}
