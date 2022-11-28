package teoria.capitulo10;

public class CPersona {

	private String nombre;
	private String direccion;
	private CFecha fechaNacimiento;
	private long telefono;

	
	private class CFecha {
		private int dia, mes, ano;
		private CFecha(int dd, int mm, int aa) {
			dia = dd; mes = mm; ano = aa;
		}
	}
	
	public CPersona() { }

	public CPersona(String nom, int dd, int mm, int aa) {
		nombre = nom;
		fechaNacimiento = new CFecha(dd, mm, aa); 
	}
	
	public CPersona(String nom, String dir, long tel) {
		nombre = nom;
		direccion = dir;
		telefono = tel;
	}

	public String obtenerNombre() {return nombre;}
	
	public String obtenerDireccion() {return direccion;}
	
	public long obtenerTelefono() {return telefono;}
	
	public void mostrarPersona() {
		System.out.println(obtenerNombre());
		System.out.println(obtenerDireccion());
		System.out.println(obtenerTelefono());
		System.out.println();		
	}
	
	public String obtenerFechaNa() {
		return fechaNacimiento.dia + "/" + 
				fechaNacimiento.mes + "/" +
				fechaNacimiento.ano;
	}
	
}
