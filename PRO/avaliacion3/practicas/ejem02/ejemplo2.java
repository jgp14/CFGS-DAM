package practicas.ejem02;

import practicas.ejem01.COposicion;
import practicas.ejem01.Leer;

public class ejemplo2 {

	public static void main(String[] args) {
		COposicion oposicion;
		oposicion = new COposicion();
		int opcion;
		int clave;

		do {
			opcion = oposicion.dameOpcion();
			switch (opcion) {
	            case 1:
	                oposicion.llenar();
	                System.out.println("Oposicion LLENA");
	                break;
	            case 2:
	                oposicion.vaciar();
	                System.out.println("Oposicion VACIA");
	                break;
	            case 3:
	                oposicion.mostrar();
	                break;
	            case 4:
	                System.out.print("Dame clave de aspirante: ");
	                clave = Leer.datoInt();
	                oposicion.eliminarAspirante(clave);
	                break;
	            case 5:
	                System.out.println("FINAL");
	                break;
	            default:
	                System.out.println("OPCION Erronea");
	                break;
			}
		} while (opcion != 6);
	}

}
