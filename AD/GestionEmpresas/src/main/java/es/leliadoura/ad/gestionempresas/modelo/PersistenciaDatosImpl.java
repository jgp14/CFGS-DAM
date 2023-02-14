/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.gestionempresas.modelo;

import es.leliadoura.ad.gestionempresas.modelo.entity.Contacto;
import es.leliadoura.ad.gestionempresas.modelo.entity.Contrato;
import es.leliadoura.ad.gestionempresas.modelo.entity.Empresa;
import es.leliadoura.ad.gestionempresas.modelo.entity.Fechas;
import es.leliadoura.ad.gestionempresas.modelo.entity.Trabajador;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author dam205
 */
public class PersistenciaDatosImpl implements PersistenciaDatos{

    @Override
    public void guardaEmpresa(Empresa empresa){                
        if(empresa != null && !empresa.isEmpty()) {
            Session s = HibernateSession.getSession();
            s.beginTransaction();
            for(Contacto contacto: empresa.getContactos())
                s.persist(contacto);
            s.persist(empresa);   
            s.getTransaction().commit();
            s.close();
        }
    }

    @Override
    public void modificarEmpresa(Empresa empresa) {
        if(empresa != null && !empresa.isEmpty()){
            Session s = HibernateSession.getSession();
            s.beginTransaction();
            s.merge(empresa);
            s.getTransaction().commit();
            s.close();
        }        
    }

    @Override
    public Empresa consultaEmpresa(String NIF) {
        Empresa empresa = new Empresa();        
        if(NIF != null && !NIF.isEmpty() && !NIF.isBlank()){
            Session s = HibernateSession.getSession();
            empresa = s.find(Empresa.class, NIF);
        }            
        return empresa;        
    }

    @Override
    public void guardaTrabajador(Trabajador trabajador) {
        if(trabajador != null && !trabajador.isEmpty()){
            Session s = HibernateSession.getSession();
            s.beginTransaction();
            s.persist(trabajador);
            s.getTransaction().commit();
            s.close();
        }                    
    }

    @Override
    public void modificarTrabajador(Trabajador trabajador) {
        if(trabajador != null && !trabajador.isEmpty()){
            Session s = HibernateSession.getSession();
            s.beginTransaction();
            s.merge(trabajador);
            s.getTransaction().commit();
            s.close();
        }
    }

    @Override
    public Trabajador consultaTrabajador(String DNI) {
        Trabajador trabajador = new Trabajador();
        if(DNI != null && !DNI.isEmpty() && !DNI.isBlank()){
            Session s = HibernateSession.getSession();
            trabajador = s.find(Trabajador.class, DNI);
            s.close();            
        }
        return trabajador;
    }

    @Override
    public void guardarContacto(Contacto contacto) {
        if(contacto != null && !contacto.isEmpty()){
            Session s = HibernateSession.getSession();
            s.beginTransaction();
            s.persist(contacto);
            s.getTransaction().commit();
            s.close();
        }  
    }

    @Override
    public void modificarContacto(Contacto contacto, Contacto modificado) {
        if(contacto != null && !contacto.isEmpty() && 
                modificado  != null && !modificado.isEmpty()){
            Session s = HibernateSession.getSession();
            s.beginTransaction();
            contacto.setNombre(modificado.getNombre());
            contacto.setApellidos(modificado.getApellidos());
            contacto.setCorreo(modificado.getCorreo());
            contacto.setTelefono(modificado.getTelefono());            
            s.merge(contacto);
            s.getTransaction().commit();
            s.close();
        }
    }

    @Override
    public void borrarContacto(Contacto contacto) {
        if(contacto != null && !contacto.isEmpty()){
            Session s = HibernateSession.getSession();
            s.beginTransaction();             
            Contacto contactoRecu = recuperaContacto(contacto.getCorreo(), 
                    contacto.getNombre(), contacto.getApellidos());
            Contacto contactoEliminar = s.get(Contacto.class, contactoRecu.getId());
            s.remove(contactoEliminar);        
            s.getTransaction().commit();
            s.close();
        }        
    }

    @Override
    public Contacto recuperaContacto(String correo, String nombre, String apellidos) {
        List<Contacto> contactos = new ArrayList<>();
        Contacto contacto = new Contacto();
        String string = "FROM Contacto "
                + "WHERE correo LIKE '"+correo+"' "
                + "AND nombre LIKE '"+nombre+"' "
                + "AND apellidos LIKE '"+apellidos+"'";
        if(correo != null && !correo.isEmpty() && !correo.isBlank() 
                && nombre != null && !nombre.isEmpty() && !nombre.isBlank() 
                && apellidos != null && !apellidos.isEmpty() && !apellidos.isBlank()){
            Session s = HibernateSession.getSession();
            contactos = s.createQuery(string, Contacto.class).list();
            if(contactos.size() == 1)
                contacto = contactos.get(0);            
            s.close();
        } 
        return contacto;    
    }

    @Override
    public void guardarContrato(Contrato contrato) {
        if(contrato != null && !contrato.isEmpty()){
            Session s = HibernateSession.getSession();
            s.beginTransaction();
            s.persist(contrato);
            s.getTransaction().commit();
            s.close();
        }
    }

    @Override
    public void modificarContrato(Contrato contrato, Contrato modificado) {
        if(contrato != null && !contrato.isEmpty() && 
            modificado  != null && !modificado.isEmpty()){
            Session s = HibernateSession.getSession();
            s.beginTransaction();
            contrato.setEmpresa(modificado.getEmpresa());
            contrato.setTrabajador(modificado.getTrabajador());
            contrato.setFecInicio(modificado.getFecInicio());
            contrato.setJornada(modificado.getJornada());
            contrato.setSalario(modificado.getSalario());
            s.merge(contrato);
            s.getTransaction().commit();
            s.close();
        }
    }

    @Override
    public Contrato recuperaContrato(String DNI, String NIF, Date fecInicio) {
        List<Contrato> contratos = new ArrayList<>();
        Contrato contrato = new Contrato();
        Fechas fechas = new Fechas();        
        String string = "FROM Contrato c "
                + "JOIN c.trabajador t "
                + "JOIN c.empresa e "
                + "WHERE t.DNI LIKE '"+DNI+"' "
                + "AND e.NIF LIKE '"+NIF+"' "
                + "AND c.fecInicio LIKE '"
                + fechas.dateToString(fecInicio)+"'";
        if(DNI != null && !DNI.isEmpty() && !DNI.isBlank() 
            && NIF != null && !NIF.isEmpty() && !NIF.isBlank() 
                && fecInicio != null){  
            Session s = HibernateSession.getSession(); 
            contratos = s.createQuery(string, Contrato.class).list();
            if(contratos.size() == 1)
                contrato = contratos.get(0);
        } 
        return contrato; 
    }

    @Override
    public List<Contrato> consultaContratosEmpresa(String NIF) {
        List<Contrato> contratos = new ArrayList<>();        
        String string = "FROM Contrato c "
                + "JOIN c.empresa e "
                + "WHERE e.NIF LIKE '"+NIF+"'";        
        if(NIF != null && !NIF.isEmpty() && !NIF.isBlank()){
            Session s = HibernateSession.getSession();
            contratos = s.createQuery(string, Contrato.class).list();
        }            
        return contratos;
    }

    @Override
    public List<Contrato> consultaContratosActualesEmpresa(String NIF) {
        List<Contrato> contratos = new ArrayList<>();
        String string = "FROM Contrato c "
                + "JOIN c.empresa e "
                + "WHERE e.NIF LIKE '"+NIF+"' "
                + "AND c.fecFin=NULL";        
        if(NIF != null && !NIF.isEmpty() && !NIF.isBlank()){
            Session s = HibernateSession.getSession();
            contratos = s.createQuery(string, Contrato.class).list();
        }            
        return contratos;
    }

    @Override
    public List<Contrato> consultaContratosTrabajador(String DNI) {
        List<Contrato> contratos = new ArrayList<>();
        String string = "FROM Contrato c "
                + "JOIN c.trabajador t "
                + "WHERE t.DNI LIKE '"+DNI+"'";        
        if(DNI != null && !DNI.isEmpty() && !DNI.isBlank()){
            Session s = HibernateSession.getSession();
            contratos = s.createQuery(string, Contrato.class).list();
        }                   
        return contratos;
    }

    @Override
    public List<Empresa> consultaEmpresas() {
        List<Empresa> empresas = new ArrayList<>();
        String string = "FROM Empresa e";
        Session s = HibernateSession.getSession();
        empresas = s.createQuery(string, Empresa.class).list();
        return empresas;
    }

    @Override
    public List<Trabajador> consultaTrabajadores() {
        List<Trabajador> trabajadores = new ArrayList<>();
        String string = "FROM Trabajador t";
        Session s = HibernateSession.getSession();
        trabajadores = s.createQuery(string, Trabajador.class).list();
        return trabajadores;
    }

    @Override
    public List<Contrato> consultaContratos() {
        List<Contrato> contratos = new ArrayList<>();
        String string = "FROM Contrato c";
        Session s = HibernateSession.getSession();
        contratos = s.createQuery(string, Contrato.class).list();
        return contratos;
    }

    @Override
    public List<Contacto> consultaContactos() {
        List<Contacto> contactos = new ArrayList<>();
        String string = "FROM Contacto c";
        Session s = HibernateSession.getSession();
        contactos = s.createQuery(string, Contacto.class).list();
        return contactos;
    }
    
    public PersistenciaDatosImpl(){}
    
}
