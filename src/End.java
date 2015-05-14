
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class End extends JFrame {

	public End(String string) {

		// System.out.println("Please Insert Your Name to see HighScores, If your score is higer than a High Score, It will be added accordingly");
		// Scanner scan = new Scanner(System.in);
		// String urmom = scan.nextLine();

		HighscoreManager hm = new HighscoreManager();
		// NamePanel lab = new NamePanel();

		// lab.toFront();

		setSize(300, 400);
		setLocation(100, 100);
		setResizable(false);
		JPanel panel = new JPanel(new BorderLayout());
		setContentPane(panel);
		JTextArea txt = new JTextArea();

		txt.setText("GAME OVER\nYour score is: " + Game.getScore() + "\n"
				+ "High Scores: " + "\n" + hm.getHighscoreString());
		txt.setEditable(false);
		panel.add(txt, BorderLayout.NORTH);

		// System.out.print(hm.getHighscoreString());

		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel.add(button, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
