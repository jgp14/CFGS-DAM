package misClases.avaliacion1;

public class CSerie {
	
	private int i;	
	
	public void amosa1_10() {
		for(i = 1; i <= 10; i++) {
			System.out.println(i);
		}		
	}
	
	public void amosa10_1() {
		i = 11;
		while(i > 1) {			
			i--;
			System.out.println(i);
		}
	}
	
	public void amosaAta20(int a) {
		for(; a <= 20; a++) {
			System.out.println(a);
		}
	}
	
	public void amosaDende20(int j) {
		for(i = 20; i >= j; i--) {			
			System.out.println(i);
		}
	}
	
	public void amosaA_B(int a,int b) {
		for(; a <= b; a++) {
			System.out.println(a);
		}
	}

	public void amosaB_A(int a,int b) {
		while(b >= a) {
			System.out.println(b);
			b = b - 1;
		}
	}
	
	public void amosaB_AsumaAimpares (int a,int b) {
		for(i = b; i >= a; i--) {
			if (i % 2 == 1)
				System.out.print(a + "+" + i + " ");
			else
				System.out.print(i + " ");
		}
	} 
	
/* public void amosaB_AsumaAimpares (int a, int b){
 * 		for(i = b; i >= a; i--) {
 * 			if(i % 2 == 1)
 * 				System.out.print(a + "+" + i + " ");
 * 			else
 * 				System.out.print(i + " ");
 * 		}
 * 	}
 */
	
	public void amosaA_BrestaBtres(int a, int b) {
		for(i = a; i <= b; i++) {
			if (i % 3 == 0)
				System.out.print("("+ b + "-" + i + ") ");
			else
				System.out.print(i + " ");
		}
	}
	
/* public void amosaA_BrestaBtres(int a, int b) {
 * 		for(i = a; i <= b; i++) {
 * 			if (i % 3 == 0)
 * 				System.out.print("("+b+"-"+i+")");
 * 			else
 * 				System.out.print(i+" ");
 * 		}
 * }
 */
	
	public void amosaA_Bsuma500seis(int a,int b) {
		while(a < b) {
			a++;
			if(a % 2 == 0) {
				if(a % 6 == 0)
					System.out.print((a + 500) + " ");
				else
					System.out.print(a + " ");
			}
		}
	}
	
/*public void amosaA_Bsuma500seis(int a, int b){
 * 		while(a < b) {
 * 			a++;
 * 			if(a % 2 == 0) {
 * 				if(a % 6 == 0)
 * 					System.out.print((a + 500) + " ");
 * 				else
 * 					System.out.print(a + " ");
 * 			}
 * 		}
 * }
 */
	
	public void amosaA_Bmulti4partido(int a,int b) {
		while(a <= b) {
			if(a % 4 == 0)
				System.out.print("(" + a/4 + "*" + 4 + ") ");
			else
				System.out.print(a + " ");
			a++;
		}
	}
	
}
