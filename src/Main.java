import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class Main extends JFrame {

    public static final int WINDOW_WIDTH = 500, WINDOW_HEIGHT = 520;
    public static final int x = 0, y = 0;

    public static void main(String[] args) {
        Main main = new Main();
    }

    public Main() {
        // Window setting
        this.setVisible(true);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // First button
        JButton button = new JButton("Start play");
        button.setBounds(150, 300, 200, 50);
        this.add(button);

        //Second button
        JButton button1 = new JButton("Instructions");
        button1.setBounds(150, 200, 200, 50);
        this.add(button1);
        repaint();


        button.addActionListener((e -> {
            this.dispose();
            try {
                MainWindow mailWindow = new MainWindow(WINDOW_WIDTH, WINDOW_HEIGHT);
            } catch (UnsupportedAudioFileException ex) {
                throw new RuntimeException(ex);
            } catch (LineUnavailableException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }));

        button1.addActionListener((e -> {
            Instructions instructions = new Instructions();
        }));


    }
}