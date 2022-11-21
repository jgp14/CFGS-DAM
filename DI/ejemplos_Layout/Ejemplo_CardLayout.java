package ejemplos_Layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejemplo_CardLayout extends JFrame{
    public static void main(String[] args){
        Ejemplo_CardLayout frame = new Ejemplo_CardLayout();
        Container miContenedor = frame.getContentPane();
        JButton siguiente = new JButton("Siguiente");
        miContenedor.add(siguiente, BorderLayout.NORTH);
        JLabel label1= new JLabel("Componente 1");
        JLabel label2= new JLabel("Componente 2");
        JLabel label3= new JLabel("Componente 3");
        JLabel label4= new JLabel("Componente 4");
        final JPanel miPanel= new JPanel();
        final CardLayout layout=new CardLayout();
        miPanel.setLayout(layout);
        miPanel.add(label1,"1");
        miPanel.add(label2,"2");
        miPanel.add(label3,"3");
        miPanel.add(label4,"4");
        miContenedor.add(miPanel,BorderLayout.CENTER);
        siguiente.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.next(miPanel);
            }
        });
        frame.setSize(350,150);
        frame.setTitle("Prueba de CardLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
