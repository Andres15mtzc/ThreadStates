import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Canyonball extends Thread{
    int x, y, px, py;
    Graphics g;
    BufferedImage dropperImg, bulletImg;
    String[] states = {"NEW ", "RUNNABLE", "TIMED WAITING", "TERMINATED"};
    boolean isAlive = true;
    boolean kill = true;
    int actualState = 0, lastState = 0;

    Canyonball(int x, int y, Graphics g){
        this.x = x;
        this.y = y;
        this.g = g;
        try {
            bulletImg = ImageIO.read(new File("./src/Assets/Bullet.png"));
            dropperImg = ImageIO.read(new File("./src/Assets/Dropper.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        drawImg(x-95, y, "", Color.DARK_GRAY, dropperImg);
    }
    /* 
    private void drawCircle(int x, int y, String text, Color color){
        g.setColor(color);
        g.drawString(text, x, y-1);
        g.fillOval(x, y, r, r);
    }*/

    private void drawImg(int x, int y, String text, Color color, BufferedImage image){
        g.setColor(color);
        g.drawString(text, x, y-1);
        g.drawImage(image, x, y, null);
    }

    private void drawRect(int x, int y, String text, Color color){
        g.setColor(color);
        g.drawString(text, x, y-1);
        g.fillRect(x, y, 100, 60);
    }

    private void work(){
        while(isAlive){
            switch(actualState){
                case 0:
                    executeCreate();
                    break;
                case 1:
                    executeMovement();
                    break;
                case 2:
                    executePause();
                    break;
                case 3:
                    executeTerminated();
                    break;
            }
        }
    }

    @Override
    public void run() {
        work();
    }

    private void executeMovement(){
        px = x;
        py = y;
        x += 5;
        
        drawRect(px, py, states[lastState], Color.WHITE);
        drawImg(x, y, states[actualState], Color.DARK_GRAY, bulletImg);
        lastState = actualState;
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            actualState = 2;
        }
        if(x > 1000) actualState = 3;
    }

    private void executeCreate(){
        drawImg(x, y, states[actualState], Color.DARK_GRAY, bulletImg);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // No hace nada
        }
        actualState = 1;
    }

    private void executePause(){
        drawRect(x, y, states[lastState], Color.WHITE);
        drawImg(x, y, states[actualState], Color.DARK_GRAY, bulletImg);
        lastState = actualState;
        actualState = 1;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            if(kill) actualState = 3;
            else executeMovement();
        }
    }

    private void executeTerminated(){
        drawRect(x, y, states[lastState], Color.WHITE);
        drawImg(x, y, states[3], Color.DARK_GRAY, bulletImg);
        isAlive = false;
    }
}
