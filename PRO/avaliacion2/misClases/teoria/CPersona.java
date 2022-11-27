package misClases.teoria;

public class CPersona {

	// Atributos
	private String nombre; 
	private String direccion;
	private long telefono;
	
	// Metodos
	public CPersona() {}
	public CPersona(String nom, String dir, long tel) {
		nombre = nom;
		direccion = dir;
		telefono = tel;
	}
	
	public void asignarNombre(String nom) {
		nombre = nom; 
	}
	
	public String obtenerNombre() {
		return nombre;
	}
	
	public void asignarDireccion(String dir) {
		direccion = dir;
	}
	
	public String obtenerDireccion() {
		return direccion;
	}
	
	public void asignarTelefono(long tel) {
		telefono = tel;
	}
	
	public long obtenerTelefono() {
		return telefono;
	}
	
	public void mostrarPersona() {
		System.out.println(nombre);
		System.out.println(direccion);
		System.out.println(telefono);
		System.out.println();		
	}
}
