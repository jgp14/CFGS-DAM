package ud2_boletin4;

public class MainMetodoJoin {

	public static void main(String[] args) throws InterruptedException {
		MetodoJoin hilo1 = new MetodoJoin("hilo1");
		System.out.println("Aun no se han iniciado los hilos");
		hilo1.start();
		//hilo1.join();
		System.out.println(hilo1.getName()+" ha terminado");
		System.out.println("Fin del programa");
	}

}
