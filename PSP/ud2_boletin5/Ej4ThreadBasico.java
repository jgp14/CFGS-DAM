package ud2_boletin5;

import java.util.Random;

public class Ej4ThreadBasico implements Runnable{
	private String frase;
	Random aleatorio; 
	
	public Ej4ThreadBasico(String frase) {
		this.frase=frase;
		aleatorio= new Random();
	}//constructor
	
	public void run() {
		while(true) {
			System.out.println(frase);
			
			try {
				Thread.sleep((long)(Math.abs(aleatorio.nextInt())%1000));
			} catch(InterruptedException e){}
		}//while
	}//run
	
}
