package coinJar;
import javax.swing.*;
import java.awt.*;

//Base GUI code taken from https://www.guru99.com/java-swing-gui.html
public class Game {
	public static void setup() {
		 //Creating the Frame
        JFrame frame = new JFrame("coinJar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("New Game");
        JMenuItem m22 = new JMenuItem("Exit");
        m1.add(m11);
        m1.add(m22);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JButton roll = new JButton("Roll");
        JButton pass = new JButton("Pass");
        panel.add(roll);
        panel.add(pass);

        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
        String[] options = {"Easy", "Normal", "Hard"};
		int x = JOptionPane.showOptionDialog(null, "Choose your difficulty:", "Click a button",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
        Die d = new Die(x);
        System.out.println("Selected Difficulty: "+d.getDifficulty());
	}
	public static void main(String args[]){
		setup();
		
  }
}
