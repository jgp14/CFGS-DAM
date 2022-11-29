package ud2_boletin5;

public class Ej3ContarApp {

	public static void main(String[] args) {
		Ej3ContarThread hilo1 = new Ej3ContarThread(5);
		Ej3ContarThread hilo2 = new Ej3ContarThread(4);
		
		try {
			hilo1.start();
			Thread.sleep(3000);
			hilo2.start();
			while(hilo1.getState() != Thread.State.TERMINATED 
					&& hilo2.getState() != Thread.State.TERMINATED){
				Thread.sleep(1000);
				System.out.println("Sigo Contando....");
			}
		}catch (InterruptedException e) {}
	}

}
