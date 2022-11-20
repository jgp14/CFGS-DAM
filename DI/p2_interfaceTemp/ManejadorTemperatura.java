package p2_interfaceTemp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManejadorTemperatura implements ActionListener{
    VentanaTemperatura ventana;//Creacion de atributos de la ventana
    JButton btnLlamada;
    Float celsius, farenheit, f;
    String celsiusString, farenheitString;

    public ManejadorTemperatura(){//Constructores Manejador Temperatura
        this.ventana = new VentanaTemperatura();
    }

    public ManejadorTemperatura(VentanaTemperatura ventanaTemperatura){
        this.ventana = ventanaTemperatura;
    }

    public void actionPerformed(ActionEvent e){ //Metodo de actionPerformence
        //Atributos del metodo
        btnLlamada = (JButton) e.getSource();
        //el if es opcional pero se pone por si hay que poner mas botones
        if(String.valueOf(btnLlamada.getText()).equals("Aceptar")){
            obtenerValoresTemperatura();
            //Si los celsius o farenheit estan por debajo del cero absoluto
            if(farenheit < -459.67f || celsius < -273.15f){
                ventana.txtCelsius.setText("0.0");
                ventana.txtFarenheit.setText("32.0");
            }
            //Celsius almacenados son distintos al valor de celsius del campo
            else if(!celsius.equals(ventana.temperatura.getCelsius()))
                introducirCelsius();
            //Farenheit almacenados son distintos al valor de farenheit del campo
            else if(!farenheit.equals(ventana.temperatura.getFarenheit()))
                introducirFarenheit();
            else{   //Poner los valores por defecto
                ventana.txtCelsius.setText("0.0");
                ventana.txtFarenheit.setText("32.0");
            }
        }
    }
    
    private void obtenerValoresTemperatura(){ //valores de los campos
        celsiusString = ventana.txtCelsius.getText().toString();
        farenheitString = ventana.txtFarenheit.getText().toString();
        celsius = convertStringFloat(celsiusString);
        farenheit = convertStringFloat(farenheitString);
    }
    
    private void introducirCelsius(){ //meter celsius
        celsius = convertStringFloat(celsiusString);
        ventana.temperatura.setCelsius(celsius);
        ventana.temperatura.calcFarenheitFromCelsius(celsius);
        farenheit = ventana.temperatura.getFarenheit();
        ventana.txtFarenheit.setText(String.valueOf(farenheit));
    }
    
    private void introducirFarenheit(){ //meter farenheit
        farenheit = convertStringFloat(farenheitString);
        ventana.temperatura.setFarenheit(farenheit);
        ventana.temperatura.calcCelsiusFromFarentheit(farenheit);
        celsius = ventana.temperatura.getCelsius();              
        ventana.txtCelsius.setText(String.valueOf(celsius));
    }
    
    //Metodo para convertir un String a un valor Double
    private float convertStringFloat(String s){
        f = 0.0f;
        try{
            f = Float.parseFloat(s);
        } catch(NumberFormatException ex) {
            f = 0.0f; //Manejo de exepcion
            ventana.txtCelsius.setText(String.valueOf(f));
            ventana.txtFarenheit.setText(String.valueOf(f));
        } return f;
    }
    
}
