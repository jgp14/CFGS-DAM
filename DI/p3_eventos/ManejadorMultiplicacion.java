package p3_eventos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ManejadorMultiplicacion
    implements ItemListener, ActionListener, KeyListener {
    //Declaracion y establecer valores de atributos
    VentanaMultiplicacion ventana;
    JButton btnLlamada;
    JComboBox comboBox;
    private int nMulti = 0;
    private int numero1 = 0;
    private int numero2 = 0; 
    private int resultado = 0; 
    private String numero1String = "";
    private String numero2String = "";
    private String space = "          ";

    //Constructores manejadores
    public ManejadorMultiplicacion(){
        this.ventana = new VentanaMultiplicacion();            
    }        
    
    public ManejadorMultiplicacion(VentanaMultiplicacion ventana){
        this.ventana = ventana;
    }

    //Metodo para convertir el campo de texto en numero entero
    private int convertStringInt(String s){
        int i = 0;
        try{
            i = Integer.parseInt(s);
        } catch(NumberFormatException ex) {
            i = 0; //Manejo de exepcion
            ventana.numberField1.setText(String.valueOf(i));
            ventana.numberField2.setText(String.valueOf(i));
        }
        return i;
    }

    //Escuchador de actionPerformed al clicar el boton Sumar
    public void actionPerformed (ActionEvent e) {
        btnLlamada = (JButton) e.getSource();        
        if(String.valueOf(btnLlamada.getText()).equals(space+"Sumar"+space)){
            numero1String = ventana.numberField1.getText().toString();
            numero2String = ventana.numberField2.getText().toString();
            if(numero1String.equals("") 
                    || numero2String.equals("")){
                ventana.numberField1.setText("");
                ventana.numberField2.setText("");
                ventana.resultField.setText("");
            }
            else{
                numero1 = convertStringInt(numero1String);
                numero2 = convertStringInt(numero2String);
                ventana.multi.setnSuma1(numero1);
                ventana.multi.setnSuma2(numero2);
                resultado = ventana.multi.sumar();
                ventana.resultField.setText(String.valueOf(resultado));
            }  
        } 
    }    

    //Escuchador al presionar la tecla enter en el campo de texto 2
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_ENTER){
            numero1String = ventana.numberField1.getText().toString();
            numero2String = ventana.numberField2.getText().toString();
            if(numero1String.equals("") 
                    || numero2String.equals("")){
                ventana.numberField1.setText("");
                ventana.numberField2.setText("");
                ventana.resultField.setText("");
            }
            else{
                numero1 = convertStringInt(numero1String);
                numero2 = convertStringInt(numero2String);
                ventana.multi.setnSuma1(numero1);
                ventana.multi.setnSuma2(numero2);
                resultado = ventana.multi.sumar();
                ventana.resultField.setText(String.valueOf(resultado));
            }  
        }    		
    }
    //Obligarorio poner todos los metodos de la interface
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e) {}

    //Escuchador de itemStateChanged del comboBox
    public void itemStateChanged(ItemEvent e) {
        comboBox = (JComboBox) e.getSource();
        nMulti = comboBox.getSelectedIndex();        
        ventana.multi.setnMulti(nMulti);
        for(int i = 0; i < ventana.botones.length; i++)
            ventana.botones[i].setText
            (String.valueOf(ventana.multi.multi(i)));
    }

}
