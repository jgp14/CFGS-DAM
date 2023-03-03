/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package es.leliadoura.ad.eva1rec;

import es.leliadoura.ad.eva1rec.data.Ciclo;
import es.leliadoura.ad.eva1rec.data.Direccion;
import es.leliadoura.ad.eva1rec.data.Modulo;
import es.leliadoura.ad.eva1rec.ejercicio1.UtilSerializa;
import es.leliadoura.ad.eva1rec.ejercicio2.UtilXml;
import es.leliadoura.ad.eva1rec.ejercicio3.UtilXstream;
import java.util.List;
import org.w3c.dom.Document;

/**
 *
 * @author marco
 */
public class Main {

    public static void main(String[] args) {
        
        //EJERCICIO 1 SERIALIZACION
        //1.1 LEER LISTA MODULOS
        UtilSerializa utilSerializa = new UtilSerializa();
        List<Modulo> modulosLeidos = utilSerializa.leer("modulos.dat");
        for(Modulo modulo: modulosLeidos)
            System.out.println(modulo);
        
        //1.2 CREAR NUEVO CICLO AÑADIENDO MODULOS Y GUARDANDO
        Direccion direccion = new Direccion("Monte", "Ribeira", 2, 15950);        
        Ciclo cicloCreado = new Ciclo("ASIR", direccion, modulosLeidos);
        utilSerializa.escribir("ciclo.dat", cicloCreado);
        
        System.out.println();
        
        
        
        //EJERCICIO 2 XML Y DOM
        //2.1 LEER FICHERO XML "modulos.xml" MOSTRAR MODULOS POR CONSOLA
        UtilXml utilXml = new UtilXml();
        Document doc = null;
        doc = utilXml.leeXML("modulos.xml");        
        //utilXml.mostraElementos(doc.getDocumentElement()); //OPCIONAL
        List<Modulo> modulos = utilXml.leeModulos(doc);
        for(Modulo modulo: modulos)
            System.out.println(modulo);
        
        //2.2 GUARDAR MODULOS SIN UNIDADES
        utilXml.borraElementos(doc, "unidad");
        utilXml.guardaXML(doc, "modulosSin.xml");
        
        System.out.println();

        
        //EJERCICIO 3 XSTREAM
        //3.1 LEER E IMPRIMIR LOS MODULOS
        UtilXstream utilXstream = new UtilXstream();
        List<Modulo> modulosLeidosXS = utilXstream.leer("modulosXS.xml");
        for(Modulo modulo: modulosLeidosXS)
            System.out.println(modulo);
        
        //3.2 CREAR CICLO Y GUARDAR CON XSTREAM 
        Direccion direccionXS = new Direccion("Principal", "Ribeira", 23, 15950);
        Ciclo cicloCreadoXS = new Ciclo("DAM", direccionXS, modulosLeidosXS);
        utilXstream.escribir(cicloCreadoXS, "cicloXS.xml");
    }
    
}
