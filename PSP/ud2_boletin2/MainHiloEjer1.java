package ud2_boletin2;

public class MainHiloEjer1 {

	public static void main(String[] args) {
		//Instancio el hilo
		HiloEjer1 hilo = new HiloEjer1();
		//Lo ejecuto
		hilo.start();
		System.out.println();
		for(int i=0;i<=30;i++)
			System.out.print("YES ");
	}

}
