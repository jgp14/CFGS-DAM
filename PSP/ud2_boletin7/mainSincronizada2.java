package ud2_boletin7;

import ud2_boletin7.objetoComun2;
import ud2_boletin7.sincronizada2;

public class mainSincronizada2 {

	public static void main(String[] args) {
		objetoComun1 compartido = new objetoComun1();

		//Creo los 4 hilos que usarán el objeto compartido anterior 
		sincronizada1 dibujo1 = new sincronizada1("Caperucita", compartido); 
		sincronizada1 dibujo2 = new sincronizada1("Blancanieves", compartido); 
		sincronizada1 dibujo3 = new sincronizada1("Pinocho", compartido); 
		sincronizada1 dibujo4 = new sincronizada1("Pulgarcito", compartido);
 
		//Lanzo los hilos 
		dibujo1.start(); 
		dibujo2.start(); 
		dibujo3.start(); 
		dibujo4.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException ex) { 
			System.out.printf("Interrupcion");
		}

		System.out.println("Hemos terminado amiguitos");
	}

}
