package compilador41_49;

import java.io.*;

public class compi41 {

	public static void main(String[] args) throws IOException{
		char letra;
		
		System.out.print(">");
		letra = (char) System.in.read();
		while (letra != '\n') {
			System.out.print(letra);
			letra =(char) System.in.read();
		}
	}
}
