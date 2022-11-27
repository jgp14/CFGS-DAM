package inmobiliaria;

import java.util.Date;
import java.util.List;

public class Propietario extends Persoa{

    List<Propiedade> propiedades;

    public Propietario(String nome, String dni, String telefono, String localidade, String enderezo, String cposta, Date dataAlta,  List<Propiedade> propiedades) {
        super(nome, dni, telefono, localidade, enderezo, cposta, dataAlta);
        this.propiedades = propiedades;
    }

	public List<Propiedade> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(List<Propiedade> propiedades) {
		this.propiedades = propiedades;
	}

    
}
