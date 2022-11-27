package heranza;

public class TrianguloRect extends Forma {

	public TrianguloRect(int lado1, int lado2) {
		super(lado1, lado2);
	}
	
	private int calcularHipotenusa() {
		int hipotenusa = (int)Math.sqrt
				(this.getLado1()*2 + this.getLado2()*2);
		return hipotenusa;
	}

	public int calcularPerimetro() {
		this.setPerimetro(this.getLado1() + 
				this.getLado2()+ this.calcularHipotenusa());
		return this.getPerimetro();
	}

	public int calcularSuperficie() {
		System.out.println
		("Este calculo foi rescrito en TrianguloRect");
		System.out.println(super.calcularSuperficie()/2);
		return super.calcularSuperficie()/2;
	}
}
