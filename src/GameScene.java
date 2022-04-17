import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel {

    private Obstacle obstacle1;
    private Obstacle obstacle2;
    private Obstacle obstacle3;
    private Player player;
    private Player frameUp;
    private Player frameDown;
    private Player frameRight;
    private Player frameLeft;
    public static final int GAME_SPEED_FAST = 5;
    private ImageIcon candy;

    public GameScene(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.obstacle1 = new Obstacle(100, 200, getWidth() / 16, getWidth() / 16, Color.MAGENTA);
        this.obstacle2 = new Obstacle(300, 300, getWidth() / 16, getWidth() / 16, Color.CYAN);
        this.obstacle3 = new Obstacle(700, 100, getWidth() / 16, getWidth() / 16, Color.ORANGE);
        this.player = new Player(20, 30, getWidth() / 16, getWidth() / 16, Color.BLUE);
        //  this.player = new Rectangle();
        this.setBackground(Color.white);
        this.frameUp = new Player(getX(), getY(), getWidth(), 0, Color.black);
        this.frameDown = new Player(getX(), getHeight() - 55, getWidth(), 0, Color.black);
        this.frameRight = new Player(getWidth() - 35, getY(), getWidth() / 40,0, Color.black);
        this.frameLeft = new Player(getX(), getY(), getWidth() / 40, 0, Color.black);
        this.candy = new ImageIcon("candy.jpg");
        this.mainGameLoop();
        Maze(obstacle1);
        Maze(obstacle2);
        Maze(obstacle3);
    }

    public void Maze(Obstacle obstacle) {

        Thread t1 = new Thread(() -> {
            Movement movement = new Movement(this.player);
            this.setFocusable(true);
            this.requestFocus();
            this.addKeyListener(movement);
            obstacle.moveObstacles();

            while (true) {
                try {
                    repaint();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    t1.start();
//        Thread t3=new Thread(()->{
//        while(true){
//        try{
//        if(obstacle.isDown()){
//        obstacle.moveDown();
//        obstacle.moveRight();
//        }
//        if(obstacle.isUp()){
//        obstacle.moveUp();
//        obstacle.moveLeft();
//        }
//        repaint();
//        Thread.sleep(10);
//
//        }catch(InterruptedException e){
//        e.printStackTrace();
//        }
//        }
//        });
//        t3.start();
//        }

// Thread t2 = new Thread(() -> {
//   Movement movement = new Movement(this.player);
// this.setFocusable(true);
//this.requestFocus();
///this.addKeyListener(movement);
//while (obstacle.getY() < 550 || obstacle.getY() == 0) {
//  try {
//    repaint();
//  obstacle.moveDown();
//Thread.sleep(5);
// } catch (InterruptedException e) {
//   e.printStackTrace();
// }
// }
//while (obstacle.getY()  > 0 || obstacle.getY() >= 550) {
//  try {
//    repaint();
//  obstacle.moveUp();
//Thread.sleep(10);
// } catch (InterruptedException e) {
//   e.printStackTrace();
// }
// }
//});
// t2.start();
    }

        private void mainGameLoop () {
            new Thread(() -> {
                while (true) {
                    switch (this.player.getDirection()) {
                        case Player.LEFT:
                            this.player.moveLeft();
                            break;
                        case Player.RIGHT:
                            this.player.moveRight();
                            break;
                        case Player.UP:
                            this.player.moveUp();
                            break;
                        case Player.DOWN:
                            this.player.moveDown();
                            break;
                    }
                    player.checkCollision(obstacle1);
                    repaint();
                    try {
                        Thread.sleep(GAME_SPEED_FAST);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.obstacle1.paint(g);
        this.obstacle2.paint(g);
        this.obstacle3.paint(g);
        this.player.paint(g);
        this.frameUp.paint(g);
        this.frameDown.paint(g);
        this.frameLeft.paint(g);
        this.frameRight.paint(g);
        //  this.candy.paintIcon(this,g,100,100);
    }

}