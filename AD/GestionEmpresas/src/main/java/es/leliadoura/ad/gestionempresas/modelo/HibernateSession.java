/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.gestionempresas.modelo;

import java.io.File;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 *
 * @author dam205
 */
public class HibernateSession {
    
    private static final SessionFactory sessionFactory;
    
    static {
        String ruta = HibernateSession.class.getResource("").getPath()+"hibernate.cfg.xml";
        File configFile = new File(ruta);
        Configuration conf = new Configuration().configure(configFile);
        sessionFactory = conf.buildSessionFactory();
        sessionFactory.openSession();        
    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }    
    
}
