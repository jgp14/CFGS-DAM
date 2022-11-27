package misClases.teoria;

public class CCuentaAhorro extends CCuenta {

	// Atributos
	private double cuotaMantenimiento;
	
	//Metodos
	public CCuentaAhorro() { // Constructor sin parametros
		System.out.println("--->Constructor CCuentaAhorro "
				+ "SIN parametros de " + obtenerNombre());
	} 

	public CCuentaAhorro
	(String nom, String cue, double sal, double tipo, double cuo) {
		super(nom, cue, sal, tipo);
		asignarCuotaManten(cuo);
		System.out.println("--->Constructor CCuentaAhorro "
				+ "CON parametros de " + obtenerNombre());
	}

	public void asignarCuotaManten(double cantidad) {
		if(cantidad < 0) 
			System.out.println("Error: cantidad negativa");
		cuotaMantenimiento = cantidad;
	}
	
	public double obtenerCuotaManten() {
		return cuotaMantenimiento;
	}
	
	public void comisiones() throws ESaldoInsuficiente{
		// Se aplican mensualmente por 
		// el mantenimiento de la cuenta
		//GregorianCalendar fechaActual = new GregorianCalendar();
		//int dia = fechaActual.get(Calendar.DAY_OF_MONTH);
		
		if(dia() == 1) 
			reintegro(cuotaMantenimiento);
	}
	
	public double intereses() {
		if(dia() != 1) return 0.0;
		// Acumular los intereses por mes 
		// solo los dias 1 de cada mes
		double interesesProducidos = estado() * 
				obtenerTipoDeInteres() / 1200.0;
		ingreso(interesesProducidos);
		//Devolver el interes mensual por si fuera necesario
		return interesesProducidos;
	}

	protected void finalize() throws Throwable {
	    System.out.println
	    ("--->Destructor CCuentaAhorro de " + obtenerNombre());
	    super.finalize();
	}

}
