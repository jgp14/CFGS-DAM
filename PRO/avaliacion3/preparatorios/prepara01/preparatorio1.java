package preparatorios.prepara01;

public class preparatorio1 {

	public static void main(String[] args) {
		CFruteria fruteria;
		fruteria = new CFruteria();
		int numero;
		String codigo;

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
				System.out.print("Dame codigo de fruta: ");
				codigo = Leer.dato();
				fruteria.mostrarFruta(codigo);
				break;
			case 5:
				System.out.print("Dame codigo de fruta: ");
				codigo = Leer.dato();
				fruteria.eliminarFruta(codigo);
				break;
			case 6:
				System.out.println("FINAL");
				break;
			default:
				System.out.println("OPCION Erronea");
				break;
			}
		} while (numero != 6);
	}
	
}
