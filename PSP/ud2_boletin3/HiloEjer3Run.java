package ud2_boletin3;

public class HiloEjer3Run implements Runnable{
	
	private String varSiNo;
	static int contador = 0;
	
	public HiloEjer3Run (String cadena) {
		super();
		varSiNo = cadena; 
	};
	
	public void run()  {
		for(int i=1;i<=10;i++)
			System.out.print(++contador+":"+varSiNo+" ");
	}
}
