package p1_empiezaSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//Clase ManejadorEventos que actua como Controlador
public class ManejadorEventos implements ActionListener{
    //Caso de MiVentanaBorder, para que sea flow 
    //reemplazar por MiVentanaFlow
    MiVentanaFlow miVentana;

    //Constructores de el manejador
    public ManejadorEventos(){
        miVentana = new MiVentanaFlow();
    }

    public ManejadorEventos(MiVentanaFlow miVentana){
       this.miVentana = miVentana;
    }

    //Metodo de actionPerformed y listener
    @Override
    public void actionPerformed(ActionEvent e){ 
        JButton btnLlamada = (JButton) e.getSource();

        if(btnLlamada.getText().toString() == "Comprobar"){
            if(miVentana.txt1.getText().toString().equals("")
            && miVentana.txt2.getText().toString().equals("")
            && miVentana.txt3.getText().toString().equals("")
            && miVentana.txt4.getText().toString().equals(""))
                miVentana.etiqueta.setText("Campos vacios");
            else if(miVentana.txt1.getText().equals(miVentana.txt2.getText()) 
            && miVentana.txt3.getText().toString().equals("")
            && miVentana.txt4.getText().toString().equals(""))
                miVentana.etiqueta.setText("Texto 1 y 2 repetidos");
            else if(miVentana.txt1.getText().equals(miVentana.txt3.getText())
            && miVentana.txt2.getText().toString().equals("")
            && miVentana.txt4.getText().toString().equals(""))
                miVentana.etiqueta.setText("Texto 1 y 3 repetidos");
            else if(miVentana.txt1.getText().equals(miVentana.txt4.getText())
            && miVentana.txt2.getText().toString().equals("")
            && miVentana.txt3.getText().toString().equals(""))
                miVentana.etiqueta.setText("Texto 1 y 4 repetidos");
            else if(miVentana.txt2.getText().equals(miVentana.txt3.getText())
            && miVentana.txt1.getText().toString().equals("")
            && miVentana.txt4.getText().toString().equals(""))
                miVentana.etiqueta.setText("Texto 2 y 3 repetidos");
            else if(miVentana.txt2.getText().equals(miVentana.txt4.getText())
            && miVentana.txt1.getText().toString().equals("")
            && miVentana.txt3.getText().toString().equals(""))
                miVentana.etiqueta.setText("Texto 2 y 4 repetidos");
            else if(miVentana.txt3.getText().equals(miVentana.txt4.getText())
            && miVentana.txt1.getText().toString().equals("")
            && miVentana.txt2.getText().toString().equals(""))
                miVentana.etiqueta.setText("Texto 3 y 4 repetidos");
            else if (miVentana.txt1.getText().equals(miVentana.txt2.getText())
            && miVentana.txt2.getText().equals(miVentana.txt3.getText())
            && miVentana.txt4.getText() != miVentana.txt1.getText())
                miVentana.etiqueta.setText("Texto 1, 2 y 3 repetidos");
            else if (miVentana.txt2.getText().equals(miVentana.txt3.getText())
            && miVentana.txt3.getText().equals(miVentana.txt4.getText())
            && miVentana.txt1.getText() != miVentana.txt2.getText())
                    miVentana.etiqueta.setText("Texto 2, 3 y 4 repetidos");
            else if (miVentana.txt1.getText().equals(miVentana.txt3.getText())
            && miVentana.txt3.getText().equals(miVentana.txt4.getText())
            && miVentana.txt2.getText() != miVentana.txt1.getText())
                miVentana.etiqueta.setText("Texto 1, 3 y 4 repetidos");
            else if (miVentana.txt1.getText().equals(miVentana.txt2.getText())
            && miVentana.txt2.getText().equals(miVentana.txt4.getText())
            && miVentana.txt3.getText() != miVentana.txt1.getText())
                miVentana.etiqueta.setText("Texto 1, 2 y 4 repetidos");
            else if(miVentana.txt1.getText().equals(miVentana.txt2.getText()) 
            && miVentana.txt2.getText().equals(miVentana.txt3.getText())
            && miVentana.txt3.getText().equals(miVentana.txt4.getText()))
                miVentana.etiqueta.setText("Todos los textos 1, 2, 3, 4 repetidos");
            else if(miVentana.txt1.getText().equals(miVentana.txt2.getText()) 
            && miVentana.txt3.getText().equals(miVentana.txt4.getText()))
                miVentana.etiqueta.setText("Textos 1, 2 y 3, 4 repetidos");
            else if(miVentana.txt1.getText().equals(miVentana.txt3.getText()) 
            && miVentana.txt2.getText().equals(miVentana.txt4.getText()))
                miVentana.etiqueta.setText("Textos 1, 3 y 2, 4 repetidos");
            else if(miVentana.txt1.getText().equals(miVentana.txt4.getText()) 
            && miVentana.txt2.getText().equals(miVentana.txt3.getText()))
                miVentana.etiqueta.setText("Textos 1, 4 y 2, 3 repetidos");
            else 
                miVentana.etiqueta.setText("Textos no repetidos");
        }                
        
        else if(btnLlamada.getText().toString() == "Salir"){
            miVentana.setVisible(false);
            miVentana.dispose();
        }
        else
            miVentana.etiqueta.setText("Pulsar otro boton");
    }

}
