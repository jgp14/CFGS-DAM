package misClases.avaliacion2;

import java.io.IOException;

public class CCadena {
	
	private char[] cadena = new char[40];
	
	public void recolleCadena() throws IOException {
		char letra;
		int i;
		
		letra = (char) System.in.read();
		i = 0;
		while (letra != '\n') {
			cadena[i] = letra;
			letra = (char) System.in.read();
			i++;
		}
	}
	/*public void recolleCadena1() throws IOException {
		char letra = (char) System.in.read(); 
		for(int i = 0; letra != '\r'; i++) {
			cadena[i] = letra;
			letra = (char) System.in.read(); 
		}			
	}*/
	
	
	public void amosaCadena() {
		int i;
		
		i = 0;
		while(cadena[i] != '\0') {
			System.out.print(cadena[i]);
			i++;
		}
	}	
	/*public void amosaCadena() {
		for(int i = 0; cadena[i] != '\0'; i++)
			System.out.print(cadena[i]);
	}*/
	
	
	public void amosaRevesCadena() {
		int i; 
		
		i = 0;
		while (cadena[i] != '\0') 
			i++;
		i--;
		while (i >= 0) {
			System.out.print(cadena[i]);
			i--;
		}
	}	
	/*public void amosaRevesCadena() {
		for(int i = 0; cadena[i] != '\0'; i++); i--;
		for(; i >= 0; i--) System.out.print(cadena[i]);
	}*/
	
	
	public void invierteCadena() {
		int i, j;
		char letra;
		
		i = 0;
		while (cadena[i] != '\0')
			i++;
		i--;
		j = 0;
		while (j < i) {
			letra = cadena[j];
			cadena[j] = cadena[i];
			cadena[i] = letra;
			j++;
			i--; 
		}
	}
	/*public void invierteCadena() {
		char letra; int i = 0, j = 0;
		for(; cadena[i] != '\0'; i++); i--;
		for(; j < i; i--, j++) {
			letra = cadena[j];
			cadena[j] = cadena[i];
			cadena[i] = letra;
		}
	}*/
	
	public void capicua() {
		int i, j;
		
		i = 0;
		while (cadena[i] != '\0')
			i++;
		j = i;
		i--;
		while(j >= 0) {
			cadena[j] = cadena[i];
			j++;
			i--; 
		}
	}
	/*public  void capicua() {
		int i = 0, j = 0;
		for(; cadena[i] != '\0'; i++); 
		j=i; i--;
		for(; j >= 0; i++, j--) 
			cadena[i] = cadena[j];
	}*/
	
	
	public void eliminaEnCadena(char letra) {
		int i, j;
		
		i = j = 0;
		while(cadena[i] != '\0') {
			if (cadena[i] == letra)
				i++;
			else {
				if(i > j)
					cadena[j] = cadena[i];
				i++; 
				j++;
			}
		}
		while(j <= i){
			cadena[j] = '\0';
			j++;
		} 		
	}
	/*public void eliminaEnCadena(char letra) {
		int i=0,j=0;
		for(;cadena[i] != '\0'; i++) {
			if(cadena[i] == letra) i++;
			else {
				if(i>j) cadena[j]=cadena[i];
				i++;j++;
			}
		}
		for(;j<=i;j++)
			cadena[j] = Character.MIN_VALUE;
	}*/
	
	public void repiteUnha() { //uso while 1
		int i;
		
		i = 0; 
		while(cadena[i] != '\0')
			i++;
		i--;		
		while(i >= 0) {
			int j = i * 2;
	 		cadena[j] = cadena[j + 1] = cadena[i];
			i--;
			}
		}
	/*public void repiteUnha() { //uso for
		int i = 0;
		for(;cadena[i] != '\0'; i++); i--;
		for(int j = i * 2; i >= 0; i--)
			cadena[j] = cadena[j + 1] = cadena[i];
	}*/
	
	public void eliminaPares() { //uso while
		int i, j; 
		
		i = 0; 
		j = 0;
		while (cadena[i] != '\0') {
			if (i % 2 != 0) {
				cadena[j] = cadena[i];
				j++;
			} 
		    i++;
		} 
		while (j < i) {
			cadena[j] = cadena[i];
			j++;
		} 
	}
	/*public void eliminaPares() { //uso for
		int i, j; i = 0; j = 0;
		for(; cadena[i] != '\0'; i++)
			if (i % 2 != 0) {
				cadena[j] = cadena[i]; j++;}
		for(; j < i; j++) cadena[j] = '\0';
	}*/
	
	//Preparatorios
	public void elimina125EnCadena() {
		int i, j;
		
		i = 0;
		j = 0;
		while(cadena[i] != '\0') {
			if(i != 1 && i != 2 && i != 5) {
				cadena[j] = cadena[i];
				j++;
			}
			i++;
		}
		i = j;		
		while (cadena[i] != '\0') {
			cadena[i] = cadena[j];
			j++;
		}
	}
	/*public void elimina125EnCadena(){
		int i, j; i = j = 0; 
		for(; cadena[i] != '\0'; i++)
			if(i != 1 && i != 2 && i != 5) {
				cadena[j] = cadena[i];
				j++;
			}
		i = j;
		for(; cadena[i] != '\0'; j++) {
			cadena[i] = cadena[j];
			j++;
		}
	}*/
	
	public void duplica125EnCadena() {
		int i, j;
		
		i = 0;
		j = 0;
		while(cadena[i] != '\0') {
			if(i == 1 || i == 2 || i == 5) {
				j++;
			}
			i++;
			j++;
		}		
		i--;
		j--;
		while (j > 0) {
			cadena[j] = cadena[i];
			if(i == 1 || i == 2 || i == 5) {
				j--;
				cadena[j] = cadena[i];
			}
			i--;
			j--;
		}
	}
	
	/*public void duplica125EnCadena() {
		int i, j; i = j = 0;
		for(i = 0; cadena[i] != '\0'; i++, j++)
			if(i == 1 || i == 2 || i == 5)
				j++;
		i--; j--;
		for(; j > 0; i--, j--){
			cadena[j] = cadena[i];
			if(i == 1 || i == 2 || i == 5) {
				j--;
				cadena[j] = cadena[i];
			}
		}
	}*/
	
	public void duplicaNumerosEnCadena() {
		int i = 0; int conta = 0;
		while(cadena[i] != '\0') {
			if(cadena[i] >= '0' && cadena[i] <= '9') {
				conta++;
			}
			i++;
			conta++;
		}		
		i--;
		conta--;
		while (conta > 0) {
			cadena[conta] = cadena[i];
			if(cadena[i] >= '0' && cadena[i] <= '9') {
				conta--;
				cadena[conta] = cadena[i];
			}
			i--;
			conta--;
		}
	}
	
	/*public void duplica125EnCadena() {
		int i = 0, int conta = 0;
		for(i = 0; cadena[i] != '\0'; i++, conta++)
			if(cadena[i] >= '0' && cadena[i] <= '9')
				conta++;
		i--; conta--;
		for(; conta > 0; i--, conta--){
			cadena[conta] = cadena[i];
			if(cadena[i] >= '0' && cadena[i] <= '9') {
				conta--;
				cadena[conta] = cadena[i];
			}
		}
	}*/
	
	//metodos recursivos buscados en internet:
	public void eliminaNumerosEnCadena() {
		int i = 0;
		int j = 0;
		while(cadena[i] != '\0') {
			if(cadena[i] < '0' || cadena[i] > '9') {
				cadena[j] = cadena[i];
				j++;
			}
			i++;
		}
		while (cadena[j] != '\0') {
			cadena[j] = '\0';
			j++;
		}
	}
	
	/*public void eliminaNumerosEnCadena() {
		int i, j; i = j = 0;
		for(; cadena[i] != '\0'; i++)
			if(cadena[i] < '0' || cadena[i] > '9') {
				cadena[j] = cadena[i];
				j++;
			}
		for(; cadena[j] != '\0'; j++)
			cadena[j] = Character.MIN_VALUE;
	}*/
	
	public void elimina0246EnCadena() {
		int i = 0; 
		int j = 0;
		while (cadena[i] != '\0') {
			if(i % 2 != 0) {
				cadena[j] = cadena[i];
				j++;
			}
			i++;
		}
		while(cadena[j] != '\0') {
			cadena[j] = '\0';
			j++;
		}
	}
	
	/*public void elimina0246EnCadena() {
		int i, j; i = j = 0;
		for(; cadena[i] != '\0'; i++)
			if(i % 2 != 0) {
				cadena[j] = cadena[i];
				j++;
			}
		for(; cadena[j] != '\0'; j++)
			cadena[j] = '\0';
	}*/
	
	public void elimina1357EnCadena() {
		int i = 0;
		int j = 0;
		while (cadena[i] != '\0') {
			if(i % 2 == 0) {
				cadena[j] = cadena[i];
				j++;
			}
			i++;
		}
		while(cadena[j] != '\0') {
			cadena[j] = '\0';
			j++;
		}
	}
	
	/*public void elimina1357EnCadena() {
	int i, j; i = j = 0;
	for(; cadena[i] != '\0'; i++)
		if(i % 2 == 0) {
			cadena[j] = cadena[i];
			j++;
		}
	for(; cadena[j] != '\0'; j++)
		cadena[j] = '\0';
	}*/
	
	public void duplica0246EnCadena() {
		System.out.println(cadena.length);
		int i = 0;
		while(cadena[i] != '\0')
			i++;
		if(i > 0) {
			int j = i + i/2 + i%2;
			cadena[j] = '\0';
			i--;
			j--;
			while(i >= 0) {
				cadena[j] = cadena[i];
				if(i % 2 != 0) {
					j--;
					cadena[j] = cadena[i];
				}
				i--;
				j--;
			}
		}
	}
	
	/*public void duplica0246EnCadena1() {
		System.out.println(cadena.length);
		int i = 0;
		for(; cadena[i] != '\0'; i++);
		if(i > 0) {
			int j = i + i/2 + i%2;
			cadena[j] = '\0';
			i--; j--;
			for(; i >= 0; i--, j--) {
				cadena[j] = cadena[i];
				if(i % 2 != 0) {
					j--;
					cadena[j] = cadena[i];
				}
			}
		}
	}*/
	
	public void duplicaEnCadena(char caracter) {
		int i = 0;
		int conta = 0;
		while (cadena[i] != '\0') {
			if(cadena[i] == caracter)
				conta++;
			i++;
			conta++;
		}
		i--;
		conta--;
		while(conta >= 0) {
			cadena[conta] = cadena[i];
			if(cadena[i] == caracter) {
				conta--;
				cadena[conta] = cadena[i];
			}
			i--;
			conta--;
		}
	}
	
	/*public void duplicaEnCadena(char caracter) {
		int i, conta; i = conta = 0;
		for(; cadena[i] != '\0'; i++, conta++) {
			if(cadena[i] == caracter)
				conta++;
		}
		i--; conta--;
		for(; conta >= 0; i--, conta--) {
			cadena[conta] = cadena[i];
			if(cadena[i] == caracter) {
				conta--;
				cadena[conta] = cadena[i];
			}
		}
	}*/
	
	public void duplica1357EnCadena() {
		System.out.println(cadena.length);
		int i = 0;
		while(cadena[i] != '\0')
			i++;
		if(i > 0) {
			int j = i + i/2 + i%2;
			cadena[j] = '\0';
			i--;
			j--;
			while(i >= 0) {
				cadena[j] = cadena[i];
				if(i % 2 == 0) {
					j--;
					cadena[j] = cadena[i];
				}
				i--;
				j--;
			}
		}
	}
	
	/*public void duplica0246EnCadena1() {
		System.out.println(cadena.length);
		int i = 0;
		for(; cadena[i] != '\0'; i++);
		if(i > 0) {
			int j = i + i/2 + i%2;
			cadena[j] = '\0';
			i--; j--;
			for(; i >= 0; i--, j--) {
				cadena[j] = cadena[i];
				if(i % 2 != 0) {
					j--;
					cadena[j] = cadena[i];
				}
			}
		}
	}*/
	
}
