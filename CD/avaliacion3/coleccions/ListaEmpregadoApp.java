package coleccions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaEmpregadoApp {

	public static void main(String[] args) {
		
		List<Empregado> empregados = new ArrayList<>();
		Empregado empregado1 = new Empregado
				("Ana", "00000000D", new Date(), 40000);
		empregados.add(empregado1);
		Empregado empregado2 = new Empregado
				("Antonio", "14255888M", new Date(), 30000);
		empregados.add(empregado2);
		
		int i = 1;
		for(Empregado empregado : empregados) {
			System.out.println(i + " : " + empregado.toString());
			i++;
		}
		
		String dni = "14255888M";
		System.out.println("Procurar o dni " + dni);
		
		for(Empregado empregado : empregados) {
			if(empregado.dni.equals(dni)) {
				System.out.println(empregado.toString());
				break;
			}
		}
	}

}
