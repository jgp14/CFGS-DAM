package p0_introJavaPOO;

public class TestRacional2 {
    public static void main(String[] args){
        //Crear 2 objetos r1 y r2 
        Racional2 r1 = new Racional2();
        Racional2 r2 = new Racional2(12, 4);

        //Asignar r1 valores
        r1.setNumerador(2);
        r1.setDenominador(4);

        //Visualizar ambos numeros racionales
        System.out.println(r1.visualizarRacional());
        System.out.println(r2.visualizarRacional());

        //Suma de r1 y r2 en r3. Visualizar r3
        Racional2 r3 = new Racional2();
        r3 = r3.sumarRacionales(r1, r2);
        System.out.println(r3.visualizarRacional());

        //Resta de r1 y r2 en r3. Visualizar r3
        r3 = r3.restarRacionales(r1, r2);
        System.out.println(r3.visualizarRacional());

        //Multiplicacion de r1 y r2 en r3. Visualizar r3
        r3 = r3.multiplicarRacionales(r1, r2);
        System.out.println(r3.visualizarRacional());

        //Division de r1 y r2 en r3. Visualizar r3
        r3 = r3.dividirRacionales(r1, r2);
        System.out.println(r3.visualizarRacional());
    }
    
}
