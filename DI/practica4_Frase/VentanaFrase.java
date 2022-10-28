package practica4_Frase;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.text.JTextComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaFrase extends JFrame{
    JTextField textoFrase, textoLetras, textoPalabras;
    JButton botonProcesar;
    JLabel labelFrase, labelNum1, labelNum2;
    Font font1, font2;

    public VentanaFrase(){
        super("EJERCICIO 2");
        setSize(570, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(20, 30, 20, 30);
        //Vamos creando cada componente y añadiendolo en la posicion correcta
        
        //Elementos de la fila 1:
        labelFrase = new JLabel("Introduce una frase: ");
        font1 = new Font(labelFrase.getFont().getFontName(), Font.BOLD, 16);
        labelFrase.setFont(font1);
        labelFrase.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        gbc.gridx = 0; //El label empieza en la columna 0
        gbc.gridy = 0; //El label empieza en la fila cero
        gbc.gridwidth = 1; //El label ocupa 1 columna
        gbc.gridheight = 1; //El label ocupa 1 fila
        gbc.insets = new Insets(20, 30, 20, 0);
        //Definida su posicion, lo añadimos a ell
        cp.add(labelFrase, gbc);

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

        botonProcesar = new JButton("Procesar frase");
        botonProcesar.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        gbc.gridx = 0; 
        gbc.gridy = 1; 
        gbc.gridwidth = 1; 
        gbc.gridheight = 2; 
        gbc.insets = new Insets(24, 30, 20, 20);
        cp.add(botonProcesar, gbc);

        labelNum1 = new JLabel("Número de letras: ");
        font2 = new Font(labelFrase.getFont().getFontName(), Font.BOLD, 14);
        labelNum1.setFont(font2);
        labelNum1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        gbc.gridx = 1; //El label empieza en la columna 0
        gbc.gridy = 1; //El label empieza en la fila cero
        gbc.gridwidth = 1; //El label ocupa 1 columna
        gbc.gridheight = 1; //El label ocupa 1 fila
        gbc.insets = new Insets(20, 0, 15, 0);
        //Definida su posicion, lo añadimos a ell
        cp.add(labelNum1, gbc);

        labelNum2 = new JLabel("Número de palabras: ");
        labelNum2.setFont(font2);
        labelNum2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        gbc.gridx = 1; //El label empieza en la columna 0
        gbc.gridy = 2; //El label empieza en la fila cero
        gbc.gridwidth = 1; //El label ocupa 1 columna
        gbc.gridheight = 1; //El label ocupa 1 fila
        gbc.insets = new Insets(20, 0, 15, 0);
        //Definida su posicion, lo añadimos a ell
        cp.add(labelNum2, gbc);

        
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

        botonProcesar.addActionListener(new ManejadorFrase(this));   
        
    }
}
