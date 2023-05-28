import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class playerMovement implements KeyListener {

    private int num;

    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                this.num = 1;
                break;
            case KeyEvent.VK_DOWN:
                this.num = 3;
                break;
            case KeyEvent.VK_LEFT:
                this.num = 4;
                break;
            case KeyEvent.VK_RIGHT:
                this.num = 2;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public int getNum() {
        return this.num;
    }

}
