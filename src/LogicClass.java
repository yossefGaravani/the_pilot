import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class LogicClass extends JPanel {

    private PlanImage planImage;

    public static MainWindow mainWindow;
    private ImageIcon image;
    private static playerMovement playerMovement;

    private Audio audio;

    private static JLabel label;

    private static int timeFlag = 0, secFlag = 0;


    public LogicClass(int x, int y, int width, int height) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        //panel settings
        this.setBounds(x, y, width, height);
        // fields value
        image = new ImageIcon("UpFlight.jpg");
        this.planImage = new PlanImage(image, 100, 100);
        audio = new Audio("Freestyle-Beat-_Bible_-_-Free-Type-Beat-2023-_-Hard-Fast-Rap-Trap-Beat-Instrumental-_256-kbps_.wav");

        label = new JLabel("Right");
        label.setBounds(100, 80, 200, 50);
        label.setForeground(Color.red);
        label.setFont(new Font("Serif", Font.BOLD, 45));
        this.add(label);

        gameLoop();
        currentTimeFlag();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.planImage.paint(g);
    }

    public void gameLoop() {
        Thread t = new Thread(() -> {
            playerMovement = new playerMovement();
            this.addKeyListener(playerMovement);
            this.setFocusable(true);
            this.requestFocus();
            while (true) {
                repaint();
                switch (playerMovement.getNum()) {
                    case 1:
                        image = new ImageIcon("UpFlight.jpg");
                        this.planImage.setImage(image);
                        break;
                    case 2:
                        image = new ImageIcon("rightFlight.jpg");
                        this.planImage.setImage(image);
                        break;
                    case 3:
                        image = new ImageIcon("downFlight.jpg");
                        this.planImage.setImage(image);
                        break;
                    case 4:
                        image = new ImageIcon("leftFlight.jpg");
                        this.planImage.setImage(image);
                        break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        t.start();
    }

    public void currentTimeFlag() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    if (timeFlag == 4)
                        timeFlag = 0;
                    timeFlag++;
                    switch (timeFlag) {
                        case 1:
                            label.setText(getRandomDirection());
                            break;
                        case 2:
                            label.setText(getRandomDirection());
                            break;
                        case 3:
                            label.setText(getRandomDirection());
                            break;
                        case 4:
                            label.setText(getRandomDirection());
                    }
                    Thread.sleep(1500);
                    if (!isPass()) {
                        audio.stopAudio();
                        audio = new Audio("Game Over sound effect (256 kbps).wav");
                        audio.StartAudio();
                        label.setText("You lose:(, Try again...");
                        break;
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedAudioFileException e) {
                    throw new RuntimeException(e);
                } catch (LineUnavailableException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();

    }

    public static String getRandomDirection() {
        String[] strs = {"Up", "Right", "Down", "Left"};
        Random r = new Random();
        int random = r.nextInt(4);
        return strs[random];
    }

    public static boolean isPass() throws InterruptedException {
        waitASec();
        if ((label.getText() == "Up" && playerMovement.getNum() != 1) ||
                (label.getText() == "Down" && playerMovement.getNum() != 3) ||
                (label.getText() == "Right" && playerMovement.getNum() != 2) ||
                (label.getText() == "Left" && playerMovement.getNum() != 4))
            return false;
        return true;

    }

    public static void waitASec() {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1490);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
    }

}
