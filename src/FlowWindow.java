

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FlowWindow extends JFrame {
     
    public FlowWindow() {
    	setTitle("FlowLayout");
    	
        Container contentPane = getContentPane();
        
        // FlowLayout (int align, int hgap, int vgap);
   		contentPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 50));
        
		contentPane.add(new JButton("Button 1"));
        contentPane.add(new JButton("BT2"));
        contentPane.add(new JButton("Button 3"));
        contentPane.add(new JButton("Long-Named Button 4"));
        contentPane.add(new JButton("Button 5"));

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 50));
		this.add(panel);
		JButton NewButton = new JButton("Click to Create");
		panel.add(NewButton);
		
		NewButton.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	
//		        JFrame mainFrame = new JFrame("Java Swing Examples");
//		        mainFrame.setSize(400,400);
//		        mainFrame.setLayout(new GridLayout(3, 1));
//		    	JLabel statusLabel = new JLabel("",JLabel.CENTER);       
//		        statusLabel.setSize(350,100);
//		        mainFrame.add(statusLabel);
//		        statusLabel.setText("Create Button clicked.");
//		        mainFrame.setVisible(true); 
//		        JPanel panel1 = new JPanel();
//				panel1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 50));
//				JButton NewButton1 = new JButton("Close");
//				panel1.add(NewButton1);
//				mainFrame.add(panel1);
//				
//			    NewButton1.addActionListener(new ActionListener() {
//			        public void actionPerformed(ActionEvent e) {
//			             System.exit(0);
//			          }
//			     });
		    	
		    	
		    	JDialog dialog = new JDialog();
		    	Container container = dialog.getContentPane();
		    	container.setLayout(new FlowLayout());
						//tf1.addActionListener(this);
				
				JPanel inputPanel = new JPanel();
				JLabel n1 = new JLabel("First");
				JTextField tf1 = new JTextField(2);
				inputPanel.add(n1,BorderLayout.WEST);
				inputPanel.add(tf1,BorderLayout.WEST);
				JLabel n2 = new JLabel("Second");
				JTextField tf2 = new JTextField(2);
				inputPanel.add(n2,BorderLayout.WEST);
				inputPanel.add(tf2,BorderLayout.WEST);
				JLabel n3 = new JLabel("Third");
				JTextField tf3 = new JTextField(2);
				inputPanel.add(n3,BorderLayout.WEST);
				inputPanel.add(tf3,BorderLayout.WEST);
				JLabel n4 = new JLabel("Fourth");
				JTextField tf4 = new JTextField(2);
				inputPanel.add(n4,BorderLayout.WEST);
				inputPanel.add(tf4,BorderLayout.WEST);
				JPanel outputPanel = new JPanel();
				JLabel textfield = new JLabel("textfield");
				outputPanel.add(textfield,BorderLayout.CENTER);
				JPanel buttonPanel = new JPanel();
				JButton NewButton1 = new JButton("Try");
				buttonPanel.add(NewButton1,BorderLayout.WEST);
				JButton NewButton2 = new JButton("Leave");
				buttonPanel.add(NewButton2,BorderLayout.WEST);
				
		        container.add(inputPanel,
		                BorderLayout.NORTH);
		        container.add(outputPanel,
		                BorderLayout.CENTER);
		        container.add(buttonPanel,
		                BorderLayout.SOUTH);
		        
		    	dialog.setSize(400, 300);
		    	//pack();
		        dialog.setVisible(true);
		    }
		});
    }
     public void actionPerformed( ActionEvent event ){
         JOptionPane.showMessageDialog( null,
            "You pressed: " + event.getActionCommand() );
    }
    public static void main(String args[]) {
        FlowWindow window = new FlowWindow();
        
      
    }
}
