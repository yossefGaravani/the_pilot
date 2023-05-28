import javax.swing.*;
import java.awt.*;

public class Instructions extends JFrame {

    private static int width = 800, height = 600;
    private ImageIcon imageIcon;

    public Instructions() {
        this.setVisible(true);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        imageIcon = new ImageIcon("טייס זהיר תמונה.png");

        // label
        JLabel label = new JLabel("sf");
        label.setBounds(0, 0, width, height);
        label.setIcon(imageIcon);
        this.add(label);
    }

}
