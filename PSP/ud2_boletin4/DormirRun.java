package ud2_boletin4;

public class DormirRun implements Runnable {

	public void run() {
		System.out.println("Hilo en ejecucion");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Error: "+
			(Thread.currentThread()).getName()+" se ha interrumpido.");
		}
	}
}
