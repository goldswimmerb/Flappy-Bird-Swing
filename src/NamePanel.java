import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NamePanel extends JFrame implements ActionListener, FocusListener {
	HighscoreManager hm = new HighscoreManager();
	JPanel main;
	JTextField field;
	JButton button;
	JLabel label;
	JLabel label1;
	JLabel scores;

	public NamePanel() {
		initFrame();
	}

	private void initFrame() {
		main = new JPanel();
		label = new JLabel("Game Over");
		// label1 = new JLabel("Place Name Below:");
		field = new JTextField("Put Name Here");
		scores = new JLabel("Your Score: " + Game.getScore());
		button = new JButton("Submit");
		field.addActionListener(this);
		button.addActionListener(this);
		main.setLayout(new GridLayout(7, 1));
		main.add(label);
		// main.add(label1);
		main.add(scores);
		main.add(field);
		main.add(button);
		field.addFocusListener(this);
		add(main);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button) || e.getSource().equals(field)) {
			if (field.getText().equals("")) {
				field.setText("Anonymous");
				hm.addScore(field.getText(), Game.getScore());
				new End("Game Over");
				setVisible(false);
			} else {
				hm.addScore(field.getText(), Game.getScore());

				new End("Game Over");
				setVisible(false);
			}
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource().equals(field)) {
			field.setText("");
		}

	}

	@Override
	public void focusLost(FocusEvent e) {

		// TODO Auto-generated method stub

	}
}
