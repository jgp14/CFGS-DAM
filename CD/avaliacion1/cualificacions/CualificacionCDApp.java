package cualificacions;

import java.util.Scanner;

public class CualificacionCDApp {

	public static void main(String[] args) {
		
		CualificacionCD cualificacioncd = new CualificacionCD(0.0,0.0,0.0,0.0,0.0);
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduza a nota da proba 1: ");
		cualificacioncd.setProba1(teclado.nextDouble());
		
		System.out.print("Introduza a nota da proba 2: ");
		cualificacioncd.setProba2(teclado.nextDouble());
		
		System.out.print("Introduza a nota da proba 3: ");
		cualificacioncd.setProba3(teclado.nextDouble());
		
		System.out.print("Introduza a nota do proxecto: ");
		cualificacioncd.setProxecto(teclado.nextDouble());
		
		cualificacioncd.calcularNotaFinal();
		
		System.out.println(cualificacioncd.toString());
		teclado.close();
	}
}
