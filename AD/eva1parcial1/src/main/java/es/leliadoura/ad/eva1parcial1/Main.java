/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package es.leliadoura.ad.eva1parcial1;

import es.leliadoura.ad.eva1parcial1.data.Ciclo;
import es.leliadoura.ad.eva1parcial1.data.GeneradorDatos;
import es.leliadoura.ad.eva1parcial1.data.Modulo;
import es.leliadoura.ad.eva1parcial1.ejercicio1.UtilSerializa;
import es.leliadoura.ad.eva1parcial1.ejercicio2.CrearXmlModulos;
import es.leliadoura.ad.eva1parcial1.ejercicio2.UtilXml;
import es.leliadoura.ad.eva1parcial1.ejercicio3.ListaModulos;
import es.leliadoura.ad.eva1parcial1.ejercicio3.UtilXstream;
import es.leliadoura.ad.eva1parcial1.ejercicio4.UtilJson;
import es.leliadoura.ad.eva1parcial1.ejercicio5.UtilGson;
import java.util.List;
import org.w3c.dom.Document;

/**
 *
 * @author marco
 */
public class Main {

    public static void main(String[] args) {
        GeneradorDatos datos = new GeneradorDatos();
        
        //Ejercicio Serializacion
        String rutaCiclos = "ciclos";
        UtilSerializa utilSer = new UtilSerializa();
        List<Ciclo> ciclos = datos.creaCiclos();
        utilSer.guardaListaCiclos(rutaCiclos, ciclos);
        utilSer.leeListaCiclos(rutaCiclos);
        utilSer.mostraListaCiclos(rutaCiclos);
        Ciclo ciclo = utilSer.encuentraCiclo(rutaCiclos, "DAM");
        System.out.println("Encontrado: \n"+ciclo.toString());
        
        
        
        //Ejercicio XML
        String rutaModulos = "modulos";
        UtilXml utilXml = new UtilXml();
        CrearXmlModulos cxm = new CrearXmlModulos();
        List<Modulo> modulos = datos.creaModulos();
        cxm.setModulos(modulos);
        cxm.xeraXmlModulos(rutaModulos);
        
        Document doc = utilXml.leeXML(rutaModulos+".xml");
        doc = utilXml.borraElementos("descripcion", doc);
        utilXml.guardaXML(doc,rutaModulos+"Desc.xml");
        
        
        
        //Ejercicio XStream
        UtilXstream uxs = new UtilXstream();
        String rutaModulosXS = "modulos";
        
        //Usando desde una lista de modulos sin guardar en dat
        uxs.creaXmlXsMem(rutaModulosXS, modulos);
        //Leemos los modulos y los recuperamos a ListaModulos y List<Modulo>
        ListaModulos listaModulosLeidosMem = uxs.leeXmlXsMem(rutaModulosXS);
        List<Modulo> listModulosLeidosMem = listaModulosLeidosMem.getModulos();
        System.out.println("Lista recuperada "+listModulosLeidosMem);
        
        //Usando desde una lista de modulos guardando en dat antes
        uxs.creaXmlXs(rutaModulosXS, modulos);
        //Leemos los modulos y los recuperamos a ListaModulos y List<Modulo>
        ListaModulos listaModulosLeidos = uxs.leeXmlXS(rutaModulosXS);
        List<Modulo> listModulosLeidos = listaModulosLeidos.getModulos();
        System.out.println("Lista recuperada "+listModulosLeidos);
        
        Document doc1 = utilXml.leeXML("modulosXS.xml");
        doc1 = utilXml.borraElementos("alumnos", doc);
        utilXml.guardaXML(doc1,"modulosXSin.xml");
        
        //EJERCICIO JSON SIMPLE
        UtilJson json = new UtilJson();
        json.gardaListaCiclos(ciclos, "ciclos.json");
        json.mostrarListaCiclos(json.leeListaCiclos("ciclos.json"));
        json.crearXMLCiclos("ciclos");
        json.mostrarXMLCiclos("ciclosXS.xml");
        
        //EJERCICIO GSON
        UtilGson gson = new UtilGson();
        gson.creaGsonCiclos(ciclos, "ciclosG.json");      
        System.out.println("Listado de ciclosG: ");
        for(Ciclo c: gson.leeGsonCiclos("ciclosG.json"))
            System.out.println(c);
    }
    
}
