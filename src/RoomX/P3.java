package RoomX;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class P3 extends JPanel {

	/**
	 * Create the panel.
	 */
	private static final long serialVersionUID = 3L;
	public JFrame container;
	private JPanel contentPane;
	JPanel P0;
	
	public P3(JFrame container, JPanel P0) {
		this.container = container;		
		this.P0 = P0;
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menuText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		container.setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblSorryYouLost = new JLabel("Out of time! You failed!");
		lblSorryYouLost.setForeground(Color.RED);
		lblSorryYouLost.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSorryYouLost.setBounds(130, 70, 200, 30);
		contentPane.add(lblSorryYouLost);
		
		JButton btnNewButton = new JButton("Quit");
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		btnNewButton.setBounds(125, 157, 89, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Restart");
		btnNewButton_1.setBackground(SystemColor.controlHighlight);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                container.setContentPane(P0);	
	            contentPane.removeAll();			
	            contentPane.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(230, 157, 89, 30);
		contentPane.add(btnNewButton_1);
		add(contentPane,BorderLayout.NORTH);

		setLayout(new BorderLayout());

		setSize(1000,666);
		setVisible(true);
		container.setVisible(true);
	}
}
