package window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.imageio.*;

public class Page2_fail extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page2_fail frame = new Page2_fail();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	/**
	 * Create the frame.
	 */
	public Page2_fail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menuText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
			JOptionPane.showMessageDialog(null,"Go back to select the level!");
			}
		});
		btnNewButton_1.setBounds(230, 157, 89, 30);
		contentPane.add(btnNewButton_1);
	}

}
