package ud2_boletin5;

public class Ej4ThreadBasicoMain {

	public static void main(String[] args) {
		String fraseA = "Buenos dias";
		String fraseB = "Hasta luego, buenas noches";
		Ej4ThreadBasico objetoA = new Ej4ThreadBasico(fraseA);
		Ej4ThreadBasico objetoB = new Ej4ThreadBasico(fraseB);
		Thread hilo1 = new Thread(objetoA);
		Thread hilo2 = new Thread(objetoB);
		
		hilo1.start();
		hilo2.start();
	}

}
