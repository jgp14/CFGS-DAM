package ud2_boletin3;

public class HiloRunEjer5 extends Thread implements Runnable{
 	@Override 
 	public void run() { 
 		for(int i=0;i<=5;i++)
 			System.out.println(i);
 	}
}
