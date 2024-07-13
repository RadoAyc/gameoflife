import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        int rows = 50;
        int cols = 50;
        GameOfLife game = new GameOfLife(rows, cols);
        game.initializeRandom();

        JFrame frame = new JFrame("Game of Life");
        GamePanel gamePanel = new GamePanel(game);
        frame.add(gamePanel);
        frame.setSize(cols * 10 + 17, rows * 10 + 40);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.update();
                gamePanel.repaint();
            }
        });
        timer.start();
    }
}


