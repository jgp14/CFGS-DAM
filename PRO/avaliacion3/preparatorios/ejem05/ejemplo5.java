package preparatorios.ejem05;

import java.io.File;
import java.io.IOException;

public class ejemplo5 {

	public static void main(String[] args) {
		CLibreria libreria;
		File fichero;
		int numero;
		int codigo;

		fichero = new File("ejem05.dat");
		try {
			libreria = new CLibreria(fichero);
			do {
				numero = libreria.dameOpcion();
				switch (numero) {
				case 1:
					libreria.llenar();
					System.out.println("Libreria LLENA");
					break;
				case 2:
					libreria.vaciar();
					System.out.println("Libreria VACIA");
					break;
				case 3:
					libreria.mostrar();
					break;
				case 4:
					System.out.print("Dame código de libro: ");
					codigo = Leer.datoInt();
					libreria.mostrarLibro(codigo);
					break;
				case 5:
					libreria.insertarLibro();
					break;
				case 6:
					System.out.print("Dame código de libro: ");
					codigo = Leer.datoInt();
					libreria.modificarLibro(codigo);
					break;
				case 7:
					System.out.print("Dame código de libro: ");
					codigo = Leer.datoInt();
					libreria.eliminarLibro(codigo);
					break;
				case 8:
					libreria.actualizar();
					System.out.println("Libreria ACTUALIZADA");
					break;
				case 9:
					System.out.println("FINAL");
					break;
				default:
					System.out.println("OPCION Erronea");
					break;
				}
			} while (numero != 9);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
