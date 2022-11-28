package teoria.capitulo10;

public class CApTest8E {

	public static void main(String[] args) {
		CCuenta cliente;
		
		CCuentaCorrienteConIn cliente22, cliente44;
		cliente22 = new CCuentaCorrienteConIn
			("Cliente02", "9876543210", 30000, 3.5,6.0,5);
		
		System.out.println("============================");
		cliente = cliente22;
		cliente22 = (CCuentaCorrienteConIn)cliente;
		System.out.println(cliente.obtenerNombre());
		System.out.println(cliente.intereses());
		//
		//
		System.out.println();
		
		System.out.println("============================");
		// cliente44 = cliente;
		cliente44 = (CCuentaCorrienteConIn) cliente;
	}

}
