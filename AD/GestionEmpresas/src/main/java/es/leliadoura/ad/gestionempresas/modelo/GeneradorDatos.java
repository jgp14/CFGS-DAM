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

/**
 *
 * @author dam205
 */
public class GeneradorDatos {
    
    public List<Trabajador> listaTrabajadores(){
        List<Trabajador> lista = new ArrayList<>();
        lista.add(new Trabajador
        ("1A", "Juan", "Garcia Fernandez", "ES6621000418401234567891", 112233L, "juan@mail.com", 34555112233L));
        lista.add(new Trabajador
        ("2B", "Maria", "Gomez Perez", "ES6000491500051234567892", 223344L, "maria@mail.com", 34555223344L));
        lista.add(new Trabajador
        ("3C", "Pedro", "Prada Martinez", "ES9420805801101234567891", 334455L, "pedro@mail.com", 34555334455L));
        lista.add(new Trabajador
        ("4D", "Sara", "Blanco Hermida", "ES9620406801406254264820", 445566L, "sara@mail.com", 34555445566L));
        lista.add(new Trabajador
        ("5E", "Fram", "Perez Sanchez", "ES6660408801206244266827", 556677L, "fran@mail.com", 34555665544L));                
//        Collections.shuffle(lista);        
//        return new ArrayList(lista.subList(0, new Random().nextInt(4)+1));
        return lista;
    }
    
    public List<Contacto> listaContactos(){
        List<Contacto> lista = new ArrayList<>();
        lista.add(new Contacto
        ("Marco", "Magan Sanz", "marco.magan.sanz@edu.xunta.gal", 34555667788L));
        lista.add(new Contacto
        ("Graciela", "Redondo Arguelles", "gracielaredondo@edu.xunta.es", 34555778899L));
        lista.add(new Contacto
        ("Isabel María", "Pena Seara", "ispeseara@edu.xunta.gal", 34555889999L));
        lista.add(new Contacto
        ("Cesar", "Rodriguez Dorado", "crdorado@edu.xunta.gal", 34555990011L));
        lista.add(new Contacto
        ("Rosa Maria", "Busto Regueira", "rbusreg@edu.xunta.gal", 34555001122L));
        lista.add(new Contacto
        ("Noelia", "Cores Piñeiro ", "noelia@mail.com", 34666112233L));
        lista.add(new Contacto
        ("Jorge", "Dominguez Camean", "jorge@mail.com", 34666223344L));
        lista.add(new Contacto
        ("Belen", "Garcia de la Torre", "belen@mail", 34666334455L));
        lista.add(new Contacto
        ("Jaime", "Garcia Parada", "jaime@mail.com", 34666445566L));
        lista.add(new Contacto
        ("Luis Manuel", "Lustres Garcia", "luis@mail.com", 34666556677L));
//        Collections.shuffle(lista);        
//        return new ArrayList(lista.subList(0, new Random().nextInt(4)+1));
        return lista;
    }
    
    public List<Empresa> listaEmpresas(List<Contacto> contactos){
        List<Empresa> lista = new ArrayList<>();
        lista.add(new Empresa("A08001851", "Acciona", "ES6664405802205246268818"));
        lista.add(new Empresa("A15075062", "Inditex ", "ES6669115602305646568912"));
        lista.add(new Empresa("A28015865", "Telefónica", "ES6669115603306647568919"));
        lista.add(new Empresa("A39000013", "Banco Santander", "ES6664405802205246268818"));
        lista.add(new Empresa("A48265169", "BBVA ", "ES6669116603305646568919"));       
        lista.add(new Empresa("A79075438", "Tele5", "ES6669147632356786918040"));
        
        lista = addContactosEmpresas(lista, contactos);
        return lista;
    }
    
    public List<Empresa> addContactosEmpresas
        (List<Empresa> empresas, List<Contacto> contactos){
        empresas.get(0).getContactos().add(contactos.get(0));
        empresas.get(0).getContactos().add(contactos.get(1));      
        empresas.get(1).getContactos().add(contactos.get(2));
        empresas.get(1).getContactos().add(contactos.get(3));
        empresas.get(2).getContactos().add(contactos.get(4));
        empresas.get(2).getContactos().add(contactos.get(5));
        empresas.get(3).getContactos().add(contactos.get(6));
        empresas.get(3).getContactos().add(contactos.get(7));
        empresas.get(4).getContactos().add(contactos.get(8));
        empresas.get(4).getContactos().add(contactos.get(9));
        return empresas;
    }
    
    public List<Contrato> listaContratos(List<Empresa> emp){
        List<Contrato> lista = new ArrayList<>();
        Fechas f = new Fechas();
        List<Trabajador> tra = listaTrabajadores();
        lista.add(new Contrato(tra.get(0), emp.get(0),
                f.stringToDate("2012-12-12"), f.stringToDate("2021-12-12"), 1500D, 8));
        lista.add(new Contrato(tra.get(1), emp.get(1), 
                f.stringToDate("2015-02-14"), f.stringToDate("2022-10-02"), 1800D, 7));
        lista.add(new Contrato(tra.get(2), emp.get(2), 
                f.stringToDate("2016-04-30"), null, 1900D, 8));
        lista.add(new Contrato(tra.get(3), emp.get(2), 
                f.stringToDate("2017-10-20"), new Date(), 2000D, 9)); 
        lista.add(new Contrato(tra.get(4), emp.get(3), 
                f.stringToDate("2018-11-20"), null, 2000D, 8)); 
        lista.add(new Contrato(tra.get(4), emp.get(4), 
                f.stringToDate("2019-11-20"), null, 600D, 4)); 
        return lista;
    }
    
    public final void mostrarCampos(){
        for(Trabajador t: listaTrabajadores())
            System.out.println(t);
        List<Contacto> contactos = listaContactos();
        for(Contacto contacto: contactos)
            System.out.println(contacto);
        List<Empresa> empresas = listaEmpresas(contactos);
        for(Empresa e: empresas)
            System.out.println(e);  
        for(Contrato contrato: listaContratos(empresas))
            System.out.println(contrato);  
    }
   
}
