import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[]args){
        new Main();
    }


    public static final int WINDOW_WIDTH=800;
    public static final int WINDOW_HEIGHT=650;
    public Main() {
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        GameScene gameScene=new GameScene(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        this.add(gameScene);
       // GameOver gameOver = new GameOver();
        //this.add(gameOver);
       // Start start = new Start();
        //this.add(start);
    }

}