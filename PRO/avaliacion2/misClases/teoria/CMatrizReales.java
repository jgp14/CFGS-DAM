package misClases.teoria;

public class CMatrizReales {
	
	private float[] matriz;
	
	public void crea() {		
		System.out.print("Numero de reales: ");
		int n = Leer.datoInt();
		matriz = new float[n];
	}
	
	public void llena() {
		for(int i = 0; i < matriz.length; i++)
			matriz[i] = dameDato();
	}
	
	public void amosa() {
		for(int i = 0;i < matriz.length; i++)
			System.out.println(i + "-> " + matriz[i]);
	}
	
	public int dameIndice() {
		int indice; 
		do {
			System.out.print("Dame indice: ");
			indice = Leer.datoInt();
		} while(indice < 0 || indice > matriz.length - 1);
		return indice; 
	}
	
	public void modificaElemento(int indice) {
		matriz[indice] = dameDato();
	}
	
	private float dameDato() {
		int unidades = (int)(10.0 * Math.random());
		int decenas = (int)(100.0 * Math.random());
		float dato = unidades + decenas/100.0F;
		return dato;
	}
}
