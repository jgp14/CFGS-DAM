package teoria.capitulo11;

import misClases.teoria.CCuentaAhorro;
import misClases.teoria.CCuentaCorriente;
import misClases.teoria.CCuentaCorrienteConIn;
import misClases.teoria.ESaldoInsuficiente;
import misClases.teoria.IFecha;

public class CApError {

	public static void main(String[] args) {

		IFecha[] cuentas = new IFecha[3];
		CCuentaAhorro cliente1 = new CCuentaAhorro();
		cuentas[0] = (IFecha)cliente1;
		((CCuentaAhorro)cuentas[0]).asignarNombre("CLIENTE1");
		try {
			((CCuentaAhorro) cuentas[0]).reintegro(1000);
		} catch (ESaldoInsuficiente e) {
			System.out.println(e.mensaje());
		}
		CCuentaCorriente cliente2 = new CCuentaCorriente();
		cuentas[1] = (IFecha)cliente2;
		((CCuentaCorriente)cuentas[1]).asignarNombre("CLIENTE2");
		try {
			((CCuentaCorriente)cuentas[1]).reintegro(2000);
		}catch(ESaldoInsuficiente e) {
			System.out.println(e.mensaje());
		}
		CCuentaCorrienteConIn cliente3 = 
				new CCuentaCorrienteConIn();
		cuentas[2] = (IFecha)cliente3;
		((CCuentaCorrienteConIn)cuentas[2]).asignarNombre
		("CLIENTE3");
		try {
			((CCuentaCorrienteConIn)cuentas[2]).reintegro(3000);
		} catch (ESaldoInsuficiente e) {
			System.out.println(e.mensaje());
		}
	}

}
