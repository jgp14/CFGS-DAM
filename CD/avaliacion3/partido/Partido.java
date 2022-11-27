package partido;

import java.sql.Time;
import java.util.Date;

public class Partido {
    private Date data;
    private Time hora;
    private int puntuacionA;
    private int puntuacionB;

    //un partido xógase entre 2 equipos,
    //polo tanto haberá que instanciar dúas variábeis desa clase
    private Equipo equipoA;
    private Equipo equipoB;

    public Partido(Date data, Time hora, int puntuacionA, int puntuacionB, Equipo equipoA, Equipo equipoB) {
        this.data = data;
        this.hora = hora;
        this.puntuacionA = puntuacionA;
        this.puntuacionB = puntuacionB;
        this.equipoA = equipoA;
        this.equipoB = equipoB;
    }

    //getters e setters
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public int getPuntuacionA() {
		return puntuacionA;
	}

	public void setPuntuacionA(int puntuacionA) {
		this.puntuacionA = puntuacionA;
	}

	public int getPuntuacionB() {
		return puntuacionB;
	}

	public void setPuntuacionB(int puntuacionB) {
		this.puntuacionB = puntuacionB;
	}

	public Equipo getEquipoA() {
		return equipoA;
	}

	public void setEquipoA(Equipo equipoA) {
		this.equipoA = equipoA;
	}

	public Equipo getEquipoB() {
		return equipoB;
	}

	public void setEquipoB(Equipo equipoB) {
		this.equipoB = equipoB;
	}
    
}
