package exerciciosdesenoclasesjava;

import java.util.Date;
import java.util.Scanner;

public class Tenda {

	private String tipo;
	private String marca;
	private String talla;
	private String color;
	private double prezo;
	private String rebaja;
	private boolean stock;
	private String tenda;
	
	public Tenda(String tipo, String marca, String talla, String color, double prezo, String rebaja, boolean stock,
			String tenda) {
		super();
		this.tipo = tipo;
		this.marca = marca;
		this.talla = talla;
		this.color = color;
		this.prezo = prezo;
		this.rebaja = rebaja;
		this.stock = stock;
		this.tenda = tenda;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrezo() {
		return prezo;
	}
	public void setPrezo(double prezo) {
		this.prezo = prezo;
	}
	public String getRebaja() {
		return rebaja;
	}
	public void setRebaja(String rebaja) {
		this.rebaja = rebaja;
	}
	public boolean isStock() {
		return stock;
	}
	public void setStock(boolean stock) {
		this.stock = stock;
	}
	public String getTenda() {
		return tenda;
	}
	public void setTenda(String tenda) {
		this.tenda = tenda;
	}
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Elige un tipo de ropa: ");

	}
	
}
