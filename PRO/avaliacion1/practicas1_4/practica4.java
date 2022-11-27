package practicas1_4;

import java.io.IOException;

import misClases.avaliacion1.CTecla;

public class practica4 {

	public static void main(String[] args) throws IOException {
		CTecla tecla = new CTecla();
		tecla.recogeDixito();
		tecla.recogeVocal();
		tecla.recogeVocalm();
		tecla.recogeConsonante();
		tecla.recogeConsonantem();
		tecla.amosaResultado();
	}

}
