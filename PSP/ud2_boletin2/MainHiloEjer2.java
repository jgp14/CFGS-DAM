package ud2_boletin2;

public class MainHiloEjer2 {

	public static void main(String[] args) {
		//Instancio 2 hilos
		HiloEjer2A hiloA = new HiloEjer2A();
		HiloEjer2B hiloB = new HiloEjer2B();		
		//Los ejecuto
		System.out.println("\n Ejecuci�n en HiloA");
		hiloA.start();		
		System.out.println("\n Ejecuci�n en HiloB");
		hiloB.start();		
		System.out.println("\n Ejecuci�n en main");
	}

}
