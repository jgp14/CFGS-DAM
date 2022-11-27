package misClases.avaliacion2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CString {

	private String cad;
	private int i;
	
	public void recoge() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader flujoE = new BufferedReader(isr);
		try {
			cad = flujoE.readLine();
		} catch (IOException iOException) {}
	}
	
	public void amosa() {
		System.out.println(cad);
	}
	
	public void maiusculas() {
		System.out.println(cad.toUpperCase());
	}
	
	public void minusculas() {
		System.out.println(cad.toLowerCase());
	}
	
	public void arroba() {
		StringBuffer cad2 = new StringBuffer(cad);
		for(i = 0; i < cad2.length(); i++) {
			if(cad2.charAt(i) == 'A' || cad2.charAt(i) == 'a')
				cad2.setCharAt(i, '@');
		}
		System.out.println(cad2.toString());
	}
	
	public void espacioBlanco() {
		StringBuffer cad2 = new StringBuffer(cad);
		@SuppressWarnings("unused")
		boolean espacioblanco = true;
		for(i = 0; i < cad2.length(); i++) {
			if(cad2.charAt(i) == ' ') {
				if(espacioblanco = true) {
					cad2.deleteCharAt(i);
					continue;
				}
				espacioblanco = true;
				i++;
				continue;
			}
			espacioblanco = false;
			i++;
		}
		System.out.println(cad2.toString());
	}
	
	public void sinNumeros() {
		StringBuffer cad2 = new StringBuffer(cad);
		for(i = 0; i < cad2.length();) {
			if(cad2.charAt(i) >= '0' && cad2.charAt(i) <= '9') {
				cad2.deleteCharAt(i);
				continue;
			}
			i++;
		}
		System.out.println(cad2.toString());
	}
}
