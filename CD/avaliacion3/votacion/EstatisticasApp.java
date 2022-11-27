package votacion;

public class EstatisticasApp {
	
	public static void main(String[] args) {
		
		//Estatisticas estatisticas = new Estatisticas();
		
		int[] votos = new int[5];
		
		votos = Estatisticas.inserirVotos(votos);
		Estatisticas.imprimirVotos2(votos);
	
		System.out.println
		("N�mero de distritos " + votos.length);

		int media = Estatisticas.calcularMedia(votos);
		System.out.println
		("Media dos votos emitidos m= " +  media);
						
		int max = Estatisticas.calculaMaximo(votos);
		System.out.println
		("M�ximo dos votos emitidos Max = " + max);
		
		
		int min = Estatisticas.calculaMinimo(votos);
		System.out.println
		("M�nimo dos votos emitidos min = " + min);
		 
		/*final int NUM = 5;
		int[] votos = new int[NUM];
		Estatisticas estatisticas = 
				new Estatisticas();
		votos = estatisticas.asignaVotos(votos);
		System.out.print
		(estatisticas.amosaVotos(votos));
		System.out.print
		(estatisticas.estadisticas(votos));*/
	}
}
