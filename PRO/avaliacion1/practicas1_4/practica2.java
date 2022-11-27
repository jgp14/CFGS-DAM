package practicas1_4;

public class practica2 {

	public static void main(String[] args) {
		int i, j, num; char letra;
		num = 32; letra = (char)num;
		System.out.print(" ");
		for(i = 1; i <= 10; i++) {
			for(j = i; j < (i+10) && num <= 126; j++) {
				if(num < 99)
					System.out.print(num+" "+ letra+"   ");
				else // num >= 99
					System.out.print(num+" "+ letra+"  ");
				num++;
				letra = (char)num;
			}
			System.out.println("");
			if(num < 100) System.out.print(" ");
			else System.out.print(""); // num >= 100
		}
	}
}
