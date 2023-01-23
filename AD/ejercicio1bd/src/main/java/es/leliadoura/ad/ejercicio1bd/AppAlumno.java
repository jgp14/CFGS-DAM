package es.leliadoura.ad.ejercicio1bd;

import com.mysql.cj.util.StringUtils;
import es.leliadoura.ad.ejercicio1bd.operaciones.Alumno;
import es.leliadoura.ad.ejercicio1bd.operaciones.OperacionBDException;
import es.leliadoura.ad.ejercicio1bd.operaciones.OperacionesBD;
import java.util.Scanner;


/**
 *
 * @author dam205
 */
public class AppAlumno {

    public static void main(String[] args){
        OperacionesBD op = new OperacionesBD();
        Scanner s = new Scanner(System.in);
        String dni;
        Alumno alumnoInsert = new Alumno
        ("66666666G", "Jaime", "Garcia Parada", 25);
        Alumno alumnoUpdate = new Alumno
        ("66666666G", "Jacobo", "Gomez", 26);
        Integer n = 0, result = 0;
        do{ 
            try{ 
                menuEjercicio1bd();
                n = setNumber();
                if(n == null) n = 0;
                switch(n){
                    case 1:
                        op.abrirConexion();
                        break;
                    case 2:
                        op.cerrarConexion();
                        break;
                    case 3:
                        result = op.agregaAlumno(alumnoInsert);     
                        isCompleted(result);
                        break;
                    case 4:
                        System.out.print("Dame DNI del alumno a consultar: ");
                        dni = s.nextLine();
                        Alumno aSelected = op.consultaAlumno(dni);
                        System.out.println(aSelected);
                        break;
                    case 5:
                        System.out.print("Dame DNI del alumno a borrar: ");
                        dni = s.nextLine();
                        result = op.borraAlumno(dni);
                        isCompleted(result);
                        break;
                    case 6:
                        System.out.print("Dame DNI del alumno a modificar: ");
                        dni = s.nextLine();
                        alumnoUpdate = setAlumnoData();
                        alumnoUpdate.setDni(dni);
                        result = op.modificaAlumno(alumnoUpdate);
                        isCompleted(result);
                        break;
                    case 7:
                        for(Alumno a: op.listadoAlumnos())
                            System.out.println(a);
                        break;
                    case 8:
                        for(Alumno a: op.listadoAlumnos(setAlumnoData()))
                            System.out.println(a);
                        break;
                    case 9:
                        System.out.println("\nFINAL");
                        break;
                    default:
                        System.out.println("\nOpcion erronea ");
                        break;
                }
            }catch(OperacionBDException ex){
                System.err.println("Codigo de error "+ex.getErrorCode() + 
                        ": "+ex.getMessage());
                //System.out.println(ex);
            }               
        } while(n != 9);    
    }
    
    private static final void menuEjercicio1bd() {
        System.out.println("\n     EJERCICIO1BD");
	System.out.println(" 1.- Abrir conexion");
        System.out.println(" 2.- Cerrar conexion");
	System.out.println(" 3.- Engadir alumno");
        System.out.println(" 4.- Consultar alumno");
	System.out.println(" 5.- Borrar alumno");
        System.out.println(" 6.- Modificar alumno");
	System.out.println(" 7.- Listar alumnado");
        System.out.println(" 8.- Filtrar alumnado");
        System.out.println(" 9.- FINAL");
        System.out.print("\nDame opcion: ");
    }
    
    private static final Integer setNumber(){
        Integer n = null;
        Scanner s = new Scanner(System.in);
        CharSequence nString = s.nextLine();
            if(StringUtils.isStrictlyNumeric(nString))
                n = Integer.valueOf(nString.toString());
        return n; 
    }
    
    private static final Alumno setAlumnoData(){
        Alumno alumno = new Alumno();
        Scanner s = new Scanner(System.in);
        System.out.print("Dame nombre del alumno: ");
        alumno.setNombre(s.nextLine());
        System.out.print("Dame apellidos del alumno: ");
        alumno.setApellidos(s.nextLine());
        System.out.print("Dame edad del alumno: ");
        alumno.setEdad(setNumber());
        return alumno;        
    }
    
    private static final void isCompleted(Integer result){
        if(result >= 1)
            System.out.println("Operacion SQL realizada con exito");
        else
            System.out.println("Operacion SQL fallida");
    }

}
