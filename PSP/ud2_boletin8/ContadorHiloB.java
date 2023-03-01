package ud2_boletin8;

import java.util.Random;

public class ContadorHiloB {
	private Contador contador; 
	Random aleatorio;
	private String nombreHilo;
		
	public ContadorHiloB (Contador contador, String nombreHilo) {
		this.contador = contador;
		this.nombreHilo = nombreHilo;
		aleatorio= new Random();
	} //Constructor
	
	public String getNombreHilo() {
		return nombreHilo;
	}
	
	public void run() {
		synchronized(contador){
			for(int i=0;i<3;i++) {		
				try {
					Thread.sleep((long)(Math.abs(aleatorio.nextInt())%1000));
				} catch(InterruptedException e){}	
				contador.setConta(contador.getConta()+1);
				System.out.println(getNombreHilo()
						+" valor del recurso compartido "+contador.getConta());
			}//for
			System.out.println("FIN ... "+getNombreHilo());
		}		
	}//run
}
