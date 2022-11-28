package ejemplogson;

import com.google.gson.Gson;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author fprimag
 */
public class EjemploGson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear alumno(s) y modulo(s) con datos de prueba
        Alumno alumno = new Alumno();
        alumno.setNombre("Pedro");
        alumno.setApellidos("Pérez López");
        alumno.setDni("1A");
        alumno.setNacimiento(new GregorianCalendar(1998, Calendar.FEBRUARY, 28).getTime());
        
        Modulo ad = new Modulo("AD", "MP01010");
        Modulo di = new Modulo("DI", "MP12121");
        alumno.getModulos().add(ad);
        alumno.getModulos().add(di);
        
        // (Opcional) Visualizar alumno para ver si está bien
        System.out.println(alumno.toString());
        
        // Crear objeto Gson
        Gson gson = new Gson();
        
        // Convertir objeto Java Alumno a String JSON usando Gson
        String jsonAlumno = gson.toJson(alumno);
        // (Opcional) Visualizar jsonAlumno para ver si está bien
        System.out.println(jsonAlumno);
        
        // Convertir String JSON a objeto Java Alumno usando Gson
        Alumno alumnoRecuperado = gson.fromJson(jsonAlumno, Alumno.class);
        // (Opcional) Visualizar alumnoRecuperado para ver si está bien
        System.out.println(alumnoRecuperado);

        // Crear objeto Java UtilidadesGson para escribir y leer
        UtilidadesGson json = new UtilidadesGson();

        // Escribir archivo JSON usando método write de UtilidadesGson
        json.write(alumno, "alumno.json");

        // Leer archivo JSON usando método read de UtilidadesGson
        Alumno alumnoLeido = json.read("alumno.json");
        System.out.println(alumnoLeido);
    }
    
}
