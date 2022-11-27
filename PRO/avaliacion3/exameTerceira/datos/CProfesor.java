package exameTerceira.datos;

public class CProfesor {
	private String codigo;
	private String nombre;
	private String aula;
	private float baremo;

	public CProfesor(String cod, String nom, String aul, float bar) {
		codigo = cod;
		nombre = nom;
		aula = aul;
		baremo = bar;
	}

	public void setCodigo(String cod) {
		codigo = cod;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setNombre(String nom) {
		nombre = nom;
	}

	public String getNombre() {
		return nombre;
	}

	public void setAula(String aul) {
		aula = aul;
	}

	public String getAula() {
		return aula;
	}
	
	public void setBaremo(float bar) {
		baremo = bar;
	}

	public float getBaremo() {
		return baremo;
	}

	public void mostrar() {
		System.out.println(codigo + "\t" + nombre 
				+ "\t\t" + aula + "\t\t" + baremo);
	}
}
