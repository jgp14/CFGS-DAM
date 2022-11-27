package compilador313_315;

import misClases.avaliacion3.Fichero;

class compi314 {

	public static void main(String[] args) {
		Fichero fichero = new Fichero();
		Fichero ficheroOrigen = new Fichero();
		Fichero ficheroDestino = new Fichero();
		String mensaje;
		int numero;

		do {
			numero = Fichero.dameOpcion();
			switch (numero) {
				case 1:
					fichero.asignaFichero();
					fichero.amosa();
					break;
				case 2:
					mensaje = "Nombre del fichero origen: ";
					ficheroOrigen.asignaFicheroLectura(mensaje);
					mensaje = "Nombre del fichero destino: ";
					ficheroDestino.asignaFicheroEscritura(mensaje);
					ficheroOrigen.copia(ficheroDestino);
					break;
				case 3:
					fichero.asignaFichero();
					fichero.amosaFinal();
					break;
				case 4:
					fichero.asignaFichero();
					fichero.amosaInicio();
					break;
				case 5:
					fichero.asignaFichero();
					fichero.amosaLineaMaior();
					break;
				case 6:
					fichero.asignaFichero();
					fichero.amosaLineaMaiorMenor();
					break;
				case 7:
					System.out.println("Opcion NO Implementada");
					break;
				case 8:
					System.out.println("FINAL");
					break;
				default:
					System.out.println("OPCION Erronea");
					break;
			} 
		} while (numero != 8);
	}
}
