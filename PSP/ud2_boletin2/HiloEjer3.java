package ud2_boletin2;

public class HiloEjer3 extends Thread{

	private String varSiNo;
	static int contador = 0;
	
	public HiloEjer3 (String cadena) {
		super();
		varSiNo = cadena; 
	};
	
	public void run()  {
		for(int i=1;i<=10;i++)
			System.out.print(++contador+":"+varSiNo+" ");
	}
}
