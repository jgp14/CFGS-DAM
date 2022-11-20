package p2_interfaceFrase;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

public class VentanaFrase extends JFrame{
    private Container cp;
    private GridBagConstraints gbc;
    JTextField textoFrase, textoLetras, textoPalabras;
    JButton botonProcesar;
    private JLabel labelFrase, labelNum1, labelNum2;
    Font font1, font2;

    public VentanaFrase(){
        super("EJERCICIO 2");
        setSize(570, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(20, 30, 20, 30);
        //Vamos creando cada componente y añadiendolo en las posiciones 
        labelFrase();
        textoFrase();
        botonProcesar();
        labelNum1();
        labelNum2();
        textoLetras();
        textoPalabras();
        botonProcesar.addActionListener(new ManejadorFrase(this));   
    }
    
    private void labelFrase(){
        labelFrase = new JLabel("Introduce una frase: ");
        font1 = new Font
        (labelFrase.getFont().getFontName(), Font.BOLD, 16);
        labelFrase.setFont(font1);
        labelFrase.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(20, 30, 20, 0);
        cp.add(labelFrase, gbc);
    }
    
    private void textoFrase(){
        textoFrase = new JTextField("", 30);
        textoFrase.setFont(font1);
        textoFrase.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        gbc.gridx = 1; 
        gbc.gridy = 0; 
        gbc.gridwidth = 3; 
        gbc.gridheight = 1; 
        gbc.weightx = 1.0;
        gbc.insets = new Insets(20, 0, 20, 30);
        cp.add(textoFrase, gbc);
    }
    
    private void botonProcesar(){
        botonProcesar = new JButton("Procesar frase");
        botonProcesar.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        gbc.gridx = 0; 
        gbc.gridy = 1; 
        gbc.gridwidth = 1; 
        gbc.gridheight = 2; 
        gbc.insets = new Insets(24, 30, 20, 20);
        cp.add(botonProcesar, gbc);
    }
    
    private void labelNum1(){
        labelNum1 = new JLabel("Número de letras: ");
        font2 = new Font
        (labelFrase.getFont().getFontName(), Font.BOLD, 14);
        labelNum1.setFont(font2);
        labelNum1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(20, 0, 15, 0);
        cp.add(labelNum1, gbc);
    }
    
    private void labelNum2(){
        labelNum2 = new JLabel("Número de palabras: ");
        labelNum2.setFont(font2);
        labelNum2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1; 
        gbc.insets = new Insets(20, 0, 15, 0);
        cp.add(labelNum2, gbc);
    }
    
    private void textoLetras(){
        textoLetras = new JTextField("0", 30);
        textoLetras.setEditable(false);
        textoLetras.setFont(font2);
        textoLetras.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        gbc.gridx = 2; 
        gbc.gridy = 1; 
        gbc.gridwidth = 2; 
        gbc.gridheight = 1; 
        gbc.weightx = 1.0;
        gbc.insets = new Insets(20, 0, 15, 30);
        cp.add(textoLetras, gbc);
    }
    
    private void textoPalabras(){
        textoPalabras = new JTextField("0", 30);
        textoPalabras.setEditable(false);
        textoPalabras.setFont(font2);
        textoPalabras.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        gbc.gridx = 2; 
        gbc.gridy = 2; 
        gbc.gridwidth = 2; 
        gbc.gridheight = 1; 
        gbc.weightx = 1.0;
        gbc.insets = new Insets(15, 0, 20, 30);
        cp.add(textoPalabras, gbc);
    }
    
}
