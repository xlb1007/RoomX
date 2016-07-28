<<<<<<< HEAD
=======
package page;

import javax.swing.JPanel;
>>>>>>> origin/master
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
<<<<<<< HEAD
		this.container = container;		
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
			JOptionPane.showMessageDialog(null,"Go back to select the level!");
			}
		});
		btnNewButton_1.setBounds(230, 157, 89, 30);
		contentPane.add(btnNewButton_1);
		add(contentPane,BorderLayout.NORTH);

		setLayout(new BorderLayout());

		setSize(700,700);
		setVisible(true);
		container.setVisible(true);
	}
}
=======
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
>>>>>>> origin/master
