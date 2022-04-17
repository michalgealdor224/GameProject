import java.awt.*;

public class Obstacle {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private int direction;
    public static final int WINDOW_WIDTH=800;
    public static final int WINDOW_HEIGHT=650;


    public Obstacle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y =y ;
        this.width =width ;
        this.height =height ;
        this.color = color;
        this.direction = -1;
    }

    public void setDirection() {
      this.direction*=-1;
    }
    public boolean isUp(){
        return this.direction > 0;
    }
    public boolean isDown () {
        return this.direction < 0;
    }
    public void hit(int x, int y){
        if (this.x>=x || this.x==0){
            setDirection();
        }
        if (this.y>=y || this.y==0){
            setDirection();
        }
    }
    public void moveObstacles () {
        boolean flag =false;
        while (true) {
            while (flag == false && this.x !=0) {
                moveLeft();
                System.out.println("yess");
            }
                    flag=true;

            while (flag == true && this.x <710) {
                moveRight();
                System.out.println("nooo");
            }
                    flag= false;
                }
            }

    public void move2 () {
       // if (this.x == 710) {
            this.moveLeft();
       // }
    }
    public void step(){
        if (isDown()){
            if ( this.x<=0) {
                this.moveDown();this.moveRight();
            }
            if (this.x == 710) {
                this.moveLeft();this.moveDown();
            }
            if (this.y ==570 ){
                this.moveUp();this.moveRight();
            }
            if (this.x > 0 && this.x < 710) {
                this.moveDown();this.moveRight();
            }
        }
        if (isUp()) {
            if (this.y==0 && this.x <710) {
                this.moveDown();this.moveRight();
            }
            if (this.x==0) {
                this.isUp();this.moveRight();
            }
            if (this.x == 710) {
                this.moveUp();this.moveLeft();
            }
           if (this.y >0 && this.y < 570) {
               this.moveUp();this.moveLeft();
           }
       }

        }
 //   }
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

    public void paint (Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillOval(
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
}
