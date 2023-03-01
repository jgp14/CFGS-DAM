package ud2_boletin6;

public class Enteros extends Thread{

	int n, tiempo; 
	String nombre;
	
	public Enteros(int valorN, String nombreHilo, int retardo) {
		n = valorN;
		nombre = nombreHilo; 
		tiempo=retardo;
	}
	
	public void run() {
		System.out.println("Prioridad de " + nombre + " " + getPriority());
		
		for(int i = 1; i <= n; i++) {
			System.out.println(nombre);
			try {
				sleep(tiempo);
			} catch (InterruptedException e) {
				System.out.println("Interrupcion " + nombre);
			}
			
			System.out.println("......Termina "+nombre);
		}
	}
}
