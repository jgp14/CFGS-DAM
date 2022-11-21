package ud2_boletin5;

public class Ej3ContarThread extends Thread{
	private int maxContar; 
	
	public Ej3ContarThread (int numero) {
		maxContar = numero;
	} //Constructor
	
	public void run() {
		for(int i=0;i<maxContar;i++) {
			System.out.println("Repeticion: "+i);
			System.out.println("Nombre del hilo: "+getName());
			try {
				sleep(2000);
			}catch(InterruptedException ex) {}
		}//for
	}//run
}
