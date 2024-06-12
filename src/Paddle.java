import java.awt.Graphics;
import java.awt.Color;

public class Paddle {
    private int x, y;
    private final int WIDTH = 100, HEIGHT = 10;
    private final int MOVE_SPEED = 20;

    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public void move(int direction) {
        x += direction * MOVE_SPEED;
        if (x < 0) x = 0;
        if (x > 600) x = 600; // Adjust to keep paddle within screen boundaries
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }
}
