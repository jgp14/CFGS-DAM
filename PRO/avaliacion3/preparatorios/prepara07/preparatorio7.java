package preparatorios.prepara07;

import java.io.File;

public class preparatorio7 {

	public static void main(String[] args) {
		CFruteria fruteria;
		File fichero;
		int numero;
		String codigo;
		
		fichero = new File("prepara07.dat");
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
				System.out.print("Dame codigo de fruta: ");
				codigo = Leer.datoString();
				fruteria.modificarFruta(codigo);
				break;
			case 7:
				System.out.print("Dame codigo de fruta: ");
				codigo = Leer.datoString();
				fruteria.eliminarFruta(codigo);
				break;
			case 8:
				fruteria.salvar();
				System.out.println("Fruteria SALVADA en fichero");
				break;
			case 9:
				fruteria.restaurar();
				System.out.println("Fruteria RESTAURADA de fichero");
				break;
			case 10:
				System.out.println("FINAL");
				break;
			default:
				System.out.println("OPCION Erronea");
				break;
			}
		} while (numero != 10);
	}
}
