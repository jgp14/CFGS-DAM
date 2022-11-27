package exameTerceira;

import java.io.File;
import java.io.IOException;

import exameTerceira.datos.CDepartamento;
import exameTerceira.utilidades.Leer;

public class terceira {

	public static void main(String[] args) {
		CDepartamento departamento;
		File fichero;
		int numero;
		String codigo;

		fichero = new File("exame.dat");
		try {
			departamento = new CDepartamento(fichero);
			do {
				numero = departamento.dameOpcion();
				switch (numero) {
				case 1:
					departamento.llenar();
					System.out.println("Departamento con profesores");
					break;
				case 2:
					departamento.vaciar();
					System.out.println("Departamento sin profesores");
					break;
				case 3:
					departamento.mostrar();
					break;
				case 4:
					System.out.print("Dame codigo de profesor: ");
					codigo = Leer.datoString();
					departamento.mostrarProfesor(codigo);
					break;
				case 5:
					departamento.insertarProfesor();
					break;
				case 6:
					System.out.print("Dame codigo de profesor: ");
					codigo = Leer.datoString();
					departamento.modificarProfesor(codigo);
					break;
				case 7:
					System.out.print("Dame codigo de profesor: ");
					codigo = Leer.datoString();
					departamento.eliminarProfesor(codigo);
					break;
				case 8:
					departamento.actualizar();
					System.out.println("Departamento ACTUALIZADO");
					break;
				case 9:
					System.out.println("FINAL");
					break;
				default:
					System.out.println("OPCION Erronea");
					break;
				}
			} while (numero != 9);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
