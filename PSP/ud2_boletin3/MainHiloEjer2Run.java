package ud2_boletin3;

public class MainHiloEjer2Run {
	
	public static void main(String[] args) {
		HiloEjer2ARun objetoA = new HiloEjer2ARun();
		HiloEjer2BRun objetoB = new HiloEjer2BRun();		
		Thread hilo1 = new Thread(objetoA);
		Thread hilo2 = new Thread(objetoB);
		System.out.println("\n Ejecución en HiloA");				
		System.out.println("\n Ejecución en HiloB");		
		System.out.println("\n Ejecución en main");
		hilo1.start();
		hilo2.start();		
	}	
	
}
