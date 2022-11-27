package inmobiliaria;

import java.util.List;

public class Axencia {

    List<Aluguer> operacions;

    public Axencia(List<Aluguer> operacions) {
        this.operacions = operacions;
    }

	public List<Aluguer> getOperacions() {
		return operacions;
	}

	public void setOperacions(List<Aluguer> operacions) {
		this.operacions = operacions;
	}


}
