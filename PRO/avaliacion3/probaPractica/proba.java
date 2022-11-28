package probaPractica;

import misClases.avaliacion3.CTiendaFruta;
import misClases.utilidades.Leer;

public class proba {

	public static void main(String[] args) {
		CTiendaFruta tiendaFruta;
		tiendaFruta = new CTiendaFruta();
		int opcion;
		String identificador;

		do {
			opcion = tiendaFruta.dameOpcion();
			switch (opcion) {
	            case 1:
	            	tiendaFruta.llenar();
	                System.out.println("Tienda LLENA");
	                break;
	            case 2:
	            	tiendaFruta.vaciar();
	                System.out.println("Tienda VACIA");
	                break;
	            case 3:
	            	tiendaFruta.mostrarTienda();
	                break;
	            case 4:
	            	System.out.print
	                ("Dame código de fruta:");
	                identificador = Leer.datoString();
	                tiendaFruta.mostrarFruta(identificador);
	                break;
	            case 5:
	                System.out.println("FINAL");
	                break;
	            default:
	                System.out.println("OPCION Erronea");
	                break;
			}
		} while (opcion == 1 || opcion == 2|| 
				opcion == 3 || opcion == 4);
	}
}
