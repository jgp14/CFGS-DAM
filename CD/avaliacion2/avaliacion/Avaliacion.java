package avaliacion;

import java.io.PrintStream;

public class Avaliacion {

	private Alumna alumna;
	private int[] cualificacions;
	
	
	public Avaliacion(Alumna alumna) {
		super();
		this.alumna = alumna;
		this.cualificacions = this.alumna.getCualificacions();
	}

	private boolean valoresPositivos() {
		boolean positivo = true;
		for(int k = 0; k< this.alumna.getCualificacions().length; k++) {
			if(this.cualificacions[k] >= 0)
				positivo = true;
			else {
				positivo = false;
				break;
			}
		}
		return positivo;
	}
	
	public double cualificacionFinal() {
		double media = 0.0;
		if(valoresPositivos() == true) {
			for(int k = 0; k< this.alumna.getCualificacions().length; k++) {
				media += this.cualificacions[k];
			}
			media /=this.cualificacions.length;
		}
		else media = 0;
		return media;
	}
	
	public static void main(String[] args) {
		//realiza as probas da clase
		int[] notas = new int [] {-1,6,8};
		Alumna alumna = new Alumna("Maria", "DAM", "Contornos", 1, notas);
		Avaliacion avaliacion = new Avaliacion(alumna);
		PrintStream flujoS = System.out;
		
		flujoS.println(alumna.toString());
		flujoS.println("Nome:   "+alumna.getNome());
		flujoS.println("Ciclo:  "+alumna.getCiclo());
		flujoS.println("Modulo: "+alumna.getModulo());
		flujoS.println("Curso:  "+alumna.getCurso());
		flujoS.println("Avaliacion: "+avaliacion.cualificacionFinal());
	}
}
