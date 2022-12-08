package p6_repasoCartas;

import java.awt.*;
import java.awt.Container;
import java.awt.event.*;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;
import java.util.List;

public class VentanaMemograma extends JFrame {
 
    Utilities u = new Utilities();
    
    List<Integer> next = u.rowsTableAll();
    
    Container cp;
    JPanel p1;
    DimensionUIResource minSize;
    static JLabel intentos; 
    static int n = 8;
    
    public static JToggleButton[] btn = new JToggleButton[n];
    
    public VentanaMemograma() {        
        super("Juego Memoria");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        minSize = new DimensionUIResource(360, 220);
        setMinimumSize(minSize);
        setSize(380,280);
        setLocationRelativeTo(null);
        initComponents();
        u.imgStart();
    }

    private void initComponents() {
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        
        p1 = new JPanel(new GridLayout(2,4, 18,18));
        p1.setBorder(new EmptyBorder(10,10,10,10));
        
        for(int i = 0; i<n; i++){
            btn[i] = new JToggleButton();
            btn[i].setForeground(new Color(240, 240, 240));
            btn[i].setHorizontalTextPosition(SwingConstants.CENTER);
            btn[i].setMaximumSize(new DimensionUIResource(64, 64));
            btn[i].setMinimumSize(new DimensionUIResource(64, 64));
            btn[i].setPreferredSize(new DimensionUIResource(64, 64));
            p1.add(btn[i]);            
        }
        
        btn[0].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    btnMouseClicked(evt, 0);
                }
        });
        
        btn[1].addMouseListener(new MouseAdapter() {                
                public void mouseClicked(MouseEvent evt) {
                    btnMouseClicked(evt, 1);
                }
        });
        
        btn[2].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    btnMouseClicked(evt, 2);
                }
        });
        
        btn[3].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    btnMouseClicked(evt, 3);
                }
        });
        
        btn[4].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    btnMouseClicked(evt, 4);
                }
        });
        
        btn[5].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    btnMouseClicked(evt,5);
                }
        });
        
        btn[6].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    btnMouseClicked(evt, 6);
                }
        });
        
        btn[7].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    btnMouseClicked(evt, 7);
                }
        });
        
        cp.add(p1, BorderLayout.CENTER);
        
        intentos = new JLabel("Numero de intentos: 0");
        intentos.setHorizontalAlignment(WIDTH/2);
        cp.add(intentos, BorderLayout.NORTH);
        
    }                

    private void btnMouseClicked(MouseEvent e, int i) {     
        Match m = new Match();
        System.out.println(i+" 3");
        m.setBtn(btn[i]);
        m.setNumberBtn((i+1));
        m.setValueMatch(next.get(i));
        u.getMatch().add(m);
        u.paintMatch();
        u.match();
    }     
            
}

