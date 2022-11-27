package partidobasket;

public class PartidoApp {

	public static void main(String[] args) {
		
		Xogadora x11 = new Xogadora("A1", 15);
		Xogadora x12 = new Xogadora("A2", 8);
		Xogadora[] xogadoras1 = new Xogadora[] {x11, x12}; 
		Equipo equipo1 = new Equipo(xogadoras1, 1);
		
		Xogadora x21 = new Xogadora("B1", 3);
		Xogadora x22 = new Xogadora("B2", 11);
		Xogadora[] xogadoras2 = new Xogadora[] {x21, x22}; 
		Equipo equipo2 = new Equipo(xogadoras2, 1);
		
		Partido partido = new Partido(equipo1, equipo2);
		int numGanhador = partido.verificarGanador();
		
		System.out.println("Equipo gañador: " + numGanhador);
		
		
		/*Xogadora x11 = new Xogadora("A1", 15);
		Xogadora x12 = new Xogadora("A2", 0);
		Xogadora[] xogadoras1 = new Xogadora[] {x11, x12}; 
		
		Xogadora x21 = new Xogadora("B1", 3);
		Xogadora x22 = new Xogadora("B2", 12);
		Xogadora[] xogadoras2 = new Xogadora[] {x21, x22}; 
		
		Equipo equipo1 = new Equipo(xogadoras1, 1);
		Equipo equipo2 = new Equipo(xogadoras2, 1);
		
		Partido partido = new Partido();
		int puntos1 = x11.getPuntos() + x12.getPuntos();
		int puntos2 = x21.getPuntos() + x22.getPuntos();
		
		partido.setSumaEquipos(puntos1, puntos2);
		partido.Ok();
		System.out.println(partido.getMensaxeEquipos());*/
	}
	
}
