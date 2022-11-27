package persoa;

import java.util.Date;

public class PersoaApp {

	public static void main(String[] args) {
		Persoa persoa = new Persoa
				("147526L", "Manuel", "Carballo", new Date(), 
				"rua Abc", "15960", "Ribeira", "Coru�a, A");
				
				System.out.println(persoa.toString());
				System.out.println(persoa.getBonificacion());
	}
	
}
