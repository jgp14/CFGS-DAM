package practica4_Temperatura;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManejadorTemperatura implements ActionListener{
    //Creacion de atributos de la ventana
    VentanaTemperatura ventanaTemperatura;
    JButton btnLlamada;
    Float celsius, farenheit, f;
    String celsiusString, farenheitString;

    //Constructores del Manejador de Temperatura sin y con parametros
    public ManejadorTemperatura(){
        this.ventanaTemperatura = new VentanaTemperatura();
    }

    public ManejadorTemperatura(VentanaTemperatura ventanaTemperatura){
        this.ventanaTemperatura = ventanaTemperatura;
    }

    //Metodo para convertir un String a un valor Double
    private float convertStringFloat(String s){
        f = 0.0f;
        try{
            f = Float.parseFloat(s);
        } catch(NumberFormatException ex) {
            f = 0.0f; //Manejo de exepcion
            ventanaTemperatura.txtCelsius.setText(String.valueOf(f));
            ventanaTemperatura.txtFarenheit.setText(String.valueOf(f));
        }
        return f;
    }

    //Metodo de actionPerformence o listener
    public void actionPerformed(ActionEvent e){ 
        //Atributos del metodo
        btnLlamada = (JButton) e.getSource();
        celsius = 0.0f; 
        farenheit = 0.0f;
        celsiusString = ""; 
        farenheitString = "";
        //el if es opcional pero se pone por si hay que poner mas botones
        if(String.valueOf(btnLlamada.getText()).equals("Aceptar")){
            celsiusString = ventanaTemperatura.txtCelsius.getText().toString();
            farenheitString = ventanaTemperatura.txtFarenheit.getText().toString();
            celsius = convertStringFloat(celsiusString);
            farenheit = convertStringFloat(farenheitString);
            //Si los celsius o farenheit estan por debajo del cero absoluto
            if(farenheit < -459.67f || celsius < -273.15f){
                ventanaTemperatura.txtCelsius.setText("0.0");
                ventanaTemperatura.txtFarenheit.setText("32.0");
            }
            //Si los celsius almacenados son distintos al valor de celsius del campo
            else if(!celsius.equals(ventanaTemperatura.temperatura.getCelsius())){
                celsius = convertStringFloat(celsiusString);
                ventanaTemperatura.temperatura.setCelsius(celsius);
                ventanaTemperatura.temperatura.calcFarenheitFromCelsius(celsius);
                farenheit = ventanaTemperatura.temperatura.getFarenheit();
                ventanaTemperatura.txtFarenheit.setText(String.valueOf(farenheit));
            }
            //Si los farenheit almacenados son distintos al valor de farenheit del campo
            else if(!farenheit.equals(ventanaTemperatura.temperatura.getFarenheit())){
                farenheit = convertStringFloat(farenheitString);
                ventanaTemperatura.temperatura.setFarenheit(farenheit);
                ventanaTemperatura.temperatura.calcCelsiusFromFarentheit(farenheit);
                celsius = ventanaTemperatura.temperatura.getCelsius();              
                ventanaTemperatura.txtCelsius.setText(String.valueOf(celsius));
            }
            else{   //Poner los valores por defecto
                ventanaTemperatura.txtCelsius.setText("0.0");
                ventanaTemperatura.txtFarenheit.setText("32.0");
            }
        }
    }
    
}
