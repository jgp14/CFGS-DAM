package ud2_boletin6;

public class MainCarrera {

	public static void main(String[] args) {
		
		//Crear los dos objetos hilo
		Carrera hilo1 = new Carrera("hilo1",0);
		Carrera hilo2 = new Carrera("hilo2",100);
		
		//Asignar prioridades a cada hilo
		hilo1.setPriority(Thread.MAX_PRIORITY);
		hilo2.setPriority(Thread.MIN_PRIORITY);
		
		hilo1.start();
		hilo2.start();
		
		while(hilo1.conta > hilo2.conta) {
			;
		}
		
//		hilo1.parar();
//		hilo2.parar();
		
		System.out.println("Conta en hilo1 "+hilo1.conta);
		System.out.println("Conta en hilo2 "+hilo2.conta);
		System.out.println("Fin");
	}

}
