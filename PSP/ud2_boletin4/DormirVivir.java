package ud2_boletin4;

public class DormirVivir extends Thread {
	
	@Override 
	public void run() {
		try {
			Thread.sleep(2000);			
		}catch(InterruptedException ex) {
			System.out.println
			("Error: "+(Thread.currentThread()).getName()+" se ha interrumpido.");
		}
	}
	
}
