package misClases.utilidades;

public class CDatos {
	public static String obtenerNombre() {
		String[] nombres = { 
			"Pedro", "Paula", "Juan Carlos", "Rebeca", "Mercedes", 
			"Teresa", "Carlos", "Jesus", "Marta", "Felipe", 
			"Amada", "Monica", "Ines", "Belen", "Angel", 
			"Benito", "Carmen", "Lourdes", "Ismael", "Manuel", 
			"Roberto", "Susana", "Clara", "Laura" };
		int indice = (int)(Math.random() * nombres.length);
		return nombres[indice];
	}
	  
	public static String obtenerApellido() {
		String[] nombres = { 
			"Couceiro", "Fernandez", "Arias", "Mayor", "Perez", 
			"Abad", "Conde", "Garcia", "Casal", "Suarez", 
			"Arguelles", "Rodriguez", "Martinez", "Alvarez", 
			"Bermejo", "Carrion", "Duque", "del Rio", 
			"de la Loma", "de la Granja" };
		int indice = (int)(Math.random() * nombres.length);
		return nombres[indice];
	}
	  
	public static String obtenerNombreCompleto() {
		String nombre = obtenerNombre();
		String apellido1 = obtenerApellido();
		String apellido2 = obtenerApellido();
		return String.valueOf(nombre) + " " 
				+ apellido1 + " " + apellido2;
	}
	  
	private static String obtenerTipoDireccion() {
	    String[] nombres = {"Avda.", "C/","Plaza","Ronda","Rua"};
	    int indice = (int)(Math.random() * nombres.length);
	    return nombres[indice];
	}
	  
	private static String obtenerNombreDireccion() {
	    String apellido1 = obtenerApellido();
	    String apellido2 = obtenerApellido();
	    return String.valueOf(apellido1) + " " + apellido2;
	}
	  
	private static int obtenerNumeroDireccion() {
	    int numero = (int)(Math.random() * 70.0D) + 1;
	    return numero;
	}
	  
	public static String obtenerDireccion() {
	    String tipo = obtenerTipoDireccion();
	    String nombre = obtenerNombreDireccion();
	    int numero = obtenerNumeroDireccion();
	    return String.valueOf(tipo) + " " 
	    		+ nombre + ", " + numero;
	}
	  
	public static long obtenerTelefono() {
	    long numero = (long)(Math.random() * (699999999 - 660000000 +1)) + 660000000;
	    return numero;
	}
}
