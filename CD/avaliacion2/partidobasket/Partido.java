package partidobasket;

public class Partido {

	private Equipo equipo1;
    private Equipo equipo2;
    private int suma1, suma2;
    private int ganhador;
	
    public Partido(Equipo equipo1, Equipo equipo2) {
		super();
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}
    
    public int sumaEquipo1() {
    	Xogadora[] xogadoras = this.equipo1.getXogadoras();
    	for(int k = 0; k < this.equipo1.getXogadoras().length; k++)
    		this.suma1 += xogadoras[k].getPuntos();
    	return this.suma1;
    }
    
    public int sumaEquipo2() {
    	Xogadora[] xogadoras = this.equipo2.getXogadoras();
    	for(int k = 0; k < this.equipo2.getXogadoras().length; k++)
    		this.suma2 += xogadoras[k].getPuntos();
    	return this.suma2;
    }
    
    public int verificarGanador() {
    	this.ganhador = 0;
    	this.suma1 = this.equipo1.sumaEquipo();
    	this.suma2 = this.equipo2.sumaEquipo();
    	if(this.suma1 > this.suma2)
    		return ganhador = 1;
    	else if(this.suma1 < this.suma2)
    		return ganhador = 2;
    	return this.ganhador;
    }
    
    /*private static String OK = "GANADOR DO PARTIDO E O EQUIPO: ";
    private static String NOTOK = "EMPATE NO PARTIDO";
    private int suma;

	public void setSumaEquipos(int puntos1, int puntos2) {
    	suma = puntos1 - puntos2;	 
    }
    
    private int getSumaEquipos() {
    	return suma;
    }
    
    public boolean Ok() {
    	boolean ok = false;
    	if (getSumaEquipos() != 0)
    		ok = true;
    	return ok;
    }
    
    public String getMensaxeEquipos() {
    	String resultado;
    	if(Ok() == true) {
    		if(getSumaEquipos() > 0)
        		resultado = OK+"1";
    		else resultado = OK+"2";
    	}
    	else resultado = NOTOK;
    	return resultado;
    }*/
    
}
