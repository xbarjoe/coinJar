package coinJar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

//Base GUI code taken from https://www.guru99.com/java-swing-gui.html

public class Game {
	static boolean playerTurn = true;
	static boolean hasGoneOnce = false;
	static Board b;
	public static void setup() {

	}

	public static void play() {

	}

	public static void main(String args[]) {
		// setup();
		// Creating the Frame
		JFrame frame = new JFrame("coinJar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		JPanel panel1 = new JPanel();
		// Creating the MenuBar and adding components
		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("File");
		// JMenu m2 = new JMenu("Help");

		mb.add(m1);
		// mb.add(m2);
		JMenuItem m11 = new JMenuItem("New Game");
		JMenuItem m33 = new JMenuItem("Help");
		JMenuItem m22 = new JMenuItem("Exit");
		m1.add(m11);
		m11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		m1.add(m33);
		m33.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop desktop = java.awt.Desktop.getDesktop();
					URI oURL = new URI(
							"https://www.creativeescaperooms.com/blogs/how-to-articles/how-to-play-the-game-penny-drop");
					desktop.browse(oURL);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		m1.add(m22);
		m22.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		// Creating the panel at bottom and adding components
		JPanel panel = new JPanel(); // the panel is not visible in output
		JButton roll = new JButton("Roll");
		JButton pass = new JButton("Pass");
		panel.add(roll);
		panel.add(pass);

		// Text Area at the Center
		JLabel pc = new JLabel();
		JLabel oc = new JLabel();
		JLabel rollnum = new JLabel();

		// Adding Components to the frame.
		JPanel temp1 = new JPanel();

		panel1.add(BorderLayout.SOUTH, panel);
		temp1.add(BorderLayout.NORTH, rollnum);
		// frame.getContentPane().add(BorderLayout.SOUTH, rollnum);
		frame.getContentPane().add(BorderLayout.NORTH, mb);
		temp1.add(BorderLayout.CENTER, pc);
		temp1.add(BorderLayout.SOUTH, oc);
		// panel.add(BorderLayout.EAST,temp1);
		frame.getContentPane().add(temp1);
		frame.getContentPane().add(BorderLayout.SOUTH, panel1);
		frame.setVisible(true);
		String[] options = { "Easy", "Normal", "Hard" };
		int x = JOptionPane.showOptionDialog(null, "Choose your difficulty:", "Click a button",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
		Die d = new Die(x);
		System.out.println("Selected Difficulty: " + d.getDifficulty());
		d.print();
		Player p1 = new Player();
		Player p2 = new Player();

		pc.setText("Player coins:" + p1.getStash());
		oc.setText("Opponent coins:" + p2.getStash());
		roll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (playerTurn) {
					int dienum = d.roll();
					rollnum.setText("Roll: " + dienum);
					hasGoneOnce = true;
					p1.remove();
					pc.setText("Player coins:" + p1.getStash());
					System.out.println(dienum);
					b.add(6);
					p1.add();
					
					pc.setText("Player coins:" + p1.getStash());
				}
			}
		});
		pass.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (playerTurn && hasGoneOnce) {
					playerTurn = false;
					p2.remove();
					oc.setText("Opponent coins:" + p2.getStash());
					p2.add(b.add(d.roll()));
					oc.setText("Opponent coins:" + p2.getStash());
					p2.remove();
					oc.setText("Opponent coins:" + p2.getStash());
					p2.add(b.add(d.roll()));
					oc.setText("Opponent coins:" + p2.getStash());
					playerTurn = true;
					hasGoneOnce=false;
				} 
			}
		});

	}
}
