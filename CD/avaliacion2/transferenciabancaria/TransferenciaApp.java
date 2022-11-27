package transferenciabancaria;


public class TransferenciaApp {

	public static void main(String[] args) {
		
		Clienta orixe = new Clienta("1A", 100);
		Clienta destino = new Clienta("2B", 200);
		//Engade o codigo preciso para realizares unha proba
		 Transferencia transferencia = new Transferencia(orixe, destino);
		 
		 double cantidade = 200;
		 @SuppressWarnings("unused")
		boolean ok = transferencia.transferencia(cantidade);
		 String msg = transferencia.mensaxeOk();
		 System.out.println(msg);
		
		 cantidade = 90;
		 ok = transferencia.transferencia(cantidade);
		 msg = transferencia.mensaxeOk();
		 System.out.println(msg);
		 
		 /*cantidade = 20;
		 ok = transferencia.transferencia(cantidade);
		 String msgNotOK = transferencia.mensaxeNotOk();
		 System.out.println(msgNotOK);*/
		 
		
		/*Clienta orixe = new Clienta("1A", 100);	
	    Clienta destino = new Clienta("2B", 200);
	    //Engade o c�digo preciso para realizares unha proba
	    Transferencia transferencia = 
	    		new Transferencia(orixe, destino);
	    int cantidade1 = 100; 
	    int cantidade2 = 101; 
	    boolean resultado1 = true;
	    System.out.println("Transferencia: "+resultado1);
	    transferencia.mostrarTransferencia(resultado1, cantidade1);
	    transferencia.mostrarTransferencia(resultado1, cantidade2);
	    boolean resultado2 = false;
	    System.out.println("Transferencia: "+resultado2);
	    transferencia.mostrarTransferencia(resultado2, cantidade1);
	    transferencia.mostrarTransferencia(resultado2, cantidade2);
	    System.out.println(orixe.toString());
	    System.out.println(destino.toString());*/
	}
}
