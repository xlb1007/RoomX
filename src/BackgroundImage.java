import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JFrame;

class BackgroundImage extends JFrame
{
	public BackgroundImage()
	{
		//1. Create the frame.
		JFrame frame = new JFrame("BackgroundImage Demo");

		//2. Create components and put them in the frame.
		//...create emptyLabel...
		try {
			
				frame.getContentPane().add(new JPanelWithBackground("/Users/boli/Downloads/fitness.jpg"));
		} catch (IOException e) {
				e.printStackTrace();
		}
		//3. Set Window Size
		frame.setSize(500,500);

		//4. Show it.
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		//5 Optional: What happens when the frame closes?
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		BackgroundImage img = new BackgroundImage();	 
	}
}

