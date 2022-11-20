package com.example.eratostenes;

import java.util.ArrayList;
import java.util.List;

public class CribaEratostenes {

    private List<String> numeros = new ArrayList<>();

    public List<String> generaNumerosPrimos(int n){
        for(int i =1; i<=n; i++)
            if(isPrime(i))
                numeros.add(String.valueOf(i));
            else numeros.add("");
        return numeros;
    }

    //https://es.stackoverflow.com/questions/
    // 34895/determinar-si-el-n%C3%BAmero-es-primo
    //Revisa si un numero entero es primo o no.
    private boolean isPrime(int n) {
        boolean isPrime = true;
        //revisa si n es multiplo de 2
        if (n%2==0) isPrime = false;
        else//si no, solo revisa los impares
            for(int i=3;i*i<=n;i+=2)
                if(n%i==0) isPrime = false;
        if(n==2) isPrime = true;
        return isPrime;
    }

}
