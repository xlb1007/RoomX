package RoomX;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	PanelController pc;
	public Frame() {
		super("New");
		setSize(1000,666);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
