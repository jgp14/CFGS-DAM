package preparatorios.prepara06;

import java.io.File;

public class preparatorio6 {

	public static void main(String[] args) {
		int numero;
		File fichero = new File("prepara06.dat");
		CFruteria fruteria = new CFruteria(fichero);
	    do {
	    	String codigo;
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
		        	System.out.print("Dame codigo de fruta: ");
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
		        	System.out.println
		        	("Fruteria SALVADA en fichero");
		        	break;
		        case 9:
		        	fruteria.restaurar();
		        	System.out.println
		        	("Fruteria RESTAURADA de fichero");
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