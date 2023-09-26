import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyCanvas extends Canvas implements MouseListener{
    private Graphics gAll;
    Thread t;
    Canyonball canyonball;
    boolean shooted = false;

    MyCanvas(){
        this.setBackground(Color.WHITE);
        this.addMouseListener(this);
    }
    @Override
    public void paint(Graphics g){
        gAll = g.create();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == 1){
            if(shooted == false){
                canyonball = new Canyonball(110, 100, gAll);
                canyonball.start();
                shooted = true;
            }else{
                canyonball.kill = false;
                canyonball.interrupt();
            }
        }else if(e.getButton() == 3 && shooted == true){
            canyonball.kill = true;
            canyonball.interrupt();
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    
}
