package ud2_boletin3;

public class MainHiloEjer3Run {

	public static void main(String[] args) {
		HiloEjer3Run objetoA = new HiloEjer3Run("SI ");
		HiloEjer3Run objetoB = new HiloEjer3Run("NO ");
		Thread hilo1 = new Thread(objetoA);
		Thread hilo2 = new Thread(objetoB);
		System.out.println("Comienzo de la ejecucion concurrente");
		hilo1.start();
		hilo2.start();
	}

}
