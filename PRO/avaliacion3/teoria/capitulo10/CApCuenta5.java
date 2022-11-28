package teoria.capitulo10;

public class CApCuenta5 {

	public static void main(String[] args) {
		
		System.out.println("---------------------------");
		/*CCuentaAhorro cliente01 = new CCuentaAhorro
				("Juanjo Martinez", "9876543210");*/
		
		System.out.println("---------------------------");
		CCuentaAhorro cliente02 = new CCuentaAhorro();
		
		System.out.println();
		System.out.println(cliente02.obtenerNombre());
		System.out.println(cliente02.obtenerCuenta());
		System.out.println(cliente02.estado());
		System.out.println(cliente02.obtenerTipoDeInteres());
		System.out.println(cliente02.obtenerCuotaManten());
		System.out.println(cliente02.intereses());
		
		System.out.println();
		cliente02.asignarNombre("Marta Rial Compostela");
		cliente02.asignarCuenta("1234567890");
		cliente02.ingreso(20000);
		cliente02.asignarTipoDeInteres(2);
	}

}
