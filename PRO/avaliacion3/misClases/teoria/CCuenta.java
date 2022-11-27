package misClases.teoria;

import java.util.GregorianCalendar;

public abstract class CCuenta implements IFecha{
	
	// Atributos
	private String nombre;
	private String cuenta;
	private double saldo;
	private double tipoDeInteres;
	
	// Metodos
	public CCuenta() { 
		System.out.println("--->Constructor CCuenta "
				+ "SIN parametros de " + nombre);
	}
	
	public CCuenta
	(String nom, String cue, double sal, double tipo) {
		asignarNombre(nom);
		asignarCuenta(cue);
		ingreso(sal);
		asignarTipoDeInteres(tipo);
		System.out.println("--->Constructor CCuenta "
				+ "CON parametros de " + nombre);
	}
	
	public void asignarNombre(String nom) {
		if(nom.length() == 0)
			System.out.println("Error: cadena vacia");
		nombre = nom;
	}
	
	public String obtenerNombre() {
		return nombre; 
	}
	
	public void asignarCuenta(String cue) {
		if(cue.length() == 0)
			System.out.println("Error: cuenta no valida");
		cuenta = cue;
	}
	
	public String obtenerCuenta() {
		return cuenta;
	}
	
	public double estado() {
		return saldo;
	}
	
	public abstract void comisiones() throws ESaldoInsuficiente;
	
	public abstract double intereses();
	
	public void ingreso(double cantidad) {
		if(cantidad < 0)
			System.out.println("Error: cantidad negativa");
		saldo += cantidad;
	}
	
	public void reintegro(double cantidad) 
			throws ESaldoInsuficiente{
		if(saldo - cantidad < 0) 
			throw new ESaldoInsuficiente(this, cantidad);
		saldo -= cantidad;
	}
	
	public void asignarTipoDeInteres(double tipo) {
		if(tipo < 0) {
			System.out.println("Error: tipo no valido");
			return;
		}
		tipoDeInteres = tipo;
	}
	
	public double obtenerTipoDeInteres() {
		return tipoDeInteres;
	}
	
	protected void finalize() throws Throwable {
	    System.out.println
	    ("--->Destructor CCuenta de " + nombre);
	    super.finalize();
	  }
	
	public void mostrar() {
		System.out.println();
		System.out.print("Nombre.................: ");
		System.out.println(this.nombre);
		System.out.print("Cuenta.................: ");
		System.out.println(this.cuenta);
		System.out.print("Saldo..................: ");
		System.out.println(this.saldo);
		System.out.print("Tipo de interes........:");
		System.out.println(this.tipoDeInteres);
	}
	
	public int dia() {
		GregorianCalendar fechaActual = new GregorianCalendar();
		return fechaActual.get(DIA_DEL_MES);
	}
	public int mes() {return 0;} // no se necesita
	public int anho() {return 0;} // no se necesita
	
}
