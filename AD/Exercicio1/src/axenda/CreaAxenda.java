package axenda;

import java.util.ArrayList;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


/**
 *
 * @author user
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
    private ArrayList<Contacto> contactos = xeraContactos();

    //Getter y Setter de doc
    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }
    
    //Medotod para generar contacto 
    private ArrayList<Contacto> xeraContactos(){
        ArrayList<Contacto> contactos = new ArrayList<>();
        for(int i = 0; i < id.length; i++)
            contactos.add(new Contacto(id[i],nome[i],telefono[i],rua[i],numero[i]));        
        return contactos;
    }
    
    //Generar agenda de contactos
    public Document xeraXMLContactos(String ruta) {        
        doc = utilidadesXML.creaDOMBaleiro(ruta);
        
        for(Contacto contact: contactos){
            Attr id = doc.createAttribute("id");           
            
            Element nome = doc.createElement("nome");
            Text textoNome = doc.createTextNode
            (String.valueOf(contact.getNome()));
            nome.appendChild(textoNome);
            
            Element telefono = doc.createElement("telefono");
            Text textoTelefono = doc.createTextNode
            (String.valueOf(contact.getTelefono()));
            telefono.appendChild(textoTelefono);
            
            Element rua = doc.createElement("rua");
            Text textoRua = doc.createTextNode
            (String.valueOf(contact.getRua()));
            rua.appendChild(textoRua);
            
            Element numero = doc.createElement("numero");
            Text textoNumero = doc.createTextNode
            (String.valueOf(contact.getNumero()));
            numero.appendChild(textoNumero);
            
            Element enderezo = doc.createElement("enderezo");
            enderezo.appendChild(rua);
            enderezo.appendChild(numero);
            
            Element contacto = doc.createElement("contacto");
            contacto.setAttribute("id", String.valueOf(contact.getId()));
            contacto.appendChild(nome);
            contacto.appendChild(telefono);
            contacto.appendChild(enderezo);

            Element raiz = doc.getDocumentElement();
            raiz.appendChild(contacto);
        }
            
        utilidadesXML.DOMaXML(doc, ruta+".xml");
        return doc;
    }
}
