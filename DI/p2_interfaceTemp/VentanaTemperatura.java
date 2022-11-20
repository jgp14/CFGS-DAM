package p2_interfaceTemp;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

public class VentanaTemperatura extends JFrame{
    private Container cp;//Declaracion de atributos
    private GridBagConstraints gbc;
    JTextField txtCelsius, txtFarenheit;
    private JLabel labelNum1, labelNum2;;
    JButton botonProcesar;
    private Font font1, font2;
    Temperatura temperatura = new Temperatura();

    public VentanaTemperatura() {//Constuctor de ventana
        super("Conversion de temperaturas");
        setSize(520, 220);
        cp = getContentPane();
        cp.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(24, 30, 20, 30);
        labelNum1();
        txtCelsius();
        labelNum2();
        txtFarenheit();
        botonProcesar();
        //Ecuchador del boton
        botonProcesar.addActionListener
        (new ManejadorTemperatura(this));  
    }
    
    private void labelNum1(){//Etiqueta de los grados Celsius
        labelNum1 = new JLabel("Grados centigrados: ");
        font1 = new Font
        (labelNum1.getFont().getFontName(), Font.BOLD, 14);
        labelNum1.setFont(font1);
        labelNum1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        gbc.gridx = 0; //El label empieza en la columna 0
        gbc.gridy = 0; //El label empieza en la fila cero
        gbc.gridwidth = 1; //El label ocupa 1 columna
        gbc.gridheight = 1; //El label ocupa 1 fila
        gbc.insets = new Insets(20, 30, 20, 0);
        //Definida su posicion, lo añadimos a ell
        cp.add(labelNum1, gbc);
    }
    
    private void txtCelsius(){//Campo de texto de Celsius
        txtCelsius = new JTextField
        (String.valueOf(temperatura.getCelsius()));
        font2 = new Font
        (txtCelsius.getFont().getFontName(), Font.BOLD, 16);
        txtCelsius.setFont(font2);
        gbc.gridx = 1; 
        gbc.gridy = 0; 
        gbc.gridwidth = 2; 
        gbc.gridheight = 1; 
        gbc.weightx = 1.0;
        gbc.insets = new Insets(20, 0, 20, 20);
        cp.add(txtCelsius, gbc);
    }
    
    private void labelNum2(){//Etiqueta de los grados Farenheit
        labelNum2 = new JLabel("Grados Farenheit: ");
        labelNum2.setFont(font1);
        labelNum2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        gbc.gridx = 0; //El label empieza en la columna 0
        gbc.gridy = 1; //El label empieza en la fila cero
        gbc.gridwidth = 1; //El label ocupa 1 columna
        gbc.gridheight = 1; //El label ocupa 1 fila
        gbc.insets = new Insets(20, 30, 20, 0);
        //Definida su posicion, lo añadimos a ell
        cp.add(labelNum2, gbc);
    }
    
    private void txtFarenheit(){//Campo de texto de Farenheit
        txtFarenheit = new JTextField
        ((String.valueOf(temperatura.getFarenheit())));
        txtFarenheit.setFont(font2);
        gbc.gridx = 1; 
        gbc.gridy = 1; 
        gbc.gridwidth = 2; 
        gbc.gridheight = 1; 
        gbc.weightx = 1.0;
        gbc.insets = new Insets(20, 0, 20, 20);
        cp.add(txtFarenheit, gbc);
    }
    
    private void botonProcesar(){//Boton de procesar
        botonProcesar = new JButton("Aceptar");
        botonProcesar.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        gbc.gridx = 2; 
        gbc.gridy = 2; 
        gbc.gridwidth = 1; 
        gbc.gridheight = 2; 
        gbc.insets = new Insets(15, 30, 15, 20);
        cp.add(botonProcesar, gbc);
    }
}
