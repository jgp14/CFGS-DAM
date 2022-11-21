package ud2_boletin2;

public class MainHiloEjer3 {

	public static void main(String[] args) {
		HiloEjer3 hiloA = new HiloEjer3("SI ");
		HiloEjer3 hiloB = new HiloEjer3("NO ");
		System.out.println("Comienzo de la ejecucion concurrente");
		hiloA.start();
		hiloB.start();
	}

}
