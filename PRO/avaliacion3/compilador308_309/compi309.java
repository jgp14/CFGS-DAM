package compilador308_309;

import misClases.avaliacion3.Fichero;

class compi309 {

	public static void main(String[] args) {
		Fichero ficheroOrigen = new Fichero();	
		Fichero ficheroDestino = new Fichero();
		String mensaje;
		
		mensaje = "Nombre del fichero origen: ";
		ficheroOrigen.asignaFicheroLectura(mensaje);
		mensaje = "Nombre del fichero destino: ";
		ficheroDestino.asignaFicheroEscritura(mensaje);
		ficheroOrigen.copia(ficheroDestino);
		System.out.print(
			"Copiado el fichero: " + ficheroOrigen.dameNombre() 
			+ " en el fichero: " + ficheroDestino.dameNombre());
		System.out.println
			("\nAmosamos el fichero origen: " + 
			ficheroOrigen.dameNombre());
		ficheroOrigen.amosa();
		System.out.println
			("\nAmosamos el fichero destino: " + 
			ficheroDestino.dameNombre());
		ficheroDestino.amosa();
	}
}
