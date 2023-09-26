import javax.swing.JFrame;

public class Ventana extends JFrame implements Runnable{
    private void crearVentana(String name){
        this.setTitle(name);
        this.setSize(1200, 350);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        MyCanvas myC = new MyCanvas();
        this.add(myC);
        this.setVisible(true);
    }

    @Override
    public void run() {
        crearVentana("Canyon");
    }
}
