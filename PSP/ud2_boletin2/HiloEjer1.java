package ud2_boletin2;

public class HiloEjer1 extends Thread {
	
	@Override 
	public void run() {
		for(int i=0;i<=30;i++)
			System.out.print("NO ");
	}

}
