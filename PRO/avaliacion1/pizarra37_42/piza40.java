package pizarra37_42;

import misClases.avaliacion1.CNotas;

public class piza40 {

	public static void main(String[] args) {
		/*CNotas calificaciones = new CNotas();
		calificaciones.mostraNotas();
		System.out.println();
		calificaciones.dameMaior();*/
		
		CNotas calificaciones = new CNotas();
		int maior; 
		float notaMaior;
		
		calificaciones.mostraNotas();
		
		maior = calificaciones.dameMaior();
		notaMaior = calificaciones.dameNota(maior);
		System.out.println("\nAlumno con MAIOR nota");
		System.out.println("=====================");
		System.out.println("Alumno " + (maior + 1) + ": " + notaMaior);
	}
}
