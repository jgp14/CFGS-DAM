package misClases.avaliacion1;

public class CNotas {

	private float []  notas = { 3.2F, 7.45F, 8.15F, 5.6F, 
			5.35F, 9.15F, 2.45F, 4.4F, 6.7F, 1.8F};
		
	public void mostraNotas() {
		int i;
		System.out.println("Relacion de NOTAS");
		System.out.println("=================");
		for (i = 0;i < notas.length; i++) {
				System.out.println("Alumno  "+(i+1)+": "+notas[i]);
		}
	}
	
	public float dameNota(int i) {
		return notas[i];
	}
	
	public void mostraAprobados() {	
		int i;
		
		System.out.println("Relacion de NOTAS");
		System.out.println("=================");
		for(i = 0; i < notas.length;i++) {
			if(notas[i] >= 5)
			System.out.println("Alumno "+(i+1)+": "+notas[i]);
		}
	}
	
	public void mostraSuspensos() {
		int i;
		System.out.println("Relacion de NOTAS");
		System.out.println("=================");
		for(i = 0; i < notas.length; i++) {
			if(notas[i] < 5)
			System.out.println("Alumno "+(i+1)+": "+notas[i]);
		}
	}
	
	/*public int dameMaior() {
		System.out.println("Alumno con MAIOR nota");
		System.out.println("=====================");
		float numeromayor;
        numeromayor = notas[0];
        int i = 0, j = 0;

        for(i=0; i<notas.length; i++){
            if(notas[i]>numeromayor){ // 
                numeromayor = notas[i];
                j = i + 1;
            }
        }
        System.out.println("Alumno " + j + ": " + numeromayor);
		return 0;	
	}*/
	
	public int dameMaior() {
		int i, maior;
		float notaMaior;
		
		maior = 0;
		notaMaior = notas[0];
		for (i = 0; i < 10; i++)
			if(notas[i] > notaMaior) {
				maior = i;
				notaMaior = notas[i];
			}
		return maior;
	}
	
	/*public int dameMenor() {
		System.out.println("Alumno con MAIOR nota");
		System.out.println("=====================");
		float numeromenor;
		numeromenor = notas[0];
		int i = 0, j = 0;
		for(i=0;i<notas.length;i++) {
			if(notas[i] < numeromenor) {
				numeromenor = notas[i];
				j = i + 1;
			}
		}
		System.out.println("Alumno " + j + ": " + numeromenor);
		return 0;
	}*/
	
	public int dameMenor() {
		int i, menor;
		float notaMenor;
		
		menor = 0; 
		notaMenor = notas[0];
		for (i = 0; i < 10; i++)
			if (notas[i] < notaMenor) {
				menor = i; 
				notaMenor = notas[i];
			}
		return menor;
	}
	
	/*public float dameNotaMedia() {
		System.out.println("=================");
		float suma = 0;
		for(int i=0;i<notas.length;i++) {
			suma = suma + notas[i];	
		}
		System.out.println("Nota Media: "+(suma/notas.length));
		return 0;
	}*/
	
	public float dameNotaMedia() {
		int i; 
		float notaMedia;
		
		notaMedia = 0;
		for (i = 0; i < 10; i++)
			notaMedia = notaMedia + notas[i];
		notaMedia = notaMedia / 10;
		return notaMedia;
	}
}

