package misClases.teoria;

public class CCuentaCorrienteConIn extends CCuentaCorriente{

	public CCuentaCorrienteConIn() { // constructor sin paramertos
		System.out.println("--->Constructor CCuentaCorrienteConIntereses "
				+ "SIN parametros de "+ obtenerNombre());
	} 
	
	public CCuentaCorrienteConIn(String nom, String cue, 
	double sal, double tipo, double imptrans, int transex) {
		// Invocar al constructor de la superclase
		super(nom, cue, sal, tipo, imptrans, transex);
	}
	
	public double intereses() {
		if(dia() != 1 || estado() < 3000) return 0.0;
		
		// Acumular interes mensual solo los dias 1 de cada mes
		double interesesProducidos = 0.0;
		interesesProducidos = estado() * obtenerTipoDeInteres() / 1200.0;
		ingreso(interesesProducidos);
		// Este ingreso no debe incrementar las transacciones
		decrementarTransacciones();
		
		// Devolver el interes mensual por si fuera necesario
		return interesesProducidos;
	}
	
}