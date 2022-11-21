package ud2_boletin4;

public class MainDormirRun {

	public static void main(String[] args) {
		DormirRun objeto = new DormirRun();
		Thread hilo = new Thread(objeto);
		
		hilo.start();
		
		System.out.println("Ejecutando proceso principal");
		
		hilo.setName("Hiliño");
		System.out.println("Termino "+hilo.getName());
		System.out.println("Prioridad "+hilo.getPriority());		
	}

}
