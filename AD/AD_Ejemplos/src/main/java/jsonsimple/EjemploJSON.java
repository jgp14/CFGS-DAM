package jsonsimple;

/**
 *
 * @author marco
 */
public class EjemploJSON {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Persona persona = new Persona("Pepe", new Long(23), 2000.0);
        persona.getAficiones().add("Programar");
        persona.getAficiones().add("Quejarme");
        persona.getAficiones().add("Alargar el recreo");
        
        UtilidadesJsonSimple json = new UtilidadesJsonSimple();
        json.write(persona, "pepe.json");
        Persona pLeida = json.read("pepe.json");
        System.out.println(pLeida);
        
    }

}
