package ud2_boletin1;

public class Raton implements Runnable{ 
 	private String nombre; 
 	private int tiempoAlimentacion; 
 
 	public Raton(String nombre, int tiempoAlimentacion) { 
		super(); 
		this.nombre = nombre;  
		this.tiempoAlimentacion= tiempoAlimentacion;
 	}
 	
	public void comer () { 
		 try { 		
			 System. out .printf ("El ratón %s ha comenzado a alimentarse%n",nombre) ; 
			 Thread.sleep(tiempoAlimentacion * 1000) ; 
			 System.out.printf("El ratón %s ha terminado de alimentarse%n",nombre) ; 
		 } catch (InterruptedException e) {
			 e.printStackTrace () ; 
		 }
		 
	 }
	
 	@Override 
 	public void run () { 
 		this.comer () ; 
 	}

	 public static void main(String[] args) { 
		 Raton fievel = new Raton( "Fievel" , 4); 
		 Raton jerry = new Raton( "Jerry" , 5); 
		 Raton pinky = new Raton( "Pinky" , 3); 
		 Raton mickey = new Raton ("Mickey" , 6); 
		 new Thread (fievel).start(); 
		 new Thread (jerry).start(); 
		 new Thread (pinky).start(); 
		 new Thread (mickey).start(); 
	 }
}