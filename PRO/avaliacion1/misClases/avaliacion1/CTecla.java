package misClases.avaliacion1;

import java.io.IOException;
import java.util.Scanner;

public class CTecla {
	private char dixito;
	private char vocal, vocalm;
	private char consonante, consonantem; 

	private Scanner teclado = new Scanner(System.in);
	
	public void recogeDixito() throws IOException {
		System.out.print("Introduza un dixito: ");
		dixito = (char)System.in.read();
		teclado.nextLine();
		while (dixito < '0' || dixito >'9') {
			System.out.print("Introduza un dixito: ");
			dixito = (char)System.in.read();
			teclado.nextLine();
		}
	}
	
	public void recogeVocal() throws IOException {
		System.out.print("Introduza unha vocal minuscula: ");
		vocal = (char)System.in.read();
		teclado.nextLine();
		while (vocal != 'a' && vocal != 'e' && vocal != 'i'
				&& vocal != 'o' && vocal != 'u') {
			System.out.print("Introduza unha minuscula: ");
			vocal = (char)System.in.read();
			teclado.nextLine();
		}
	}
	
	public void recogeVocalm() throws IOException{
		System.out.print("Introduza unha vocal maiuscula: ");
		vocalm = (char)System.in.read();
		teclado.nextLine();
		while (vocalm != 'A' && vocalm != 'E' && vocalm != 'I'
				&& vocalm != 'O' && vocalm != 'U') {
			System.out.print("Introduza unha vocal maiuscula: ");
			vocalm = (char)System.in.read();
			teclado.nextLine();
		}
	}
	
	public void recogeConsonante() throws IOException{
		System.out.print("Introduza unha consonante minuscula: ");
		consonante = (char)System.in.read();
		teclado.nextLine();
		while ((consonante < 'b' || consonante >'z') 
				&& consonante !='e' && consonante != 'i'
				&& consonante !='o' && consonante != 'u') {
			System.out.print("Introduza unha consonante minuscula: ");
			consonante = (char)System.in.read();
			teclado.nextLine();
		}
	}
	
	public void recogeConsonantem() throws IOException{
		System.out.print("Introduza unha consonante maiuscula: ");
		consonantem = (char)System.in.read();
		teclado.nextLine();
		while ((consonantem < 'B' || consonantem >'Z') 
				&& consonantem !='E' && consonantem != 'I'
				&& consonantem !='O' && consonantem != 'U') {
			System.out.print("Introduza unha consonante maiuscula: ");
			consonantem = (char)System.in.read();
			teclado.nextLine();
		}
	}
	
	public void amosaResultado() {
		System.out.print("Resultado: "+dixito+",  "+vocal+",  "
		+vocalm+",  "+consonante+",  "+consonantem);
	}
}
