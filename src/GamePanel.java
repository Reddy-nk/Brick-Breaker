import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements ActionListener {
    private Timer timer;
    private Paddle paddle;
    private Ball ball;
    private Brick[] bricks;

    public GamePanel() {
        paddle = new Paddle(300, 550);
        ball = new Ball(350, 530);
        bricks = new Brick[30]; // Create a grid of bricks
        for (int i = 0; i < bricks.length; i++) {
            bricks[i] = new Brick((i % 10) * 60 + 30, (i / 10) * 20 + 50);
        }
        setBackground(Color.BLACK);

        timer = new Timer(10, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT) {
                    paddle.move(-1);
                } else if (key == KeyEvent.VK_RIGHT) {
                    paddle.move(1);
                }
            }
        });
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paddle.draw(g);
        ball.draw(g);
        for (Brick brick : bricks) {
            brick.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.move(paddle, bricks);
        repaint();
    }
}
