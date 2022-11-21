package ud2_boletin4;

public class MainDormirVivir {

	public static void main(String[] args) {
		//Creo el hilo
		DormirVivir hilo = new DormirVivir();
		System.out.println("Estado antes de iniciarse: "+hilo.isAlive());
		hilo.start();
		System.out.println("Estado en ejecuci�n: "+hilo.isAlive());
		try {
			hilo.join();
		}catch(InterruptedException ex) {}
		System.out.println("Estado despu�s de ejecutarse: "+hilo.isAlive());
	}

}
