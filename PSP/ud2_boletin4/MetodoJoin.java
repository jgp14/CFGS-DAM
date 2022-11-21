package ud2_boletin4;

public class MetodoJoin extends Thread{
	MetodoJoin(String nom){
		super(nom);
	}
	
	public void run() {
		int i;
		for(i=1; i<=10; i++)
			System.out.print(i+ " ");
	}

}
