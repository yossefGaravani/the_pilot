import javax.swing.*;
import java.awt.*;

public class PlanImage {

    private double x;
    private int y;
    private ImageIcon sheep;

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public PlanImage(ImageIcon sheep, int x, int y) {
        this.sheep = sheep;
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paint(Graphics g) {
        this.sheep.paintIcon((Component) null, g, (int) this.x, this.y);
    }

    public void setImage(ImageIcon image) {
        this.sheep = image;
    }


}
