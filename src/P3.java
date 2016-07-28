package page;

import javax.swing.JPanel;
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
	
	public P3(JFrame container) {
		this.container = container;
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setLayout(null);
		
		JLabel lblOutOfTime = new JLabel("Out of time! You lost!");
		lblOutOfTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOutOfTime.setForeground(Color.RED);
		lblOutOfTime.setBounds(150, 109, 230, 30);
		contentPane.add(lblOutOfTime);
		
		JButton btnNewButton = new JButton("Quit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(107, 191, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Click here if you are ready!");
			}
		});
		btnRestart.setBounds(245, 191, 89, 23);
		contentPane.add(btnRestart);
		
		container.add(contentPane,BorderLayout.NORTH);
		
		container.setLayout(new BorderLayout());

		container.setSize(700,700);
		container.setVisible(true);
		container.setVisible(true);
	}


public static void main(String[] args) {
	File Clap = new File("C:\\Users\\Dehnam\\Desktop\\lost.wav");
	PlaySound(Clap);
	}
	static void PlaySound(File Sound){
		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
			
			Thread.sleep(clip.getMicrosecondLength()/1000);
		}catch(Exception e)
		{
			
		}
}
	}