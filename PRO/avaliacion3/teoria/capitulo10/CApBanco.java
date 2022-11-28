package teoria.capitulo10;

import java.io.PrintStream;
import misClases.teoria.CBanco;
import misClases.teoria.CCuenta;
import misClases.teoria.CCuentaAhorro;
import misClases.teoria.CCuentaCorriente;
import misClases.teoria.CCuentaCorrienteConIn;
import misClases.teoria.ESaldoInsuficiente;
import misClases.utilidades.Leer;

public class CApBanco {

	public static CCuenta leerDatos(int op) { 
		CCuenta obj = null;
		String nombre, cuenta;
		double saldo, tipoi, mant;
		System.out.print("Nombre..................: ");
		nombre = Leer.dato();
		System.out.print("Cuenta..................: ");
		cuenta = Leer.dato();
		System.out.print("Saldo...................: ");
		saldo = Leer.datoDouble();
		System.out.print("Tipo de interes.........: ");
		tipoi = Leer.datoDouble();
		if(op == 1) {
			System.out.print("Mantenimiento.......:");
			mant = Leer.datoDouble();
			obj = new CCuentaAhorro
					(nombre, cuenta, saldo, tipoi, mant);
		}
		
		else {
			int transex;
			double imptrans;
			System.out.print("Importe por transaccion: ");
			imptrans = Leer.datoDouble();
			System.out.print("Transacciones exentas..:");
			transex = Leer.datoInt();
			
			if(op == 2)
				obj = new CCuentaCorriente
				(nombre, cuenta, saldo, tipoi, imptrans, transex);
			else
				obj = new CCuentaCorrienteConIn
				(nombre, cuenta, saldo, tipoi, imptrans, transex);
		}
		return obj; 
	}
	
	public static int menu() { 
		System.out.print("\n\n");
		System.out.println("1. Saldo");
		System.out.println("2. Buscar siguiente");
		System.out.println("3. Ingreso");
		System.out.println("4. Reintegro");
		System.out.println("5. Anhadir");
		System.out.println("6. Eliminar");
		System.out.println("7. Mantenimiento");
		System.out.println("8. Mostrar");
		System.out.println("9. Salir");
		System.out.println();
		System.out.println("   Opcion: ");
		int op;
		do
			op = Leer.datoInt();
		while(op < 1 || op > 9);
		return op;

	}
	
	public static void main(String[] args) 
			throws ESaldoInsuficiente {
		// Definir una referencia al flujo 
		// estandar de salida: flujoS
		PrintStream flujoS = System.out;
		
		// Crear un objeto banco vacio (con cero elementos)
		CBanco banco = new CBanco();
		
		int opcion = 0, pos = -1;
		String cadenabuscar = null;
		String cuenta;
		double cantidad;
		boolean eliminado = false;
		
		do {
			opcion = menu();
			switch(opcion) {
				case 1: // saldo
					flujoS.print
					("Nombre o cuenta, total o parcial");
					cadenabuscar = Leer.dato();
					pos = banco.buscar(cadenabuscar, 0);
					if(pos == 1) {
						if(banco.longitud() != 0)
							flujoS.println("busqueda fallida");
						else
							flujoS.println("no hay clientes");
					}
					else {
						flujoS.println
						(banco.clienteEn(pos).obtenerNombre());
						flujoS.println
						(banco.clienteEn(pos).obtenerCuenta());
						flujoS.println
						(banco.clienteEn(pos).estado());
					}
					break;
				case 2: // buscar siguiente
					pos = banco.buscar(cadenabuscar, pos + 1);
					if(pos == 1) {
						if(banco.longitud() != 0)
							flujoS.println("busqueda fallida");
						else
							flujoS.println("no hay clientes");
					}
					else {
						flujoS.println
						(banco.clienteEn(pos).obtenerNombre());
						flujoS.println
						(banco.clienteEn(pos).obtenerCuenta());
						flujoS.println
						(banco.clienteEn(pos).estado());
					}
					break;
				case 3: // ingreso
				case 4: // reintegro
					flujoS.print("Cuenta: "); 
					cuenta = Leer.dato();
					pos = banco.buscar(cuenta, 0);
					if(pos == -1) {
						if(banco.longitud() != 0)
							flujoS.println("busqueda fallida");
						else
							flujoS.println("no hay clientes");
					}
					else {
						flujoS.print("Cantidad: "); 
						cantidad = Leer.datoDouble();
						if(opcion == 3)
							banco.clienteEn(pos).ingreso(cantidad);
						else
							banco.clienteEn(pos).reintegro(cantidad);
					}
					break;
				case 5: // anhadir
					flujoS.print
					("Tipo de cuenta: 1-(CA), 2-(CC), 3-CCI ");
					do 
						opcion = Leer.datoInt();
					while(opcion < 1 || opcion > 3);
					banco.anhadir(leerDatos(opcion));
					break;
				case 6: // eliminar
					flujoS.print("Cuenta: "); 
					cuenta = Leer.dato();
					eliminado = banco.eliminar(cuenta);
					if(eliminado)
						flujoS.println("registro eliminado");
					else {
						if(banco.longitud() != 0)
							flujoS.println("cuenta no encontrada");
						else
							flujoS.println("no hay clientes");
					}
					break;
				case 7: // mantenimiento
					for(pos = 0; pos < banco.longitud(); pos++) {
						banco.clienteEn(pos).comisiones();
						banco.clienteEn(pos).intereses();
					}
					break;
				case 8:
					banco.mostrar();
					break;
				case 9:
					banco = null;
					break;
			}
		} while (opcion != 9);
	
	}
	
}
