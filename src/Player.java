import javax.swing.*;
import java.awt.*;

public class Player extends JFrame {
    private static final int NONE = 0;
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private int direction;
    public static final int RIGHT = 1;
    public static final int LEFT = 2;
    public static final int UP = 3;
    public static final int DOWN = 4;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public Player(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.direction = NONE;
    }
    public void setDirection (int direction) {
        this.direction = direction;
    }

    public int getDirection () {
        return this.direction;
    }

    public void paint (Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillRect(
                this.x,
                this.y,
                this.width,
                this.height
        );
    }
    public void moveRight () {
        this.x++;
    }

    public void moveLeft () {
        this.x--;
    }

    public void moveUp () {
        this.y--;
    }

    public void moveDown () {
        this.y++;
    }
    public boolean checkCollision (Obstacle obstacle) {
        boolean collision = false;
        Rectangle obstecleRect = new Rectangle(obstacle.getX(),obstacle.getY(),
                obstacle.getWidth(),obstacle.getWidth());
        Rectangle player = new Rectangle(this.x,this.y,this.width,this.height);
     //   System.out.println(collision);
        if (player.intersects(obstecleRect)) {
            collision = true;
            GameOver gameOver = new GameOver();
            this.add(gameOver);
        //    System.out.println(collision);
        }
        return collision;
    }
}
