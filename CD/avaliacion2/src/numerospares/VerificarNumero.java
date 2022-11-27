package numerospares;

public class VerificarNumero {

	private int numero; 
	
	public VerificarNumero(int numero) {
		super();
		this.numero = numero;
	}
	
	public boolean ePar() {
//		
//
//
		return (this.numero%2==0)?true:false; 
	}
	
	public static void main(String[] args) {
		int n = 45;
		boolean resultado = false; 
		VerificarNumero numero = new VerificarNumero(n);
		if(numero.ePar()==resultado)
			System.out.println("Par");
	}
}
