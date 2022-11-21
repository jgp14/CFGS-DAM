package p5_menusEjemplos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class InternalVentana {
    /* Main View */
    public static void main(String[] a) {
        final JFrame jf = 
        new JFrame("Demostracion Ventana Interna");
        Dimension screenSize = 
        Toolkit.getDefaultToolkit().getScreenSize();
        screenSize.width -= 42;
        screenSize.height -= 42;
        jf.setSize(screenSize);
        jf.setLocation(20, 20);

        JMenuBar mb = new JMenuBar();
        jf.setJMenuBar(mb);
        JMenu fm = new JMenu("Archivo");
        mb.add(fm);
        JMenuItem mi;
        fm.add(mi = new JMenuItem("Salir"));

        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JDesktopPane dtp = new JDesktopPane();
        jf.setContentPane(dtp);

        JInternalFrame mboxFrame = 
        new JInternalFrame("Correo", true,
        true, true, true);
        JLabel reader = new JLabel("LeerCorreo");
        mboxFrame.setContentPane(reader);
        mboxFrame.setSize(400, 300);
        mboxFrame.setLocation(50, 50);
        mboxFrame.setVisible(true);
        dtp.add(mboxFrame);

        JInternalFrame compFrame = 
        new JInternalFrame("Crear Correo", true,
        true, true, true);
        JLabel composer = new JLabel("Debe crear correo aqui");
        compFrame.setContentPane(composer);
        compFrame.setSize(300, 200);
        compFrame.setLocation(200, 200);
        compFrame.setVisible(true);
        dtp.add(compFrame);

        JInternalFrame listFrame = 
        new JInternalFrame
        ("Usuarios", true, true, true,
        true);
        JLabel list = new JLabel("Lista de usuarios");
        listFrame.setContentPane(list);
        listFrame.setLocation(400, 400);
        listFrame.setSize(500, 200);
        listFrame.setVisible(true);
        dtp.add(listFrame);
        
        jf.setVisible(true);
        jf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                jf.setVisible(false);
                jf.dispose();
                System.exit(0);
            }
        });
    }

}