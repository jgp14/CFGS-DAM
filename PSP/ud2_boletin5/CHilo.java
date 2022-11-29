package ud2_boletin5;

import java.util.Random;

public class CHilo implements Runnable{
	private String Caracter;
	CHilo (String Carac){
		Caracter=Carac;
		}
	
	public void run() {
		try {
			Thread.sleep((long)(Math.abs(new Random().nextInt())%1000));
			System.out.print(Caracter);
		}catch(InterruptedException e) {}
	}
}
class LetrasHilos{
	
	LetrasHilos(String Frase){
		Thread[] Hilo = new Thread[Frase.length()];
		
		for (int i=0; i!=Frase.length();i++) {
			Hilo[i] = new Thread(new CHilo(Frase.substring(i, i+1)));
			
			/*La sentencia de arriva es equivalente a estas:
			 CHilo objeto=CHilo(Frase.substring(i,i+1));
			 Thread Hi=new Thread(objeto);
			 Hilo[i]=Hi;
			 */
			Hilo[i].start();
		}
	}
}
