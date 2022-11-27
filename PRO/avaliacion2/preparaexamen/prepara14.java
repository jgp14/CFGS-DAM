package preparaexamen;

import java.io.IOException;

import misClases.avaliacion2.CRecursivo;

public class prepara14 {

	public static void main(String[] args) throws IOException {
		CRecursivo recursivo = new CRecursivo();
		System.out.print("Dame cadena: ");
		recursivo.recolleCadena();
		recursivo.amosaVocalesDuplicadas2(recursivo.total());
	}
}
