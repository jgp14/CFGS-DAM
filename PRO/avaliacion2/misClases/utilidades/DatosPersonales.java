package misClases.utilidades;

public class DatosPersonales {

	private static String[] nombres = 
	{"Monica","Amancio","Lucas","Paula","Monica",
			"Marta","Juan Antonio","Mateo, Laura"};
	
	private static String[] apellidos = 
	{"Abad","Bermejo","Arias","Llera","Agudo","Vazquez",
			"Garcia Conde","Mendez","Lago","Novoa"};
	
	public static String dameNombre() {
		int i = (int) (nombres.length * Math.random());
		return nombres[i];
	}
	
	public static String dameApellido() {
		int i = (int) (apellidos.length * Math.random());
		return apellidos[i];
	}

}
