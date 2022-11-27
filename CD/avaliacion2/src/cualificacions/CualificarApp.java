package cualificacions;

import java.io.PrintStream;
import java.util.Scanner;

public class CualificarApp {

	public static void main(String[] args) {

		/*Cualificar cualificar = new Cualificar(null, 0, 0, null);
		Cualificar cualificar = new Cualificar(null, 0, 0, null);
		System.out.println("Resultado, aprobado si/non");
		System.out.println(cualificar.aprobado());*/	
		
		/*Cualificar cualificar = new Cualificar
		 ("Carballo Outeiro, Ant�n", 6, 3, "273456789A");
		if(cualificar.aprobado() == false)
			System.out.println("Proba executada con éxito");
		else System.out.println("Proba executada con erros");
		
		cualificar.setNome("Mendez D�az, Carlos");
		cualificar.setDni("01010101B");
		cualificar.setModulo(10);
		cualificar.setCualificacion(9);
		if(cualificar.aprobado()==true)
			System.out.println("Proba executada con éxito");
		else System.out.println("Proba executada con erros");*/	

		
		Cualificar cualificar = new Cualificar(null, 0, 0, null);
		Scanner teclado = new Scanner(System.in);
		PrintStream flujoS = System.out;

		do {
			flujoS.print("Dame o nome: ");
			cualificar.setNome(teclado.nextLine());
		} while(cualificar.getNome() == "errornome");
		
		
		do {
			flujoS.print("Dame o DNI: ");
			cualificar.setDni(teclado.next());
		} while(cualificar.getDni() == "errordni");
		
		cualificar.menu();
		do {
			flujoS.print("Dame o codigo dun modulo de DAM1: ");
			cualificar.setModulo(teclado.nextInt());
		} while(cualificar.getModulo() == -1);
		teclado.nextLine();
		
		do {
			flujoS.print("Dame a cualificacion de "+
			cualificar.nomeModulo()+": ");
			cualificar.setCualificacion(teclado.nextInt());
		} while(cualificar.getCualificacion() == -1);
		teclado.nextLine();
				
		if(cualificar.aprobado()==true)
			flujoS.println("Modulo de "+cualificar.nomeModulo()
			+" aprobado con exito, ");
		else 
			flujoS.println("Modulo de "+cualificar.nomeModulo()
			+" suspendido, ");
		flujoS.println("cun "+cualificar.getCualificacion()+
				" sobre 10, polo alumno "+cualificar.getNome()+
				" con DNI: "+cualificar.getDni());
		
		flujoS.println(cualificar.toString());
		teclado.close();
	}

}
