package ud2_boletin6;

public class Ejer3CarreraHilos implements Runnable{
	
private int contador = 0; 
	
	public void run() {
		for(int i = 0; i < 100000000; i++) 
			contador++;

	}
}
