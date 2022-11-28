package teoria.capitulo10;

import java.util.*;

public class CCuentaAhorro extends CCuenta implements IFecha{

	// Atributos
	private double cuotaMantenimiento;
	
	//Metodos
	public CCuentaAhorro() {} // Constructor sin parametros
	
	/*public CCuentaAhorro() {
		super();
		System.out.println(mensaje()+ "  CCuentaAhorro()");
	}*/
	
	public CCuentaAhorro
	(String nom, String cue, double sal, double tipo, double cuo) {
		super(nom, cue, sal, tipo);
		asignarCuotaManten(cuo);
	}

	public void asignarCuotaManten(double cantidad) {
		if(cantidad < 0) {
			System.out.println("Error: cantidad negativa");
			return;
		} cuotaMantenimiento = cantidad;
	}
	
	public double obtenerCuotaManten() {
		return cuotaMantenimiento;
	}
	
	public void comisiones() {
		// Se aplican mensualmente por 
		// el mantenimiento de la cuenta
		GregorianCalendar fechaActual = new GregorianCalendar();
		int dia = fechaActual.get(Calendar.DAY_OF_MONTH);
		
		if(dia == 25) reintegro(cuotaMantenimiento);
	}
	
	public double intereses() {
		GregorianCalendar fechaActual = new GregorianCalendar();
		int dia = fechaActual.get(Calendar.DAY_OF_MONTH);
		
		if(dia != 1) return 0.0;
		// Acumular los intereses por mes 
		// solo los dias 1 de cada mes
		double interesesProducidos = estado() * 
				obtenerTipoDeInteres() / 1200.0;
		ingreso(interesesProducidos);
		//Devolver el interes mensual por si fuera necesario
		return interesesProducidos;
	}
	
	// Implementacion de los metodos de la interfaz IFecha
	public int dia() {
		GregorianCalendar fechaActual = new GregorianCalendar();
		return fechaActual.get(DIA_DEL_MES);
	}
	public int mes() {return 0;} // no se necesita
	public int ano() {return 0;} // no se necesita
}
