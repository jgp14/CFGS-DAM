package votacion;

import java.util.Random;

public class Estatisticas {
	
	public static int[] inserirVotos(int[] datos) {
		Random random = new Random();
		for (int k = 0; k < datos.length; k++)
			datos[k] = 
				Math.abs((byte)random.nextInt() * 20);
		return datos;
	}

	public static void imprimirVotos(int[] datos) {
		for (int k = 0; k < datos.length; k++)
			System.out.print(datos[k] + " ");
		System.out.println();
	}

	public static void imprimirVotos2(int[] datos) {
		for (int valor : datos)
			System.out.println(valor + " ");
	}

	public static int calcularMedia(int[] datos) {

		int media = 0;
		for (int k = 0; k < datos.length; k++)
			media += datos[k];
		media = (int) media / datos.length;
		return media;
	}
	
	public static int calculaMaximo(int[] datos) {
		int max = 0;
		for (int k = 0; k < datos.length; k++)
			if (datos[k] > max)
				max = datos[k];
		return max;
	}
	
	public static int calculaMinimo(int[] datos) {
		int min = datos[0];
		for (int k = 1; k < datos.length; k++)
			if (datos[k] < min)
				min = datos[k];
		return min;
	}
	

	/*private int[] votos = new int[NUM];
	private static final int NUM = 5;
	private static final String DISTRITOS = 
			"Numero de distritos ";
	private static final String MAXIMO = 
			"Maximo dos votos emitidos max = ";
	private static final String MINIMO = 
			"Minimo dos votos emitidos min = ";
	private static final String MEDIA = 
			"Media dos votos emitidos m = ";
	
	public int[] asignaVotos(int[] votos) {
		Random random = new Random();
		for (int k = 0; k<votos.length; k++)
			votos[k] = 
			Math.abs((byte)random.nextInt()*20);
		this.votos = votos;
		return this.votos;
	}
	
	public String amosaVotos(int[] votos) {
		String voto = "";
		for (int k = 0; k<votos.length; k++)
			voto += votos[k]+"\n";
		return voto;
	}
	
	public int max(int[] votos) {
		int max = 0;
		for (int k = 0; k<votos.length; k++)
			if (votos[k]>max) max = votos[k];
		return max;
	}
	
	public int min(int[] votos) {
		int min = votos[0];
		for (int k = 1; k<votos.length; k++)
			if(votos[k]<min) min = votos[k];
		return min;
	}
	
	public int media(int[] votos) {
		int media = 0;
		for (int k = 0; k<votos.length; k++)
			media += votos[k];
		media = (int)(media)/votos.length;
		return media;
	}
	
	public String estadisticas(int[] votos) {
		return (DISTRITOS + votos.length+"\n")
		+ (MAXIMO+max(votos)+"\n")
		+ (MINIMO+min(votos)+"\n")
		+ (MEDIA+media(votos)+"\n");
	}*/
	
}
