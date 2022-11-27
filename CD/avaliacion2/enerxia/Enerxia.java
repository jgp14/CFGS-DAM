package enerxia;

public class Enerxia {
	private static double GRAVIDADE = 9.81;
	private double ePotencial = 0.0;
	private double eCinetica = 0.0;
	private double velocidade = 0.0;
	private double masa = 0.0;
	
	public Enerxia (double masa) {
		this.masa = masa;
	}
	
	public double ePotencial(double altura) {
		ePotencial = masa * altura * GRAVIDADE;
		return this.ePotencial;
	}
	
	public double eCinetica(double velocidade) {
		eCinetica = masa * Math.pow(velocidade, 2.0) * 0.5;
		return this.eCinetica;
	}
	
	public double calculaVelocidade () {
		velocidade = this.eCinetica * 2.0 / this.masa;
		this.velocidade = Math.sqrt(this.velocidade);
		return this.velocidade;
	}
}
