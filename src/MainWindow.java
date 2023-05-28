import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class MainWindow extends JFrame {


    public MainWindow(int width, int height) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.setVisible(true);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LogicClass logicClass = new LogicClass(0, 0, width, height);
        this.add(logicClass);

    }

    public void close(){
        this.dispose();
    }
}
