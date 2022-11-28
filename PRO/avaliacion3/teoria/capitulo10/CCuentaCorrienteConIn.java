package teoria.capitulo10;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CCuentaCorrienteConIn extends CCuentaCorriente{

	public CCuentaCorrienteConIn() {} 
	// constructor sin paramertos
	
	public CCuentaCorrienteConIn(String nom, String cue, 
	double sal, double tipo, double imptrans, int transex) {
		// Invocar al constructor de la superclase
		super(nom, cue, sal, tipo, imptrans, transex);
	}
	
	public double intereses() {
		GregorianCalendar fechaActual = new GregorianCalendar();
		int dia = fechaActual.get(Calendar.DAY_OF_MONTH);
		
		if(dia != 1 || estado() < 3000) return 0.0;
		
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
