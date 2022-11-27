package misClases.teoria;

public class CComputador {
	private String Marca; 
	private String Procesador; 
	private String Pantalla; 
	private String Computador; 
	static byte Garantia;
	boolean ComputadorEncendido;
	boolean Presentacion;
	

	public void EstablecerMarca(String marca) {
		Marca = marca; 
	}

	public void EstablecerPantalla(String pantalla) {
		Pantalla = pantalla;
	}

	public static void EstablecerGarantia(byte garantia) {
		Garantia = garantia;
	}

	public void EstablecerProcesador(String procesador) {
		Procesador = procesador;
	}

	public void EstablecerComputador(String computador) {
		Computador = computador;
	}
	
	
public void EncenderComputador() {
	System.out.println("========================================");
	if(ComputadorEncendido == true) {
		System.out.println("El ordenador ya está encendido.");
	}
	else { //si no esta encendido, encenderlo.
		ComputadorEncendido = true;
		System.out.println("El ordenador se ha encendido.");
	}
	System.out.print("========================================");
}

public void ApagarComputador() {
	System.out.println("========================================");
	if(ComputadorEncendido == false) {
		System.out.println("El ordenador ya está apagado.");
	}
	else { //si no esta encendido, encenderlo.
		ComputadorEncendido = false;
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
	System.out.println("\nEstado del computador" +
						"\n- Garantia: " + Garantia + 
						"\n- Marca: " + Marca + 
						"\n- Procesador: " + Procesador +
						"\n- Pantalla: " + Pantalla + 
						"\n- Computador: " + Computador);
	if(ComputadorEncendido) {
		System.out.println("El ordenador está encendido."); 
	}
	else {
		System.out.println("El ordenador está apagado"); 
	}
}

}
