package inmobiliaria;

import java.util.Date;

public class Cliente extends Persoa{

    public Cliente(String nome, String dni, String telefono, String localidade, String enderezo, String cposta, Date dataAlta) {
        super(nome, dni, telefono, localidade, enderezo, cposta, dataAlta);
    }
}
