import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener {

	private double speed = 9;
	private double ACCELERATION = .55;
	private Bird flappy;
	private Pipes[] pipes;
	private Bonus[] bonus;
	private Timer t;
	static int score = 0;
	private JLabel label;
	public Boolean started;

	// Set to true to stop collisions !!!
	private Boolean debugMode = false;

	public Game() {
		// Random random = new Random();
		// int nextrand = random.nextInt();
		label = new JLabel("Your score is: " + score);
		add(label);
		setBackground(new Color(186, 223, 255));
		flappy = new Bird(50, 50, 35, 25, Color.RED);
		Pipes pipe1 = new Pipes(500, 0, 100, (int) (Math.random() * 400 + 100));
		Pipes pipe2 = new Pipes(750, 0, 100, (int) (Math.random() * 400 + 100));
		Pipes pipe3 = new Pipes(1000, 0, 100, (int) (Math.random() * 400 + 100));
		pipes = new Pipes[] { pipe1, pipe2, pipe3 };

		Bonus bonus0 = new Bonus(-20, 100, 5, (int) (Math.random() * 40));

		pipes = new Pipes[] { pipe1, pipe2, pipe3 };
		bonus = new Bonus[] { bonus0 };
		t = new Timer(1000 / 60, this);
		t.start();

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				speed = -7;
			}
		});

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		flappy.draw(g);
		for (Pipes p : pipes) {
			p.draw(g);
		}
		for (Bonus b : bonus) {
			b.draw(g);
		}

		g.setColor(Color.GREEN);
		g.fillRect(0, getHeight() - 70, getWidth(), 75);
		g.setColor(Color.BLACK);
		g.drawRect(0, getHeight() - 70, getWidth(), 75);
	}

	public void actionPerformed(ActionEvent e) {
		flappy.setY(flappy.getY() + speed);
		speed += ACCELERATION;
		for (Bonus b : bonus) {
			b.move();
			if (b.isColliding(flappy) == true) {
				score++;
				System.out.println("bonus");
				label.setText("Your score is: " + score);
			}
			// if (b.collisionDown(flappy) == true) {
			// score++;
			// label.setText("Your score is: " + score);
			// }

			/*
			 * if (b.getX() == -50) { score++; label.setText("Your score is: " +
			 * score); }
			 */
			if (b.getX() <= -100) {
				b.setX(650);
			}
		}
		repaint();
		for (Pipes p : pipes) {
			p.move();
			if (p.collision(flappy) == true) {
				endgame();
				return;
			}
			if (!debugMode) {
				if (p.collisionDown(flappy) == true) {
					endgame();
					return;
				}

				if (p.getX() == -50) {
					score++;
					label.setText("Your score is: " + score);
				}
				if (p.getX() <= -100) {
					p.setX(650);
				}
			}
		}

		repaint();

		if (flappy.isEnd() == true) {
			endgame();
			return;
		}

	}

	private void endgame() {
		t.stop();
		new NamePanel();
	}

	public static int getScore() {
		return score;
	}

}
