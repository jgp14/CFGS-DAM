package ud2_boletin7;

public class objetoComun2 {

	public void Mostrar (String mensaje) { 
		System.out.println("�En marcha...! " + mensaje);

		try {
			Thread.sleep(2000);
	
		} catch (InterruptedException ex) { 
			System.out.printf("Interrupcion");
		}
		
		System.out.println("�He llegado! " + mensaje);
	}
}
