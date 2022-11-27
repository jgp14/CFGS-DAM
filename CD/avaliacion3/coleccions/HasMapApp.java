package coleccions;

import java.util.HashMap;
import java.util.Map;

public class HasMapApp {

	public static void main(String[] args) {
		
		//relacion de vendas por empresa
		//mapa cif->valor
		
		Map<String, Integer> vendas = new HashMap<>();
		vendas.put("B252369", 18000);
		vendas.put("M125458", 29000);
		vendas.put("A369258", 31000);
		//vendas.put("B252369", -1000);
		
		System.out.println("Relacion de empresas (cif)");
		for(String cif: vendas.keySet()) {
			System.out.println(cif);
		}
		
		Integer importeTotal=0;
		System.out.println();
		System.out.println("Relación vendas por empresa");
		for(String cif: vendas.keySet()) {
			System.out.println
			(cif + " facturado " + vendas.get(cif));
			importeTotal += vendas.get(cif).intValue();
		}
		System.out.println("Importe total : " + importeTotal);
	}

}
