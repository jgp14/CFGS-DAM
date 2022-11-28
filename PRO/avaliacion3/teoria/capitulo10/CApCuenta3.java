package teoria.capitulo10;

public class CApCuenta3 {

	public static void main(String[] args) {
		CCuenta[] cliente = new CCuenta[100];
		// Crear objetos y guardar sus referencias en la matriz
		cliente[0] = new CCuentaAhorro
				("cliente00", "3000123450",10000, 2.5, 30);
		cliente[1] = new CCuentaCorriente
				("cliente01", "6000123450",10000, 2.0, 1.0, 6);
		cliente[2] = new CCuentaCorrienteConIn
				("cliente02", "4000123450",10000, 3.5, 1.0, 6);
		for(int i = 0; cliente[i] != null; i++) {
			System.out.println(cliente[i].obtenerNombre() + ": ");
			System.out.println(cliente[i].intereses());
		}
	}
}
