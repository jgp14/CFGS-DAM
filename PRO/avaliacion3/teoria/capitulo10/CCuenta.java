package teoria.capitulo10;

public abstract class CCuenta {
	// Atributos
	private String nombre;
	private String cuenta;
	private double saldo;
	private double tipoDeInteres;
	
	// Metodos
	public CCuenta() { }
	public CCuenta
	(String nom, String cue, double sal, double tipo) {
		asignarNombre(nom);
		asignarCuenta(cue);
		ingreso(sal);
		asignarTipoDeInteres(tipo);
	}
	
	public void asignarNombre(String nom) {
		if(nom.length() == 0) {
			System.out.println("Error: cadena vacia");
			return;
		} nombre = nom;
	}
	
	public String obtenerNombre() {return nombre; }
	
	public void asignarCuenta(String cue) {
		if(cue.length() == 0) {
			System.out.println("Error: cuenta no valida");
			return;
		}
		cuenta = cue;
	}
	
	public String obtenerCuenta() {
		return cuenta;
	}
	
	public double estado() {
		return saldo;
	}
	
	public abstract void comisiones();
	
	public abstract double intereses();
	
	public void ingreso(double cantidad) {
		if(cantidad < 0){
			System.out.println("Error: cantidad negativa");
			return;
		}
		saldo += cantidad;
	}
	
	public void reintegro(double cantidad) {
		if(saldo - cantidad < 0) {
			System.out.println("Error: no dispone de saldo");
			return;
		}
		saldo -= cantidad;
	}
	
	public double obtenerTipoDeInteres() {
		return tipoDeInteres;
	}
	
	public void asignarTipoDeInteres(double tipo) {
		if(tipo < 0) {
			System.out.println("Error: tipo no valido");
			return;
		}
		tipoDeInteres = tipo;
	}

}
