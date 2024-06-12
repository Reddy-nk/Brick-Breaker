import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    private int x, y, dx = -1, dy = -2;
    private final int DIAMETER = 10;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public void move(Paddle paddle, Brick[] bricks) {
        x += dx;
        y += dy;

        // Bounce off left and right walls
        if (x <= 0 || x >= 690) {
            dx = -dx;
        }
        // Bounce off top wall
        if (y <= 0) {
            dy = -dy;
        }
        // Bounce off paddle
        if (x >= paddle.getX() && x <= paddle.getX() + paddle.getWidth() && y >= paddle.getY() && y <= paddle.getY() + paddle.getHeight()) {
            dy = -dy;
        }
        // Bounce off bricks
        for (Brick brick : bricks) {
            if (!brick.isBroken() && x >= brick.getX() && x <= brick.getX() + brick.getWidth() && y >= brick.getY() && y <= brick.getY() + brick.getHeight()) {
                dy = -dy;
                brick.breakBrick();
            }
        }

        // Game over condition (ball falls below paddle)
        if (y > 570) {
            dx = dy = 0; // Stop the ball
        }
    }
}
