package misClases.avaliacion1;

import java.util.Scanner;

public class CFecha {
	private int dia, mes, ano; 
	private Scanner teclado = new Scanner(System.in);
	
	public void recogeDia() {
		System.out.print("Introduzca un dia: ");
		dia = teclado.nextInt();
		while(dia < 1 || dia > 31) {
			System.out.print("Introduzca un dia: ");
			dia = teclado.nextInt();
		}
	}
	
	public void recogeMes() {
		System.out.print("Introduzca un mes: ");
		mes = teclado.nextInt();
		while(mes < 1 || mes > 12) {
			System.out.print("Introduzca un mes: ");
			mes = teclado.nextInt();
		}
	}
	
	public void recogeAno() {
		System.out.print("Introduzca un ano: ");
		ano = teclado.nextInt();
		while(ano < 1990 || ano > 2010) {
			System.out.print("Introduzca un ano: ");
			ano = teclado.nextInt();
		}
	}
	
	public void amosaResultado() {
		System.out.println("Resultado: "+Dia()+Mes()+Ano());
	}
	
	private String Dia() {
		String dato;
		if (dia<10) dato = "0";
		else dato = "";
		return dato+dia+"/";
	}
	
	private String Mes() {
		String dato;
		if (mes<10) dato = "0";
		else dato = "";
		return dato+mes+"/";
	}
	
	private String Ano() {
		String dato;
		//ano = ano%100;
		if(ano < 2000) ano -= 1900;
		else ano -= 2000;
		if(ano < 10) dato = "0";
		else dato = "";
		return dato+ano;
	}
}
