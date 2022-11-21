package ud2_boletin4;

public class MainDormir1 {

	public static void main(String[] args) {
		Dormir1 hilo1 = new Dormir1();
		Dormir1 hilo2 = new Dormir1();
		Dormir1 hilo3 = new Dormir1();		
		hilo1.setName("hilo1");
		hilo2.setName("hilo2");
		hilo3.setName("hilo3");
		System.out.println("Iniciando subprocesos");
		System.out.println("Subprocesos iniciados termina el main");
		try {
			hilo1.start();		
			hilo2.start();
			hilo3.start();	
			hilo1.join();
			hilo2.join();
			hilo3.join();
		} catch(InterruptedException ex) {}
	}

}
