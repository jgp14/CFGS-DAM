package pizarra37_42;

import misClases.avaliacion1.CNotas;

public class piza41 {

	public static void main(String[] args) {
		/*CNotas cualificaciones = new CNotas();
		cualificaciones.mostraNotas();
		System.out.println();
		cualificaciones.dameMenor();*/
		
		CNotas calificaciones = new CNotas();
		int menor; 
		float notaMenor; 
		
		calificaciones.mostraNotas();
		
		menor = calificaciones.dameMenor();
		notaMenor = calificaciones.dameNota(menor);
		System.out.println("\nAlumno con MENOR nota");
		System.out.println("=====================");
		System.out.println("Alumno " + (menor + 1) + ": " + notaMenor);
	}
}
