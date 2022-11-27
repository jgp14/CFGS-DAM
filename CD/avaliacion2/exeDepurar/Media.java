package exeDepurar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Media {

	/*private static final int NUM_AVAL = 3;
	private int[] cualificacions = new int[NUM_AVAL];
	
	private boolean avaliabel = false;
	private boolean aprobado = false; 
	private int media;
	
	public Media(double[] cualificacions) {
		super();
		this.cualificacions = cualificacions;
		
		this.avaliabel = this.getAvaliabel();
		this.media = this.calculaMedia();
		this.aprobado = this.media >= 5; 
	} 
	
	public boolean getAvaliabel () {
		this.avaliabel = this.verificarRango();
		return this.avaliabel;
	}
	
	private boolean verificarRango () {
		boolean ok = true
		for(int k = 0; k < this.cualificacions.length; k++){
			if ((this.cualificacions[k] <= 1) || (this.cualificacions[k] > 10)){
				ok = false;
				break;
			}
			return ok; 
		}
	}
	
	public int calculaMedia(){
		int media = 0; 
		if(this.avaliabel){
			this.media = media;
			return media; 
		}
		for (int k = 0; k < this.cualificacions.length; k++){
			media = media + cualificacions[k];
		}
		this.media = (int) media/NUM_AVAL;
		return this.media; 
	}
	
	public boolean isAprobado(){
		this.aprobado = this.media > 5;
		return aprobado;
		}
	
	 */
	
	private double[] notas = new double[3];	 //trimestre
	private double suma;					 //suma meses
	private double media;
	private int i;
	private boolean aprobado;
	PrintStream flujoS = System.out;

	public Media(double[] notas) {
		super();
		this.notas = notas;
	} 
	
	private static String dato() {
		String sdato = "";
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader flujoE = new BufferedReader(isr);
			sdato = flujoE.readLine();
		}catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		return sdato;
	}
	
	private static double datoDouble() {
		try {
			//@SuppressWarnings("deprecation")
			Double d = new Double(dato());
			return d.doubleValue();
		}catch (NumberFormatException e) {
			return Double.MIN_VALUE;
		}
	}
	
	private double valorDoubleCorrecto() {
	    double d = datoDouble();
	    while(d == Double.MIN_VALUE) {
	    	flujoS.print("Dame un numero real: ");
	    	d = datoDouble();
	    }
	    return d;
	}
	
	public void recogerNotas() {
		suma = 0.0;
		for (i = 0; i < notas.length; i++) {
			do {
				flujoS.print("Nota de "+(i+1)+"ª avaliacion: ");
				notas[i] = valorDoubleCorrecto();  
			} while(notas[i] < 0.0 || notas[i] > 10.0);	
		}
	}
	
	public double sumarNotas() {
		suma = 0.0;
		for (i = 0; i < notas.length; i++)
			suma += notas[i]; 
		return suma;
	}
	
	public double getMedia() {
		media = sumarNotas()/(notas.length);
		media = Math.round(media * 100)/100d;
		return media;
	}
	
	public boolean setAprobado() {
		aprobado = (getMedia() >= 5)?true:false;
		return aprobado;
	}
	
	public String getAprobado() {
		setAprobado();
		if(aprobado) return "aprobado";
		else return "suspenso";
	}
	
	public String resultadoMedia() {
		return "Tiene una media de notas de "
	.concat(String.valueOf(getMedia()))+" sobre 10, "
	+ "\npor lo tanto se puede avaliar y el alumno esta "
	.concat(getAprobado());
	}
	
	public static void main(String[] args) {
		/*int[] cualificacions = new int[] {8,7,6};
		 AvaliacionApp avaliacionApp = new AvaliacionApp(cualificacions);
		 boolean avaliabel = avaliacionApp.getAvaliabel();
		 System.out.println(avaliabel);
		 if(avaliacionApp.getAvaliabel()){
		 	System.out.println("Media m= "+avaliacionApp.calculaMedia());
		 	System.out.println("Aprobado ? "+avaliacionApp.isAprobado());
		 }
		 else System.out.println("Non se cumpre os requerimentos");
		 */
		
		double[] notas = new double[] {0.0, 0.0, 0.0};
		Media media = new Media(notas);
		media.recogerNotas();
		media.sumarNotas();
		System.out.println(media.resultadoMedia());
	}
}
