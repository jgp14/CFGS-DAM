package teoria.capitulo02.ordenador;

public class CApOrdenador2 {

	public static void main (String[] args){
		COrdenador2 MiOrdenador = new COrdenador2();
		MiOrdenador.Marca = "Ast";
		MiOrdenador.Procesador = "Intel Pentium";
		MiOrdenador.Pantalla = "TFT";
		MiOrdenador.EncenderOrdenador();
		MiOrdenador.Estado();
		MiOrdenador.ApagarOrdenador();
		MiOrdenador.Estado();
	}
}
			
class COrdenador2 {
		
	String Marca;
	String Procesador;
	String Pantalla;
	boolean OrdenadorEncendido;
	boolean Presentacion;
		
	void EncenderOrdenador() {
		System.out.println("========================================");
		if(OrdenadorEncendido == true) {
			System.out.println("El ordenador2 ya está encendido.");
		}
		else { //si no esta encendido, encenderlo.
			OrdenadorEncendido = true;
			System.out.println("El ordenador2 se ha encendido.");
		}
		System.out.print("========================================");
	}
		
	void ApagarOrdenador() {
		System.out.println("========================================");
		if(OrdenadorEncendido == false) {
			System.out.println("El ordenador2 ya está apagado.");
		}
		else { //si no esta encendido, encenderlo.
			OrdenadorEncendido = false;
			System.out.println("El ordenador2 se ha apagado.");
		}
		System.out.print("========================================");
	}
	
	void Estado() {
		System.out.println("\nEstado del ordenador2" + 
							"\n- Marca: " + Marca + 
							"\n- Procesador: " + Procesador +
							"\n- Pantalla: " + Pantalla);
		if(OrdenadorEncendido) {
			System.out.println("El ordenador2 está encendido."); 
		}
		else {
			System.out.println("El ordenador2 está apagado"); 
		}
	}
}


