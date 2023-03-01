package ud2_boletin8;

public class MainContadorB {

	public static void main(String[] args) {
		Contador contador = new Contador();
		ContadorHiloA hilo1 = new ContadorHiloA(contador, "Hilo1");
		ContadorHiloA hilo2 = new ContadorHiloA(contador, "Hilo2");
		ContadorHiloA hilo3 = new ContadorHiloA(contador, "Hilo3");
		ContadorHiloA hilo4 = new ContadorHiloA(contador, "Hilo4");
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		
		System.out.println("Fin del programa");	
		
		System.out.println
		("GENERACION CORRECTA (tiempo total: ");
	}

}
