package practica3_Eventos;

//Importamos los paquetes
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.Socket;

//Creacion de ventanaMultiplicacion modelo
public class VentanaMultiplicacion extends JFrame {
    //Declaracion de atributos, algunos privados.
    private Container cp;
    private GridBagConstraints gbc;
    private JPanel panel1, panel2, panel3;
    private JLabel title, number1, number2, result, subpro1, subpro2;
    JTextField numberField1, numberField2, resultField;
    private Integer[] numeros = {0,1,2,3,4,5,6,7,8,9};
    private JComboBox comboBox;
    JButton buttonTable, botonSuma;
    JButton[] botones = new JButton[10];
    private Font font1, font2, fontButton, fontComboBox;
    private String space1, space2;
    Multiplicacion multi = new Multiplicacion();

    //Constructor de la ventana
    public VentanaMultiplicacion(){
        //Container de tipo BorderLayout
        super("AppletViewer: interfaz_tabla_multiplicar.class");
        setSize(610, 900);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());

        //Panel1 con GridLayout, establecer filas, etiquetas
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3,1));
        subpro1 = new JLabel("Subprograma", SwingConstants.LEFT);
        title = new JLabel("Tabla de Multiplicar", SwingConstants.CENTER);
        font1 = new Font(title.getFont().getFontName(), Font.BOLD, 30);
        title.setFont(font1);
        title.setAlignmentX(JFrame.CENTER_ALIGNMENT);
        
        //Nuevo comboBox con una lista de numeros, con color y fuente
        comboBox = new JComboBox<>(numeros);
        fontComboBox = new Font
        (comboBox.getFont().getFontName(), Font.BOLD, 24);
        comboBox.setFont(fontComboBox);
        comboBox.setMaximumRowCount(10);
        comboBox.setForeground(Color.BLACK);
        comboBox.setBackground(Color.WHITE);
        panel1.add(subpro1);
        panel1.add(title);
        panel1.add(comboBox);        

        //Panel2 con GridLayout con bordes
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(10,3,18,18));
        panel2.setBorder(new EmptyBorder(16,16,16,16));
        space1 = "           ";

        //Generamos los botones con bucles y matriz botones[]
        int X =10; int Y= 3;
        for (int i=0;i<X;i++){
            for (int j=0; j<Y;j++){
                if(j == 0){
                    buttonTable = new JButton(space1+i+space1);
                    fontButton = new Font
                    (buttonTable.getFont().getFontName(), Font.BOLD, 17);
                    buttonTable.setFont(fontButton);
                    panel2.add(buttonTable);
                }
                else if (j == 1){
                    buttonTable = new JButton(space1+"="+space1);
                    buttonTable.setFont(fontButton);
                    panel2.add(buttonTable);
                }
                else {
                    botones[i] =  new JButton(space1+" "+space1);
                    botones[i].setFont(fontButton);
                    panel2.add(botones[i]);
                }                
            }
        }

        //Panel3 con GridBagLayout
        panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        //Creacion de etiqueta numero1 y datos
        number1 = new JLabel("Numero1:", SwingConstants.CENTER);
        font2 = new Font(number1.getFont().getFontName(), Font.BOLD, 16);
        number1.setFont(font2);
        number1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        gbc.gridwidth = 1; 
        gbc.gridheight = 1; 
        gbc.insets = new Insets(10, 0, 10, 12);
        panel3.add(number1, gbc);

        //Creacion de campo texto numero1 y datos
        numberField1 = new JTextField(12);
        numberField1.setFont(font2);
        gbc.gridx = 1; 
        gbc.gridy = 0;  
        panel3.add(numberField1, gbc);

        //Creacion de etiqueta numero2 y datos
        number2 = new JLabel("Numero2:", SwingConstants.CENTER);
        number2.setFont(font2);
        number2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        gbc.gridx = 0; 
        gbc.gridy = 1; 
        panel3.add(number2, gbc);

        //Creacion de campo texto numero2 y datos
        numberField2 = new JTextField(10);
        numberField2.setFont(font2);
        gbc.gridx = 1; 
        gbc.gridy = 1; 
        panel3.add(numberField2, gbc);

        //Creacion de etiqueta resultado y datos
        result = new JLabel("Resultado", SwingConstants.CENTER);
        result.setFont(font2);
        gbc.gridx = 0; 
        gbc.gridy = 2;  
        gbc.insets = new Insets(10, 0, 30, 12);
        panel3.add(result, gbc);

        //Creacion de campo texto resultado y datos
        resultField = new JTextField(12);
        resultField.setFont(font2);
        gbc.gridx = 1; 
        gbc.gridy = 2; 
        panel3.add(resultField, gbc);

        //Creacion de JButton Sumar y datos
        space2 = "          ";
        botonSuma = new JButton
        (space2+"Sumar"+space2);
        botonSuma.setFont(font2);
        gbc.gridx = 2; 
        gbc.gridy = 0; 
        gbc.gridwidth = 2; 
        gbc.gridheight = 4; 
        gbc.insets = new Insets(10, 10, 44, 16);
        panel3.add(botonSuma, gbc);

        //Creacion de etiqueta subprograma iniciado y datos
        subpro2 = new JLabel("Subprograma iniciado", SwingConstants.LEFT);
        gbc.gridx = 0; 
        gbc.gridy = 3; 
        gbc.gridwidth = 1; 
        gbc.gridheight = 1; 
        gbc.insets = new Insets(0, 0, 0, 0);
        panel3.add(subpro2, gbc);

        //Añadir los paneles al contenedor
        cp.add(panel1, BorderLayout.NORTH);
        cp.add(panel2, BorderLayout.CENTER);
        cp.add(panel3, BorderLayout.SOUTH);

        //Enlace de los escuchadores
        comboBox.addItemListener(new ManejadorMultiplicacion(this));
        botonSuma.addActionListener(new ManejadorMultiplicacion(this));        
        numberField2.addKeyListener(new ManejadorMultiplicacion(this));
    }
}