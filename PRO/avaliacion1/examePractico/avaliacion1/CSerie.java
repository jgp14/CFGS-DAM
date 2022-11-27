package examePractico.avaliacion1;

public class CSerie {
	
	@SuppressWarnings("unused")
	private int i;	
	
	public void amosaA_Bmulti47partidos(int a,int b) {
		while(a <= b) {
			if(a % 4 == 0)
				System.out.print("(" + a/4 + "*" + 4 + ") ");
			else if (a % 7 == 0)
				System.out.print("(" + a/7 + "*" + 7 + ") ");
			else
				System.out.print(a + " ");
			a++;
		}
	}
}
