package teoria.capitulo04;

import misClases.teoria.CCuenta;

public class CApCuenta {

	public static void main(String[] args) {
		
		// Abrir una cuenta con 1.000.000 a un 2%
		CCuenta cuenta = new CCuenta();
		cuenta.IngresarDinero(1000000);
		cuenta.EstablecerTipoDeInteres(2);
		
		// Operaciones 
		System.out.println(cuenta.SaldoActual());
		cuenta.IngresarDinero(500000);
		System.out.println(cuenta.SaldoActual());
		cuenta.RetirarDinero(200000);
		System.out.println(cuenta.SaldoActual());
		cuenta.AbonarIntereses();
		System.out.println(cuenta.SaldoActual());
		
	}

}