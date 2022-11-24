package axenda;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


/**
 *
 * @author dam205
 */
public class CreaAxenda {
     
    //Creacion de los atributos
    private final int[] id = {1,2,3,4,5,6};
    private final String[] nome = 
    {"Luis", "Rocio", "Marco", "Cesar", "Rosa", "Bea"};
    private final String[] rua = 
    {"rua Nova", "rua Vella", "rua Media", "rua Alta", "rua Baixa", "rua Ancha"};
    private final String[] telefono = 
    {"555123456","555987654","555345678","555129834","555981276","555564378"};
    private final int[] numero = {3,13,33,11,6,14};
    private UtilidadesXML utilidadesXML = new UtilidadesXML();
    private Document doc = null;
    private List<Contacto> list = xeraContactos();

    //Getter y Setter de doc
    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public List<Contacto> getList() {
        return list;
    }
    
    //Medotodo para generar contacto 
    private List<Contacto> xeraContactos(){
        List<Contacto> list = new ArrayList<>();
        for(int i = 0; i < id.length; i++)
            list.add(new Contacto
            (id[i],nome[i],telefono[i],rua[i],numero[i]));        
        return list;
    }
    
    //Generar agenda de contactos
    public Document xeraXMLContactos(String ruta) {        
        doc = utilidadesXML.creaDOMBaleiro(ruta);
        doc = documentContactos(doc);
        utilidadesXML.DOMaXML(doc, ruta+".xml");
        return doc;
    }
    
    //Metodopara generar los contactos del documento
    private Document documentContactos(Document doc){
        for(Contacto c: list){
            Attr id = doc.createAttribute("id");           
            
            Element nome = doc.createElement("nome");
            nome.appendChild(doc.createTextNode(c.getNome()));
            
            Element telefono = doc.createElement("telefono");
            telefono.appendChild(doc.createTextNode(c.getTelefono()));
            
            Element rua = doc.createElement("rua");
            rua.appendChild(doc.createTextNode(c.getRua()));
            
            Element numero = doc.createElement("numero");
            Text textoNumero = doc.createTextNode
            (String.valueOf(c.getNumero()));
            numero.appendChild(textoNumero);
            
            Element enderezo = doc.createElement("enderezo");
            enderezo = xeraXMLEnderezo(doc, c);
            
            Element contacto = doc.createElement("contacto");
            contacto.setAttribute("id", String.valueOf(c.getId()));
            contacto.appendChild(nome);
            contacto.appendChild(telefono);
            contacto.appendChild(enderezo);

            Element raiz = doc.getDocumentElement();
            raiz.appendChild(contacto);
        }
        return doc;
    }
    
    //Metodo para generar el enderezo de cada contacto
    private Element xeraXMLEnderezo(Document doc, Contacto c){
        Element rua = doc.createElement("rua");
        Text textoRua = doc.createTextNode
        (String.valueOf(c.getRua()));
        rua.appendChild(textoRua);

        Element numero = doc.createElement("numero");
        Text textoNumero = doc.createTextNode
        (String.valueOf(c.getNumero()));
        numero.appendChild(textoNumero);

        Element enderezo = doc.createElement("enderezo");
        enderezo.appendChild(rua);
        enderezo.appendChild(numero);
        return enderezo;
    }

}
