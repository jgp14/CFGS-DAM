package ud2_boletin3;

public class MainHiloRunEjer5 {

	public static void main(String[] args) {
		//Instanciamos los hilos
		HiloRunEjer5 objetoA = new HiloRunEjer5();	
		HiloRunEjer5 objetoB = new HiloRunEjer5();		
		//Creo los hilos
		Thread hilo1 = new Thread(objetoA);
		Thread hilo2 = new Thread(objetoB);
		//Ejecutamos los hilos
		hilo1.start();		
		hilo2.start();
	}

}
