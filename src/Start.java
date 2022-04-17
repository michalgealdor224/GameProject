import javax.swing.*;
import java.awt.*;

public class Start extends JPanel {

    public Start () {
        JButton button = new JButton("new game");
        Font font = new Font("Ariel", Font.TYPE1_FONT, 100);
        this.setBackground(Color.CYAN);
        this.setFocusable(true);
        this.setBounds(0, 0, 800, 650);
        this.setVisible(true);
        this.setDoubleBuffered(true);
        add(button);

    }


}
