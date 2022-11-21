package ud2_boletin2;

public class MainHiloEjer4 {

	public static void main(String[] args) {
		//Declaro dos objetos del tipo hilo segun el constructor
		HiloEjer4 hebraA = new HiloEjer4(1, 10, "ThreadA");
		HiloEjer4 hebraB = new HiloEjer4(20, 30, "ThreadB");
		
		System.out.println("Vamos a iniciar los dos threads");
		System.out.println("Hilos inicializados");
		//ahora comienzan, llamo al metodo start() que efectuara el run()
		
		hebraA.start();
		hebraB.start();
		
		System.out.println("Programa principal terminado");
	}

}
