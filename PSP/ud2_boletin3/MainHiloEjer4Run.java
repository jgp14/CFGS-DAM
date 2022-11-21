package ud2_boletin3;

public class MainHiloEjer4Run {

	public static void main(String[] args) {
		//Declaro dos objetos del tipo hilo segun el constructor
		HiloEjer4Run objetoA = new HiloEjer4Run(1, 10, "ThreadA");
		HiloEjer4Run objetoB = new HiloEjer4Run(20, 30, "ThreadB");
		
		Thread hilo1 = new Thread(objetoA);
		Thread hilo2 = new Thread(objetoB);
		
		System.out.println("Vamos a iniciar los dos threads");
		System.out.println("Hilos inicializados");
		//ahora comienzan, llamo al metodo start() que efectuara el run()
		
		hilo1.start();
		hilo2.start();
		
		System.out.println("Programa principal terminado");

	}

}
