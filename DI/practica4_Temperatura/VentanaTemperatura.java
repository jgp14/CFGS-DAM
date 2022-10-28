package practica4_Temperatura;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaTemperatura extends JFrame{
    //Declaracion de atributos
    Container cp;
    GridBagConstraints constraints;
    JTextField txtCelsius, txtFarenheit;
    JLabel labelNum1, labelNum2;;
    JButton botonProcesar;
    Font font1, font2;
    Temperatura temperatura = new Temperatura();
    //Constuctor de ventana
    public VentanaTemperatura() {
        super("Conversion de temperaturas");
        setSize(520, 220);
        cp = getContentPane();
        cp.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(24, 30, 20, 30);
        
        //Etiqueta de los grados Celsius
        labelNum1 = new JLabel("Grados centigrados: ");
        font1 = new Font(labelNum1.getFont().getFontName(), Font.BOLD, 14);
        labelNum1.setFont(font1);
        labelNum1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        constraints.gridx = 0; //El label empieza en la columna 0
        constraints.gridy = 0; //El label empieza en la fila cero
        constraints.gridwidth = 1; //El label ocupa 1 columna
        constraints.gridheight = 1; //El label ocupa 1 fila
        constraints.insets = new Insets(20, 30, 20, 0);
        //Definida su posicion, lo añadimos a ell
        cp.add(labelNum1, constraints);

        //Campo de texto de Celsius
        txtCelsius = new JTextField(String.valueOf(temperatura.getCelsius()));
        font2 = new Font(txtCelsius.getFont().getFontName(), Font.BOLD, 16);
        txtCelsius.setFont(font2);
        constraints.gridx = 1; 
        constraints.gridy = 0; 
        constraints.gridwidth = 2; 
        constraints.gridheight = 1; 
        constraints.weightx = 1.0;
        constraints.insets = new Insets(20, 0, 20, 20);
        cp.add(txtCelsius, constraints);

        //Etiqueta de los grados Farenheit
        labelNum2 = new JLabel("Grados Farenheit: ");
        labelNum2.setFont(font1);
        labelNum2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        constraints.gridx = 0; //El label empieza en la columna 0
        constraints.gridy = 1; //El label empieza en la fila cero
        constraints.gridwidth = 1; //El label ocupa 1 columna
        constraints.gridheight = 1; //El label ocupa 1 fila
        constraints.insets = new Insets(20, 30, 20, 0);
        //Definida su posicion, lo añadimos a ell
        cp.add(labelNum2, constraints);

        //Campo de texto de Farenheit
        txtFarenheit = new JTextField((String.valueOf(temperatura.getFarenheit())));
        txtFarenheit.setFont(font2);
        constraints.gridx = 1; 
        constraints.gridy = 1; 
        constraints.gridwidth = 2; 
        constraints.gridheight = 1; 
        constraints.weightx = 1.0;
        constraints.insets = new Insets(20, 0, 20, 20);
        cp.add(txtFarenheit, constraints);

        //Boton de procesar
        botonProcesar = new JButton("Aceptar");
        botonProcesar.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        constraints.gridx = 2; 
        constraints.gridy = 2; 
        constraints.gridwidth = 1; 
        constraints.gridheight = 2; 
        constraints.insets = new Insets(15, 30, 15, 20);
        cp.add(botonProcesar, constraints);

        //Ecuchador del boton
        botonProcesar.addActionListener(new ManejadorTemperatura(this));  
    }
    
}
