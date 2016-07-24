import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.imageio.*;

public class Page2 extends JFrame {

	private JPanel contentPane;
	private Image backgroundImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {  
				try {
					Page2 frame = new Page2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		File Clap = new File("C:\\Users\\Dehnam\\Desktop\\win.wav");
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
	public Page2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 180, 209));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("End");
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			}
		});
		btnNewButton.setBounds(120, 157, 89, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblCongratulationsYouEscaped = new JLabel("Congratulations! You escaped!");
		lblCongratulationsYouEscaped.setForeground(new Color(0, 255, 0));
		lblCongratulationsYouEscaped.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCongratulationsYouEscaped.setBounds(110, 82, 230, 30);
		contentPane.add(lblCongratulationsYouEscaped);
		
		JButton btnRestart = new JButton("Play Again");
		btnRestart.setBackground(SystemColor.controlHighlight);
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Click here if you are ready!");
			}
		});
		btnRestart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRestart.setBounds(230, 157, 89, 30);
		contentPane.add(btnRestart);
	}
}
