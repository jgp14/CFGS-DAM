package p5_menus;

import java.awt.*;
import javax.swing.*;

public class VentanaMenu extends JFrame {
    //Declaramos los atributos
    Container cp;
    JMenuBar barraMenu;
    JMenu menu1, menu2, color, letra;
    JMenuItem nuevo, acerca, salir; 
    JRadioButtonMenuItem negro, azul, rojo, verde, 
    serif, mono, sansSerif;
    ButtonGroup bg1, bg2;
    JCheckBoxMenuItem negrita, cursiva;
    JLabel texto;
    Font font;

    public VentanaMenu() {
        //Creamos el contenedor
        super("Uso de objetos JMenu");
        setSize(700, 300);
        cp = getContentPane();
        cp.setLayout(new GridBagLayout());

        //Creamos botones del menu1
        nuevo = new JMenuItem("Nuevo");
        acerca = new JMenuItem("Acerca de...");
        salir = new JMenuItem("Salir");

        //Creamos el menu1
        menu1 = new JMenu("Archivo");
        menu1.add(nuevo);
        menu1.add(acerca);
        menu1.add(salir);

        //Creamos los elementos del submenu color 
        negro = new JRadioButtonMenuItem("negro");
        azul = new JRadioButtonMenuItem("azul");
        rojo = new JRadioButtonMenuItem("rojo");
        verde = new JRadioButtonMenuItem("verde");

        //Añadimos los elementos al grupo de botones
        bg1 = new ButtonGroup();
        bg1.add(negro);
        bg1.add(azul);
        bg1.add(rojo);
        bg1.add(verde);

        //Creamos submenu Color y añadimos elementos 
        color = new JMenu("Color");
        color.add(negro);
        color.add(azul);
        color.add(rojo);
        color.add(verde);
        
        //Creamos los elementos del submenu letra 
        serif = new JRadioButtonMenuItem("serif");
        mono = new JRadioButtonMenuItem("mono");
        sansSerif = new JRadioButtonMenuItem("sansSerif");
        
        //Añadimos los elementos al grupo de letras
        bg2 = new ButtonGroup();
        bg2.add(serif);
        bg2.add(mono);
        bg2.add(sansSerif);

        //Creamos los botones check de estilo de letra
        negrita = new JCheckBoxMenuItem("Negrita");
        cursiva = new JCheckBoxMenuItem("Cursiva");

        //Creamos el submenu letra
        letra = new JMenu("Tipo de letra");
        letra.add(serif);
        letra.add(mono);
        letra.add(sansSerif);
        letra.addSeparator();
        letra.add(negrita);
        letra.add(cursiva);

        //Creamos el menu2 y añadimos los submenus
        menu2 = new JMenu("Formato");
        menu2.add(color);
        menu2.addSeparator();
        menu2.add(letra);

        //Creamos la barra de menus y la añadimos
        barraMenu = new JMenuBar();
        barraMenu.add(menu1);
        barraMenu.add(menu2);
        setJMenuBar(barraMenu);

        texto = new JLabel("Texto de ejemplo");
        font = new Font(Font.SERIF, Font.PLAIN, 74);
        texto.setFont(font);
        
        cp.add(texto);
        cp.setBackground(Color.CYAN);
        
        //Estableemos los escuchadores
        nuevo.addActionListener(new ManejadorMenu(this));
        salir.addActionListener(new ManejadorMenu(this));
        negrita.addItemListener(new ManejadorMenu(this));
        cursiva.addItemListener(new ManejadorMenu(this));
        negro.addActionListener(new ManejadorMenu(this));
        azul.addActionListener(new ManejadorMenu(this));
        rojo.addActionListener(new ManejadorMenu(this));
        verde.addActionListener(new ManejadorMenu(this));
        serif.addActionListener(new ManejadorMenu(this));
        mono.addActionListener(new ManejadorMenu(this));
        sansSerif.addActionListener(new ManejadorMenu(this));
    }
    
}