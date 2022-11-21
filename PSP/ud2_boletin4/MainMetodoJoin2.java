package ud2_boletin4;

public class MainMetodoJoin2 {

	public static void main(String[] args) 
			throws InterruptedException {
		MetodoJoin hilo1 = new MetodoJoin("hilo1");
		MetodoJoin hilo2 = new MetodoJoin("hilo2");
		System.out.println("Aun no se han iniciado los hilos");
		hilo1.start();
		hilo1.join();
		System.out.println(hilo1.getName()+" ha terminado");
		hilo2.start();
		hilo2.join();
		System.out.println(hilo2.getName()+" ha terminado");
		System.out.println("Fin del programa");
	}


}
