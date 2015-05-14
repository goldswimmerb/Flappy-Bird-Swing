import java.awt.Color;
import java.awt.Graphics;

public class Bonus {
	private int x;
	private int y;
	private int width;
	private int height;
	private int speed = 2;
	private static boolean bonusReady;

	// boolean isRunning = true;

	public Bonus(int x, int y, int width, int height) {
		bonusReady = true;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x - 50, y, width, height + 50);

		// g.fillRect(x, height + 20, width, height +45);
		g.setColor(Color.BLACK);
		g.drawRect(x - 50, y, width, height + 50);
		// g.drawRect(x, height + 20, width, height +45);
	}

	public void move() {
		this.x -= speed;

	}

	public boolean isColliding(Bird bird) {
		if (x < 0)
			bonusReady = true;
		if (bird.getX() > x - (33) && bird.getX() < x + (35 / 2)
				&& bird.getY() < y + 50 && bird.getY() > y - 50 && bonusReady) {
			bonusReady = false;
			return true;
		}

		return false;
	}

	/*
	 * public boolean collisionDown(Bird bird) { for (int i = this.x; i < x +
	 * width; i++) { for (int j = height + 125; j < height + 300; j++) { if (i
	 * == bird.getX() + bird.getWidth() && j == bird.getY() + bird.getHeight())
	 * { return true; } }
	 * 
	 * } return false; }
	 */

}
