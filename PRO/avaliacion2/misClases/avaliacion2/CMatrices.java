package misClases.avaliacion2;

import misClases.teoria.Leer;

public class CMatrices {

	private int[][] A = new int[3][3];
	private int[][] B = new int[3][3];
	private int[][] C = new int[3][3];
	private int[][] D = new int[3][3];
	private int n = 3;
	private int i, j;
	private int[][] M1;
	private int[][] M2;
	private int[][] M3;
		
	private int[][] dameReferencia(char letra){
		int[][] M = null;
		if(letra == 'A' || letra == 'a')
			M = this.A;
		else if(letra == 'B' || letra == 'b')
			M = this.B;
		else if(letra == 'C' || letra == 'c')
			M = this.C;
		else if(letra == 'D' || letra == 'd')
			M = this.D;
		return M; 
	}
	
	public void recoge() {
		System.out.print("Introduce dimension(2 o 3): ");
		n = Leer.datoInt();
		for(i = 0; i < n; i++)
			for(j = 0; j < n; j++) {
				System.out.print("A["+i+"]["+j+"]:");
				this.A[i][j] = Leer.datoInt();
			}
		for(i = 0; i < this.n; i++)
			for(j = 0; j < n; j++) {
				System.out.print("B["+i+"]["+j+"]:");
				this.B[i][j] = Leer.datoInt();
			}
	}
	
	public void amosa(char una, char dos) {
		M1 = dameReferencia(una);
		M2 = dameReferencia(dos);
		System.out.println();
		for(i = 0; i < n; i++) {
			for(j = 0; j < n; j++) {
				if (M1[i][j] < 0 || M1[i][j] > 9)
					System.out.print("    " + M1[i][j]);
				else 
					System.out.print("     " + M1[i][j]); 
			}
			System.out.print("     ");
			for(j = 0; j < n; j++) {
			    if (M2[i][j] < 0 || M2[i][j] > 9)
			    	System.out.print("    " + M2[i][j]);
			    else 
			    	System.out.print("     " + M2[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void trasposta(char una, char dos) {
		M1 = dameReferencia(una);
		M2 = dameReferencia(dos);
		for(i = 0; i < n; i++) {
			for(j = 0; j < n; j++) 
				M2[i][j] = M1[j][i];
		}
	}
	
	public void suma(char una, char dos, char tres) {
		M1 = dameReferencia(una);
		M2 = dameReferencia(dos);
		M3 = dameReferencia(tres);
		for(i = 0; i < n; i++) {
			for(j = 0; j < n; j++) 
				M3[i][j] = M1[i][j] + M2[i][j];
		}
	}
	
	public void resta(char una, char dos, char tres) {
		M1 = dameReferencia(una);
		M2 = dameReferencia(dos);
		M3 = dameReferencia(tres);
		for(i = 0; i < n; i++) {
			for(j = 0; j < n; j++) 
				M3[i][j] = M1[i][j] - M2[i][j];
		}
	}
	
	public void multiplica(char una, char dos, char tres) {
		M1 = dameReferencia(una);
		M2 = dameReferencia(dos);
		M3 = dameReferencia(tres);
		for(i = 0; i < n; i++) {
			for(j = 0; j < n; j++) {
				M3[i][j] = 0;
				for(int k= 0; k < n; k++)
					M3[i][j] = M3[i][j] + M1[i][k] * M2[k][j];
			}
		}
	}
}
