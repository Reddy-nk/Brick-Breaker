import javax.swing.JFrame;

public class BrickBreaker extends JFrame {

    public BrickBreaker() {
        setTitle("Brick Breaker Game");
        setSize(700, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new GamePanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        new BrickBreaker();
    }
}
