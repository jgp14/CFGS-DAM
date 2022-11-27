package misClases.avaliacion2;

public class CMatriz {
	
	private int[][] matriz = new int[2][3];
	
	public void inicializa() {
		matriz[0][0] = 6;
		matriz[0][1] = 9;
		matriz[0][2] = 8;
		matriz[1][0] = 4;
		matriz[1][1] = 7;
		matriz[1][2] = 3;
	}

	public void amosaPorFilas() {
		int i, j;
		for(i = 0; i < 2; i++) {
			for(j = 0; j < 3; j++)
				System.out.print("  "+matriz[i][j]+"  ");
			System.out.println("");
		}
	}
	
	public void amosaPorColumnas() {
		int i, j;
		for(j = 0; j < 3; j++) {
			for(i = 0; i < 2; i++)
				System.out.print("  "+matriz[i][j]+"   ");
			System.out.println("");
		}
	}
	
	public void amosaPorFilasTotal() {
		int i, j, suma;
		for(i = 0; i < matriz.length; i++) {
			suma = 0;
			for(j = 0; j < (matriz[i]).length; j++) {
				System.out.print("  "+matriz[i][j]+"  ");
				suma = suma + matriz[i][j];
			}	
			System.out.print(" (total: "+suma+")");
			System.out.println("");
		}
	}
	
	public void amosaPorColumnasTotal() {
		int i, j, suma;
		for(j = 0; j < (matriz[0]).length; j++) {
			suma = 0;
			for(i = 0; i < matriz.length; i++) {
				System.out.print("  "+matriz[i][j]+"   ");
				suma = suma + matriz[i][j];
			}
			System.out.print("(total: "+suma+")");
			System.out.println("");
		}
	}
	
	public int oMaior() {
		int i, j, maior;
		maior = 0;
		for(i = 0; i < matriz.length ; i++) {
			for(j = 0; j < (matriz[i]).length ; j++)
				if(matriz[i][j] > maior)
					maior = matriz[i][j]; 
		}
		return maior;
	}
	
	public void amosaFilaMaior() {
		int i, j, totalFila, maiorFila, total;
		totalFila = 0; maiorFila = 0;
		for(i = 0; i < matriz.length; i++) {
			total = 0;
			for(j = 0; j < (matriz[i]).length ; j++)
				total += matriz[i][j];
			if(total > totalFila) {
				totalFila = total;
				maiorFila = i;
			}
		}
		System.out.println("  Fila Maior");
		System.out.println("  ==========");
		for(j = 0; j < (matriz[0]).length ; j++)
			System.out.print("  "+matriz[maiorFila][j]+"  ");
	}
	
	public void amosaColumnaMaior() {
		int i, j, totalColumna, maiorColumna, total;
		totalColumna = 0; 
		maiorColumna = 0;
		for (j = 0; j < (matriz[0]).length; j++) {
			total = 0;
			for(i = 0; i < matriz.length; i++)
				total += matriz[i][j];
			if(total > totalColumna) {
				totalColumna = total;
				maiorColumna = j;
			}
		}
		System.out.println("  Columna Maior");
		System.out.println("  =============");
		for(i = 0; i < matriz.length ; i++)
			System.out.println("       "+matriz[i][maiorColumna]);
	}
}
