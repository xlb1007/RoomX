

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
		//setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 50));
		this.add(panel);
		JButton NewButton = new JButton("Click to Create");
		panel.add(NewButton);
		
		NewButton.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
//              NewButton.setForeground(Color.RED);
		    	
//		    	dispose();
//		    	System.exit(0);
		    	
		        JFrame mainFrame = new JFrame("Java Swing Examples");
		        mainFrame.setSize(400,400);
		        mainFrame.setLayout(new GridLayout(3, 1));
		    	JLabel statusLabel = new JLabel("",JLabel.CENTER);       
		        statusLabel.setSize(350,100);
		        mainFrame.add(statusLabel);
		        statusLabel.setText("Create Button clicked.");
		        mainFrame.setVisible(true); 
		        JPanel panel1 = new JPanel();
				panel1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 50));
				JButton NewButton1 = new JButton("Close");
				panel1.add(NewButton1);
				mainFrame.add(panel1);
				
			    NewButton1.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent e) {
			             System.exit(0);
			          }
			     });
		  
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
