/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package es.leliadoura.ad.gestionempresas.modelo;

import es.leliadoura.ad.gestionempresas.controlador.ControlEmpresasImpl;
import es.leliadoura.ad.gestionempresas.errores.ControlEmpresasException;
import es.leliadoura.ad.gestionempresas.modelo.entity.Contacto;
import es.leliadoura.ad.gestionempresas.modelo.entity.Contrato;
import es.leliadoura.ad.gestionempresas.modelo.entity.Empresa;
import es.leliadoura.ad.gestionempresas.modelo.entity.Fechas;
import es.leliadoura.ad.gestionempresas.modelo.entity.Trabajador;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author dam205
 */
public class Test {
    
    private static void insertarDatosIniciales(){
        //GENERARDATOS CLASE CON METODOS DE LISTAS DE DATOS
        GeneradorDatos gd = new GeneradorDatos(); 
        List<Trabajador> trabajadores = gd.listaTrabajadores();
        List<Contacto> contactos = gd.listaContactos(); 
        List<Empresa> empresas = gd.listaEmpresas(contactos);//Antes contactos        
        List<Contrato> contratos = gd.listaContratos(empresas);//Antes empresas

        //INSERTAR TRABAJADORES Y CONTACTOS
        Session sesion = HibernateSession.getSession();        
        sesion.beginTransaction();
        for(Contacto contacto: contactos)            
            sesion.persist(contacto);  
        for(Trabajador t: trabajadores)            
            sesion.persist(t); 
        for(Empresa e: empresas)
            sesion.persist(e);
        sesion.getTransaction().commit();    
        
        //OBLIGATORIO HACER COMMIT PARA METER CONTRATOS        
        sesion.beginTransaction();  
        for(Contrato contrato: contratos)
            sesion.persist(contrato);        
        sesion.getTransaction().commit();   
    }
    
    public static void main(String[] args) { //MAIN DE TESTS
        System.out.println("Gestion de empresas");               
        insertarDatosIniciales(); //INSERCION INICIAL DE DATOS
        System.out.println("\n");        
        PersistenciaDatosImpl pd = new PersistenciaDatosImpl();
                
        //TEST METODOS EMPRESA
        Empresa empresa = new Empresa
        ("A81939209", "Ferrovial  ", "ES6664416657304546218945");
        Contacto contacto1 = new Contacto
        ("Alvaro", "Regueira Teira", "alvaro@mail.com", 34555333666L);
        Contacto contacto2 = new Contacto
        ("Javier", "Perez Nieto", "javi@mail.com", 34555666333L);
        empresa.getContactos().add(contacto1);
        empresa.getContactos().add(contacto2);
        pd.guardaEmpresa(empresa);            
        
        empresa.setRazonSocial("Ferrovial S.A.");
        empresa.setIBAN("ES6663331197304546218777");
        pd.modificarEmpresa(empresa);
        
        System.out.println(pd.consultaEmpresa("A81939209"));
        System.out.println("\n");
        
        
        //TEST METODOS TRABAJADOR
        Trabajador trabajador = new Trabajador
        ("6F", "Monica", "Martinez Perez", "ES94904668414362442548189", 
                667788L, "monica@mail.com", 34555135791L);
        pd.guardaTrabajador(trabajador);
        
        trabajador.setCorreo("monica14@gmail.com");
        trabajador.setTelefono(34555246801L);
        pd.modificarTrabajador(trabajador);
        
        System.out.println(pd.consultaTrabajador("6F"));
        System.out.println("\n");
        
        
        //TEST METODOS CONTACTO
        Contacto contacto3 =  new Contacto
        ("Sara", "Regueira Pascual", "sara@mail.com", 34555777444L);
        Contacto contacto3Mod = new Contacto
        ("Sara", "Regueira Pascual", "sara99@protonmail.com", 34555888555L);
        pd.guardarContacto(contacto3);        
        
        pd.modificarContacto(contacto3, contacto3Mod);
        
        pd.borrarContacto(contacto3Mod);
        
        Contacto contactoRecu = 
        pd.recuperaContacto("sara99@protonmail.com", "Sara", "Regueira Pascual");
        System.out.println(contactoRecu);
        System.out.println("\n");
        
        
        //TEST METODOS CONTRATO
        Fechas f = new Fechas();
        Contrato contrato = new Contrato
        (trabajador, empresa, f.stringToDate("2022-02-22"), 
                null, 2150D, 8);
        Contrato contratoMod = new Contrato
        (trabajador, empresa, f.stringToDate("2022-02-22"), 
                null, 1200D, 4);
        pd.guardarContrato(contrato);
        
        pd.modificarContrato(contrato, contratoMod);
        
        Contrato contratoRecu = 
            pd.recuperaContrato("6F", "A81939209", f.stringToDate("2022-02-22"));
        System.out.println(contratoRecu);
        System.out.println("\n");
        
        
        //TEST METODOS CONSULTAR LISTAS FILTRADAS
        List<Contrato> contratos = pd.consultaContratosEmpresa("A28015865");
        for(Contrato c: contratos)
            System.out.println(c);
        List<Contrato> contratosActuales = 
                pd.consultaContratosActualesEmpresa("A28015865");
        for(Contrato c: contratosActuales)
            System.out.println(c);
        List<Contrato> contratosTrabajador = 
                pd.consultaContratosTrabajador("4D");
        for(Contrato c: contratosTrabajador)
            System.out.println(c);
        System.out.println("\n");
        
        
        //TEST CONSULTAS LISTAS COMPLETAS
        for(Empresa e: pd.consultaEmpresas())
            System.out.println(e);
        for(Trabajador t: pd.consultaTrabajadores())
            System.out.println(t);
        for(Contrato c: pd.consultaContratos())
            System.out.println(c);
        for(Contacto c: pd.consultaContactos())
            System.out.println(c);  
        System.out.println("\n");
        
        
        //TEST METODOS DE LA CLASE CONTROLEMPRESAS
        ControlEmpresasImpl ce = new ControlEmpresasImpl();
        
        Empresa empresa2 = new Empresa("B84795251", 
                "Instituto Bolsas Y Mercados Españoles Sl", 
                "ES95964768424362642148780");
        try {
            //GUARDA EMPRESA
            ce.guardaEmpresa(empresa2);           
            System.out.println(pd.consultaEmpresa(empresa2.getNIF())+"\n");

            //GUARDAR EMPRESA ACTUALIZADA
            empresa2.setRazonSocial("IBME SL");
            empresa2.setIBAN("ES96964764425662212141789");
            ce.guardaActualizaEmpresa(empresa2);
            System.out.println(pd.consultaEmpresa(empresa2.getNIF())+"\n");

            //CREAR CONTRATO NUEVO 
            ce.crearContrato(empresa2.getNIF(), trabajador.getDNI(), 
            f.stringToDate("2023-02-14"), BigDecimal.valueOf(2100), 7); 
            ce.crearContrato("A79075438", "6F", 
            f.stringToDate("2023-02-15"), BigDecimal.valueOf(1979), 6); 
            Contrato contratoRecu2 = pd.recuperaContrato(trabajador.getDNI(), 
                    empresa2.getNIF(), f.stringToDate("2023-02-14"));
            System.out.println(contratoRecu2+"\n");
            
        } catch (ControlEmpresasException ex) {
            System.err.println(ex.getMessage());
        }  
        
        //CONSULTAR CONTRATO
        System.out.println(ce.consultaContratoActual("5E", "A48265169"));
        System.out.println(ce.consultaContratoActual("3C", "A28015865")+"\n");
        
        //CONSULTAR ESTADO EXISTENCIA EMPRESA
        System.out.println("¿Existe A11222333?: "+ce.existeEmpresa("A11222333"));
        System.out.println("¿Existe A81939209?: "+ce.existeEmpresa("A81939209"));
    }      

}
