package misClases.teoria;

public class COrdenador {
	String Marca = "Ast";
	String Procesador = "Intel Pentium";
	String Pantalla = "TFT";
	boolean OrdenadorEncendido;
	boolean Presentacion;
		
	public void EncenderOrdenador() {
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
	
	public void ApagarOrdenador() {
		System.out.println("========================================");
		if(OrdenadorEncendido == false) {
			System.out.println("El ordenador ya está apagado.");
		}
		else { //si no esta encendido, encenderlo.
			OrdenadorEncendido = false;
			System.out.println("El ordenador se ha apagado.");
		}
		System.out.print("========================================");
	}
	
	public void ModificarOrdenador() {
		Marca = "DELL";
		Procesador = "AMD";
		Pantalla = "CRT";
		System.out.println("\n" +
							"    TRAS LLAMAR AL METODO MODIFICA");
		System.out.println("    ******************************");
		System.out.println("========================================");
	
	}	
	
	public void Estado() {
		System.out.println("\nEstado del ordenador" + 
							"\n- Marca: " + Marca + 
							"\n- Procesador: " + Procesador +
							"\n- Pantalla: " + Pantalla);
		if(OrdenadorEncendido) {
			System.out.println("El ordenador está encendido."); 
		}
		else {
			System.out.println("El ordenador está apagado"); 
		}
	}
}
