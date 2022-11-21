package ejemplos_Layout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class EventoBotonPulsado implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        boton.setText("¡Gracias!");
    }
}