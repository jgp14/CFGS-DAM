package ud2_boletin4;

public class Dormir1 extends Thread{
	
	private int tiempoDormido;
	
	public Dormir1() {
		tiempoDormido = ((int)(Math.random() * 10000));
	}
	
	@Override 
	public void run() {
		try {
			System.out.println((Thread.currentThread()).getName()
					+" va a estar dormido durante "+tiempoDormido+" milisegundos");
			Thread.sleep(tiempoDormido);	
			System.out.println((Thread.currentThread()).getName()+" ha despertado");
		}catch(InterruptedException ex) {
			System.out.println
			("Error: "+(Thread.currentThread()).getName()+" se ha interrumpido.");
		}
	}

}
