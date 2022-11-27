package teoria.capitulo02.ordenador;

public class COrdenador1 {

	String Marca;
	String Procesador;
	String Pantalla;
	boolean OrdenadorEncendido;
	boolean Presentacion;
	
	void EncenderOrdenador() {
		System.out.println("========================================");
		if(OrdenadorEncendido == true) {
			System.out.println("El ordenador ya esta encendido.");
		}
		else { //si no esta encendido, encenderlo.
			OrdenadorEncendido = true;
			System.out.println("El ordenador se ha encendido.");
		}
		System.out.print("========================================");
	}
	
	void Estado() {
		System.out.println("\nEstado del ordenador1" + 
							"\n- Marca: " + Marca + 
							"\n- Procesador: " + Procesador +
							"\n- Pantalla: " + Pantalla);
		if(OrdenadorEncendido = true) {
			System.out.println("El ordenador1 esta encendido."); 
		}
		else {
			System.out.println("El ordenador1 esta apagado"); 
		}

	}
	
	public static void main(String[] args) {
	
		COrdenador1 MiOrdenador = new COrdenador1();
		MiOrdenador.Marca = "Ast";
		MiOrdenador.Procesador = "Intel Pentium";
		MiOrdenador.Pantalla = "TFT";
		MiOrdenador.EncenderOrdenador();
		MiOrdenador.Estado();
		
	}
}
