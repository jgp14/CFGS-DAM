package teoria.capitulo10;

import misClases.teoria.CCuentaAhorro;
import misClases.teoria.ESaldoInsuficiente;

public class CApCuenta {

	private static void cliente01() throws ESaldoInsuficiente {
		  CCuentaAhorro cliente01 = new CCuentaAhorro();
		  cliente01.asignarNombre("Amancio Couso Arias");
		  cliente01.asignarCuenta("123456789");
		  cliente01.asignarTipoDeInteres(2.5D);
		  cliente01.asignarCuotaManten(300.0D);
		  cliente01.ingreso(1000000.0D);
		  cliente01.reintegro(35000.0D);
		  cliente01.comisiones();
		  System.out.println(cliente01.obtenerNombre());
		  System.out.println(cliente01.obtenerCuenta());
		  System.out.println(cliente01.estado());
		  System.out.println(cliente01.obtenerTipoDeInteres());
		  System.out.println(cliente01.obtenerCuotaManten());
	}
		  
	private static void cliente02() throws ESaldoInsuficiente {
		CCuentaAhorro cliente02 = new CCuentaAhorro
				("Benancio Compostela Rivera", 
				"987654321", 1000000.0D, 4.5D, 400.0D);
		cliente02.ingreso(200000.0D);
		cliente02.reintegro(70000.0D);
		cliente02.comisiones();
		System.out.println(cliente02.obtenerNombre());
		System.out.println(cliente02.obtenerCuenta());
		System.out.println(cliente02.estado());
		System.out.println(cliente02.obtenerTipoDeInteres());
		System.out.println(cliente02.obtenerCuotaManten());
	}
	
	public static void main(String[] args) 
			throws ESaldoInsuficiente {
		cliente01();
		cliente02();
		Runtime runtime = Runtime.getRuntime();
	    runtime.gc();
	    runtime.runFinalization();
	}
	
}
