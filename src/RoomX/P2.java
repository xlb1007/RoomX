package RoomX;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class P2 extends JPanel{
	private static final long serialVersionUID = 2L;
	public JFrame container;
	private JPanel contentPane;
	JPanel P0;
	PanelController pc;
	
	public P2(JFrame container, JPanel P0, PanelController pc) {
		this.container = container;	
		this.P0 = P0;
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 180, 209));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		container.setContentPane(contentPane);
		contentPane.setLayout(null);
		this.pc = pc;
		
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
//                container.setContentPane(P0);	
				pc.switchPanel(0);
                contentPane.removeAll();			
                contentPane.setVisible(false);
			}
		});
		btnRestart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRestart.setBounds(230, 157, 89, 30);
		contentPane.add(btnRestart);
		add(contentPane,BorderLayout.NORTH);
		
		setLayout(new BorderLayout());

		setSize(1000,666);
		setVisible(true);
		container.setVisible(true);
	}
    
}
