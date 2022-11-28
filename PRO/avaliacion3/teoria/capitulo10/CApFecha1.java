package teoria.capitulo10;

import misClases.teoria.CCuentaAhorro;
import misClases.teoria.CCuentaCorriente;
import misClases.teoria.CCuentaCorrienteConIn;
import misClases.teoria.IFecha;

public class CApFecha1 {

	public static void main(String[] args) {
		
		IFecha[] cuentas = new IFecha[3];
	    
		CCuentaAhorro cliente1 = new CCuentaAhorro();
		cuentas[0] = (IFecha)cliente1;
		((CCuentaAhorro)cuentas[0]).asignarNombre("cliente1");
		System.out.println
		(((CCuentaAhorro)cuentas[0]).obtenerNombre());
		System.out.println
		(((CCuentaAhorro)cuentas[0]).intereses());
	    
		CCuentaCorriente cliente2 = new CCuentaCorriente();
		cuentas[1] = (IFecha)cliente2;
		((CCuentaCorriente)cuentas[1]).asignarNombre("cliente2");
		System.out.println
		(((CCuentaCorriente)cuentas[1]).obtenerNombre());
		System.out.println
		(((CCuentaCorriente)cuentas[1]).intereses());
	    
		CCuentaCorrienteConIn cliente3 = 
				new CCuentaCorrienteConIn();
		cuentas[2] = (IFecha)cliente3;
		((CCuentaCorrienteConIn)cuentas[2]).asignarNombre
		("cliente3");
		System.out.println
		(((CCuentaCorrienteConIn)cuentas[2]).obtenerNombre());
		System.out.println
		(((CCuentaCorrienteConIn)cuentas[2]).intereses());
	    
	}

}
