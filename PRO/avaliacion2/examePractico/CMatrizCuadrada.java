package examePractico; //Jaime Garcia Parada

public class CMatrizCuadrada {

	private int[][] matrizA = {{1,2,3},{4,5,6},{7,8,9}};
	private int[][] matrizB = new int[3][3];
	
	private int[][] dameReferencia(char letra){
		int[][] M = null;
		if(letra == 'A' || letra == 'a')
			M = this.matrizA;
		else if(letra == 'B' || letra == 'b')
			M = this.matrizB;
		return M;
	}
	
	public void amosa(char matriz) {
		int[][] M = dameReferencia(matriz);
		System.out.println();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
				System.out.print("  "+M[i][j]);
			System.out.println();
		}
	}
	
	public void copiaAenB() {
	for(int i = 0; i < 3; i++) 
		for(int j = 0; j < 3; j++)
			matrizB[i][j] = matrizA[1+j%2+j/2][2-i];
	}
	
}
