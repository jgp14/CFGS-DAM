package p5_menus;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ManejadorMenu implements ActionListener, ItemListener{
    VentanaMenu ventana;
    JMenuItem item;
    JCheckBoxMenuItem checkItem;
    JRadioButtonMenuItem btnCall;
    Font fOrigen, fserif, fmono, fsansSerif;

    //Constructores del Manejador  sin y con parametros
    public ManejadorMenu(){
        this.ventana = new VentanaMenu();
    }

    public ManejadorMenu(VentanaMenu ventana){
        this.ventana = ventana;
    }
    
    public void actionPerformed(ActionEvent e){ 
        item = (JMenuItem) e.getSource();
        fOrigen = ventana.texto.getFont();
        fserif = new Font(Font.SERIF, fOrigen.getStyle(), fOrigen.getSize());
        fmono = new Font(Font.MONOSPACED, fOrigen.getStyle(), fOrigen.getSize());
        fsansSerif = new Font(Font.SANS_SERIF, fOrigen.getStyle(), fOrigen.getSize());

        if(item.getText().equals("Nuevo")){        
            JDesktopPane dtp = new JDesktopPane();
            ventana.setContentPane(dtp);
            JInternalFrame compFrame = 
            new JInternalFrame(ventana.getTitle(), true,
            true, true, true);
            JLabel composer = new JLabel("Debe crear correo aqui");
            compFrame.setContentPane(ventana.cp);
            compFrame.setSize(640, 200);
            compFrame.setLocation(40, 40);
            compFrame.setVisible(true);
            dtp.add(compFrame);
        }
        else if(item.getText().equals("Salir"))
           System.exit(0);                
        if(ventana.negro.isSelected())        
            ventana.texto.setForeground(Color.BLACK);
        else if(ventana.azul.isSelected())
            ventana.texto.setForeground(Color.BLUE);
        else if(ventana.rojo.isSelected())
            ventana.texto.setForeground(Color.RED);
        else if(ventana.verde.isSelected())
            ventana.texto.setForeground(Color.GREEN);
            
        if(ventana.serif.isSelected())
            ventana.texto.setFont(fserif);
        else if(ventana.mono.isSelected())
            ventana.texto.setFont(fmono);
        else if(ventana.sansSerif.isSelected())
            ventana.texto.setFont(fsansSerif);
        

    }
    
    public void itemStateChanged(ItemEvent e){
        checkItem = (JCheckBoxMenuItem) e.getSource();
        fOrigen = ventana.texto.getFont();
        
        if(String.valueOf(checkItem.getText()).equals("Negrita")){
            if(ventana.negrita.isSelected())
                ventana.texto.setFont(fOrigen.deriveFont(Font.BOLD));
            else if(!ventana.negrita.isSelected() && !ventana.cursiva.isSelected())
                ventana.texto.setFont(fOrigen.deriveFont(Font.PLAIN));
            else ventana.texto.setFont(fOrigen);
        }

        else if(String.valueOf(checkItem.getText()).equals("Cursiva")){
            if(ventana.cursiva.isSelected())
                ventana.texto.setFont(fOrigen.deriveFont(Font.ITALIC));
            else if(!ventana.cursiva.isSelected() && !ventana.negrita.isSelected())
                ventana.texto.setFont(fOrigen.deriveFont(Font.PLAIN));
            else ventana.texto.setFont(fOrigen);
        }
            
    }
    
    private void ventanaInterna(){
        
    }

}
