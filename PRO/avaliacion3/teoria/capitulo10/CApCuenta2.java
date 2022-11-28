package teoria.capitulo10;

public class CApCuenta2 {

	public static void main(String[] args) {
		CCuentaAhorro cliente01 = new CCuentaAhorro
				("Un nombre", "Una cuenta", 10000, 3.5, 30);
		
		/*System.out.println(cliente01.obtenerNombre());
		System.out.println(cliente01.obtenerCuenta());
		System.out.println(cliente01.estado());
		System.out.println(cliente01.obtenerTipoDeInteres());
		System.out.println(cliente01.intereses());
		
		CCuentaCorrienteConIn cliente02 = 
				new CCuentaCorrienteConIn();
		cliente02.asignarNombre("cliente 02");
		cliente02.asignarCuenta("123456789");
		cliente02.asignarTipoDeInteres(3.0);
		cliente02.asignarTransExentas(0);
		cliente02.asignarImportePorTrans(1.0);
		
		cliente02.ingreso(20000);
		cliente02.reintegro(10000);
		cliente02.intereses();
		cliente02.comisiones();
		System.out.println(cliente02.obtenerNombre());
		System.out.println(cliente02.estado());*/
		
		// codigo sacado de CApCuenta2 de Gonzalo 
		cliente01.asignarNombre("Perfecta Mansión");
		cliente01.asignarCuenta("CCA-1357");
		cliente01.asignarTipoDeInteres(2.5);
		cliente01.asignarCuotaManten(300);
		cliente01.ingreso(1000000);
		cliente01.reintegro(35000);
		cliente01.comisiones();
		
		System.out.println(cliente01.obtenerNombre());
		System.out.println(cliente01.obtenerCuenta());
		System.out.println(cliente01.obtenerTipoDeInteres());
		System.out.println(cliente01.obtenerCuotaManten());
		System.out.println(cliente01.estado());
	}
}
