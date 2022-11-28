package preparatorios.prepara05;

import java.io.File;
import java.io.IOException;

public class preparatorio5 {

	public static void main(String[] args) {
		CFruteria fruteria;
		File fichero;
		int numero;
		String codigo;

		fichero = new File("prepa05.dat");
		try {
			fruteria = new CFruteria(fichero);
			do {
				numero = fruteria.dameOpcion();
				switch (numero) {
				case 1:
					fruteria.llenar();
					System.out.println("Fruteria LLENA");
					break;
				case 2:
					fruteria.vaciar();
					System.out.println("Fruteria VACIA");
					break;
				case 3:
					fruteria.mostrar();
					break;
				case 4:
					System.out.print("Dame código de fruta: ");
					codigo = Leer.datoString();
					fruteria.mostrarFruta(codigo);
					break;
				case 5:
					fruteria.insertarFruta();
					break;
				case 6:
					System.out.print("Dame código de fruta: ");
					codigo = Leer.datoString();
					fruteria.modificarFruta(codigo);
					break;
				case 7:
					System.out.print("Dame código de fruta: ");
					codigo = Leer.datoString();
					fruteria.eliminarFruta(codigo);
					break;
				case 8:
					fruteria.actualizar();
					System.out.println("Fruteria ACTUALIZADA");
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
