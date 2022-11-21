package p5_menusEjemplos;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class ManejadorVentanas implements ActionListener {
    VentanaVentanas ventana;
    Ventana ventanaV;
    JButton btnCall;
    Marco marcoV;
    Dialogo dialogoV;
    
    //Constructores de manejador
    public ManejadorVentanas(){
        this.ventana = new VentanaVentanas();            
    }        
    
    public ManejadorVentanas(VentanaVentanas ventana){
        this.ventana = ventana;
    }
    
    public void actionPerformed(ActionEvent e){ 
        btnCall = (JButton) e.getSource();
        if(btnCall.getText().equals(ventana.ventanaB.getText()))
            ventanaV = new Ventana(new Frame(), 200,200,200,150);            
        else if (btnCall.getText().equals(ventana.marcoB.getText()))
            marcoV = new Marco("Marco", 600, 200, 200, 150);
        else if (btnCall.getText().equals(ventana.dialogoB.getText())){
            dialogoV = new Dialogo
            (new Frame(),"Dialogo",true, 400, 200, 200, 150);
            dialogoV.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        }
    }
}
