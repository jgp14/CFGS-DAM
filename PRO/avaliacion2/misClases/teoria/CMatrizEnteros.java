package misClases.teoria;

public class CMatrizEnteros {
	private int[] matriz;
	
	public void crea() {
		System.out.print("Numero de enteros: ");
		int n = Leer.datoInt();
		this.matriz = new int[n];
	}
	
	public void llena() {
		for(int i = 0; i < matriz.length; i++)
			matriz[i] = dameDato();
	}
	
	public void amosa() {
		System.out.println("\nMatriz de Enteros");
		for(int i = 0; i < matriz.length; i++)
			System.out.print(matriz[i] + " ");
	}	
	
	private int dameDato() {
		int dato = (int)(31.0D*Math.random()+20.0D);
		return dato;
	}
}
