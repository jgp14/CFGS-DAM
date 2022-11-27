package teoria.capitulo02.ordenador;

public class COrdenador3 {
	String Marca;
	String Procesador;
	String Pantalla;
	boolean OrdenadorEncendido;
	boolean Presentacion;
		
	void EncenderOrdenador() {
		System.out.println("========================================");
		if(OrdenadorEncendido == true) {
			System.out.println("El ordenador ya está encendido.");
		}
		else { //si no esta encendido, encenderlo.
			OrdenadorEncendido = true;
			System.out.println("El ordenador se ha encendido.");
		}
		System.out.print("========================================");
	}
	
	void ApagarOrdenador() {
		System.out.println("========================================");
		if(OrdenadorEncendido == false) {
			System.out.println("El ordenador3 ya está apagado.");
		}
		else { //si no esta encendido, encenderlo.
			OrdenadorEncendido = false;
			System.out.println("El ordenador3 se ha apagado.");
		}
		System.out.print("========================================");
	}
		
	void Estado() {
		System.out.println("\nEstado del ordenador3" + 
							"\n- Marca: " + Marca + 
							"\n- Procesador: " + Procesador +
							"\n- Pantalla: " + Pantalla);
		if(OrdenadorEncendido) {
			System.out.println("El ordenador3 está encendido."); 
		}
		else {
			System.out.println("El ordenador3 está apagado"); 
		}
	}
}