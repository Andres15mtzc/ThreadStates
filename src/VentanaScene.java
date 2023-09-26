
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaScene extends JFrame {
    VentanaScene(String name){
        this.setTitle(name);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(9,1));

        JButton btnPlay = new JButton("PLAY");

        //img
        JLabel imageLabel = new JLabel();

        ImageIcon imageIcon = new ImageIcon("./src/Assets/logo-UP_resize.png");
        imageLabel.setIcon(imageIcon);

        JLabel label0 = new JLabel("Universidad Panamericana Campus Guadalajara");
        JLabel label1 = new JLabel("Thread States");
        JLabel label2 = new JLabel("Profesor: Juan Carlos Lopez Pimentel");
        JLabel label3 = new JLabel("Alumnos:");
        JLabel label4 = new JLabel("-Andres Martinez - 0234500");
        JLabel label5 = new JLabel("-Sebastian Astiazaran - 0226403");
        JLabel label6 = new JLabel("Fundamentos de programacion en paralelo");
        JLabel label7 = new JLabel("Carrera: Ingenieria en Sistemas y Graficas Computacionales");



        btnPlay.addActionListener((e)->{
            // Thread using "implements"
            Ventana play = new Ventana();
            Thread t = new Thread(play);
            t.start();
        });

        panel.add(imageLabel);
        setLayout(new FlowLayout());
        panel.add(label0);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(btnPlay);

        this.add(panel, BorderLayout.CENTER);
        this.add(btnPlay, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
