import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel {

    public GameOver () {
        JLabel label = new JLabel("game over!!");
        Font font = new Font("Ariel", Font.ITALIC, 400);
        this.setBackground(Color.CYAN);
        this.setFocusable(true);
        this.setBounds(0, 0, 800, 650);
        this.setVisible(true);
        this.setDoubleBuffered(true);
        add(label);
    }

}
