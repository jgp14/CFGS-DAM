package misClases.avaliacion2;

public class CMatrizCuadrada {

	private int[][] matriz = 
			new int[][] {{1,2,3},{4,5,6},{7,8,9}};
	
	private int[][] matrizA = {{1,2,3},{4,5,6},{7,8,9}};
	private int[][] matrizB = new int[3][3];
	
	public void amosaDereitaAbaixo() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
				System.out.print("  "+matriz[i][j]);
			System.out.println();
		}
	}
	
	public void amosaDereitaArriba() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
				System.out.print("  "+matriz[2-i][j]);
			System.out.println();
		}
	}
	
	public void amosaEsquerdaAbaixo() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
				System.out.print("  "+matriz[i][2-j]);
			System.out.println();
		}
	}
	
	public void amosaEsquerdaArriba() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
				System.out.print("  "+matriz[2-i][2-j]);
			System.out.println();
		}
	}
	
	public void amosaArribaDereita() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
				System.out.print("  "+matriz[j][2-i]);
			System.out.println();	
		}
	}
	
	public void amosaArribaEsquerda() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
				System.out.print("  "+matriz[2-j][2-i]);
			System.out.println();	
		}
	}
	
	public void amosaAbaixoDereita() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
				System.out.print("  "+matriz[j][i]);
			System.out.println();
		}
	}
	
	public void amosaAbaixoEsquerda() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
				System.out.print("  "+matriz[2-j][i]);
			System.out.println();
		}
	}
	
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
	
	public void copiaAenBcolumna1Repe() {
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				matrizB[i][j] = matrizA[j][2*(i % 2)];
	}
	
	public void copiaAenBfila2Repe() {
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				matrizB[i][j] = matrizA[1-j/2][2-i];
	}
	
	public void copiaAenBfila3Repe() {
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				matrizB[i][j] = matrizA[1+(j-j/2)][2-i];
	}
	
	//metodos recursivos buscados en internet:
	
	/*public void copiaAenB() {
		for(int i = 0; i < 3; i++) 
			for(int j = 0; j < 3; j++)
				matrizB[i][j] = matrizA[1+j-j/4][2 - i];
	}*/
	
	public void copiaEsquerdaArriba() {
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				matrizB[i][j] = matrizA[2-i][2-j];
	}
	
	/*public void copiaAbaixoEsquerda() {
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				matrizB[i][j] = matrizA[2*(1-j/2+j%2)][i];
	}*/
	
	public void copiaMatrizAenMatrizB() {
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				matrizB[i][j] = matrizA[j-j/2][i];
	}
	
	public void copiaAenB4() {
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				matrizB[i][j] = matrizA[1-i/2][j];
	}
	
}
