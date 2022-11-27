package teoria.capitulo09;

import misClases.teoria.CVector;

public class CApVector2 {
	
	//Visualizar un vector
	public static void visualizarVector(CVector v) {
		//int ne = v.longitud();
		//for(int i = 0; i < ne; i++)
			//System.out.print(v.valorEn(i) + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		double x[] = {1,2,3,4,5,6,7}; 
		//Matriz x CVector vector1 = CVector
		CVector vector1 = new CVector(x);
		//visualizarVector(vector1);
		
		CVector vector2 = new CVector(x);
		//visualizarVector(vector2);
		
		if(vector1 == vector2)
			System.out.println("referencias al mismo objeto");
		else
			System.out.println("referencias a objetos diferentes");
		if(vector1.equals(vector2))
			System.out.println("objetos iguales");
		else
			System.out.println("objetos diferentes");
	}
}
