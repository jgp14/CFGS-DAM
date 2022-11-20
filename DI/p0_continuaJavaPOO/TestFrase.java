package p0_continuaJavaPOO;

public class TestFrase {
    
    public static void main(String[] args){

        String cadena = " Como me gusta  programar en Java ";
        Frase frase = new Frase(cadena);
        
        System.out.print("-> Frase original: ");
        System.out.print(frase.obtenerFrase());
        
        System.out.print("\n-> Frase sin blancos al principio y al final: ");
        System.out.print(frase.eliminaBlancos(cadena));

        System.out.print("\n-> Numero de letras: ");
        System.out.print(frase.contarLetras(cadena));

        System.out.print("\n-> Frase invertida: ");
        System.out.print(frase.invertirFrase(cadena));

        System.out.print("\n-> Numero de palabras: ");
        System.out.print(frase.contarPalabras(cadena));

        System.out.print("\n-> Palabras de la frase: ");
        String[] palabras = frase.separarPalabras(cadena);
        for(int i = 0; i < palabras.length; i++)
            System.out.println('\t'+palabras[i]);

        System.out.print("\n-> Posicion primera vocal: ");
        System.out.print(frase.primeraVocal(cadena));

        System.out.print("\n-> Posicion ultima vocal: ");
        System.out.print(frase.ultimaVocal(cadena));

        if(frase.comprobarMayuscula(cadena))
            System.out.print("\n-> La primera letra es mayuscula");

        System.out.print("\n-> Frase en mayusculas: ");
        System.out.print(frase.convertirMayuscula(cadena));

        System.out.print("\n-> Frase en minusculas: ");
        System.out.print(frase.convertirMinuscula(cadena));

        System.out.print("\n-> Letras de la frase: ");
        System.out.print("\n\t");
        char[] ch = frase.vectorizar(cadena);
        for(int i = 0; i < ch.length; i++)
            System.out.print(" "+ch[i]);
        
    }

}
