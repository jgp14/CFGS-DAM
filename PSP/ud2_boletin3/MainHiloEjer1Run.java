package ud2_boletin3;

public class MainHiloEjer1Run {

	public static void main(String[] args) {
		//Creo un objeto de la clase implement
		HiloEjer1Run objeto1 = new HiloEjer1Run();
		//Creo el hilo
		Thread hilo1 = new Thread(objeto1);
		//Arraco la ejecucion
		hilo1.start();
		System.out.println();
		for(int i=0;i<=10;i++)
			System.out.print("YES ");
	}

}
