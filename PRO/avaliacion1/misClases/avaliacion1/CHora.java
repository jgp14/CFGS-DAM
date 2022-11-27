package misClases.avaliacion1;

import java.util.Scanner;

public class CHora {
	private int hora, minuto, segundo; 
	private Scanner teclado = new Scanner(System.in);
	
	public void recogeSegundo() {
		System.out.print("Introduzca os segundos: ");
		segundo = teclado.nextInt();
		while(segundo < 0 || segundo > 59) {
			System.out.print("Introduzca os segundos: ");
			segundo = teclado.nextInt();
		}
	}
	
	public void recogeMinuto() {
		System.out.print("Introduzca os minutos: ");
		minuto = teclado.nextInt();
		while(minuto < 0 || minuto > 59) {
			System.out.print("Introduzca os minutos: ");
			minuto = teclado.nextInt();
		}
	}
	
	public void recogeHora() {
		System.out.print("Introduzca a hora: ");
		hora = teclado.nextInt();
		while(hora < 0 || hora > 23) {
			System.out.print("Introduzca a hora: ");
			hora = teclado.nextInt();
		}
	}
	
	private String Hora() {
		String dato;
		if (hora<10) dato = "0";
		else dato = "";
		return dato+hora+"/";
	}
	
	private String Minuto() {
		String dato;
		if (minuto<10) dato = "0";
		else dato = "";
		return dato+minuto+"/";
	}
	
	private String Segundo() {
		String dato;
		if (segundo<10) dato = "0";
		else dato = "";
		return dato+segundo;
	}

	public void amosaResultado() {
		System.out.println("Resultado: "
		+Hora()+Minuto()+Segundo());
	}
}
