package rectangulo;

//import java.io.PrintStream;
import java.util.Scanner;

public class Rectangulo {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public int inserirDato(String mensaxe) {
		System.out.print(mensaxe);
		return scanner.nextInt();
	}
	
	private int perimetro(int a, int b) {
		return a*2 + b*2;
	}
	
	private int superficie(int a, int b) {
		return a * b;
	}
	
	private void resultados(int dato, String msg) {
		System.out.println(msg + dato);
	}
	
	public void menu(int a, int b, int opcion) {
		int superficie;
		int perimetro;
		if(opcion == 1) {
			perimetro = perimetro(a, b);
			resultados(perimetro,"Perimetro p ");
		}
		else if(opcion == 2){
			superficie = superficie(a, b);
			resultados(superficie, "Superficie s ");
		}
	}
	
	
	/*private static Scanner scanner = new Scanner(System.in);
	
	public int inxerirDato(String msg) {
		int dato;
		do {
			System.out.print(msg);
			dato = scanner.nextInt();
		} while (dato < 0);
		return dato;	
	}
	
	public int calculaPerimetro(int a, int b) {
		int perimetro = a + a+ b +b;
		System.out.println("Per�metro p = " + perimetro);
		return perimetro;
	}
	
	public int calculaSuperficie(int a, int b) {
		int superficie = a * b;
		System.out.println("Superficie s = " + superficie);
		return superficie;
	}
	
	public int menu(int a, int b, int opcion) {
		int calculo = 0; 
		if(opcion == 1) 
			calculo = calculaPerimetro(a,b);
		else if(opcion == 2) 
			calculo = calculaSuperficie(a, b);
		return calculo;
	}*/
	
}
