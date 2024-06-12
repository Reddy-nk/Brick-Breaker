import java.awt.Color;
import java.awt.Graphics;

public class Brick {
    private int x, y;
    private final int WIDTH = 60, HEIGHT = 20;
    private boolean broken = false;

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        if (!broken) {
            g.setColor(Color.YELLOW);
            g.fillRect(x, y, WIDTH, HEIGHT);
        }
    }

    public boolean isBroken() {
        return broken;
    }

    public void breakBrick() {
        broken = true;
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
