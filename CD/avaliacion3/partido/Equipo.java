package partido;

import java.util.ArrayList;
import java.util.List;

public class Equipo {

    //a multiplicidade nos indica que son varios xogadores por equipo
    //entón engadimos unha lista de clase Xogador para contelos
    private List<Xogador> xogadores;

    public Equipo(List<Xogador> xogadores) {
        this.xogadores = xogadores;
    }

    public List<Xogador> getXogadores() {
        return xogadores;
    }

    //A�adido
	public void setXogadores(List<Xogador> xogadores) {
		this.xogadores = xogadores;
	}
    
    
}
