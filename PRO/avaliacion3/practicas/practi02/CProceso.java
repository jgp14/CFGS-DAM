package practicas.practi02;

public class CProceso {
	private String identificador;
	private String titulo;
	private float arancel;

	public CProceso(String ide, String tit, float ara) {
		identificador = ide;
		titulo = tit;
		arancel = ara;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String ide) {
		identificador = ide;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String tit) {
		titulo = tit;
	}

	public float getArancel() {
		return arancel;
	}

	public void setArancel(float ara) {
		arancel = ara;
	}

	public void mostrar() {
		System.out.println
		(identificador + "\t\t" + titulo + "\t" + arancel);
	}
}
