package cualificacions;

public class Cualificar {

	private String nome;
	private int cualificacion;
	private int modulo;
	private String dni;
	
	
	public Cualificar(String nome, int cualificacion, 
			int modulo, String dni) {
		super();
		this.cualificacion = cualificacion;
		this.dni = dni;
		this.modulo = modulo;
		this.nome = nome;
	}
	
	
	public boolean aprobado() {
		
		boolean aprobado = false;
		if (this.cualificacion >= 5)
			aprobado = true;
		return aprobado;
	}
	
	
	public void menu() {
		System.out.println("Codigos de modulos: ");
		System.out.println("LMSXI -> 1; SSII --> 2; BBDD --> 3;");
		System.out.println("PRO ---> 4; CCDD --> 5; FOL ---> 6");
	}
	
	
	public String nomeModulo() {
		String nomeModulo = null;
		if(getModulo() == 1)
			nomeModulo = "Linguaxes de Marcas e Sistemas "
					+ "de Xestion de Informacion (LMSXI)";
		else if(getModulo() == 2)
			nomeModulo = "Sistemas Informaticos (SSII)";
		else if(getModulo() == 3)
			nomeModulo = "Bases de Datos (BBDD)";
		else if(getModulo() == 4)
			nomeModulo = "Programacion (PRO)";
		else if(getModulo() == 5)
			nomeModulo = "Contornos de Desenvolvemento (CCDD)";
		else
			nomeModulo = "Formacion Orientacion Laboral (FOL)";			
		return nomeModulo;
	}
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		char[] nomechar;
		int i;
		nomechar = nome.toCharArray();
		i = 0;
		for(i = 0; i < nome.length(); i++) {
			if((nomechar[i] >= 'a' && nomechar[i] <= 'z')
			|| (nomechar[i] >= 'A' && nomechar[i] <= 'Z')
			|| nomechar[i] == ',' || nomechar[i] == ' ')
				this.nome = nome;
			else this.nome = "errornome";
		}
	}


	public int getCualificacion() {
		return cualificacion;
	}


	public void setCualificacion(int cualificacion) {
		if (cualificacion <= 10 && cualificacion >= 1)
			this.cualificacion = cualificacion;
		else this.cualificacion = -1;
	}


	public int getModulo() {
		return modulo;
	}


	public void setModulo(int modulo) {
		if (modulo >= 1 && modulo <= 6)
			this.modulo = modulo;
		else this.modulo = -1;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		char[] dnichar;
		int j;
		if (dni.length() == 9) {
			dnichar = dni.toCharArray();
			j = 0;
			for(j = 0; j < 8; j++) {
				if((dnichar[j] >= '0' && dnichar[j] <= '9')
				&& (dnichar[8] >= 'A' && dnichar[8] <= 'Z')
				&& (dnichar[8] != 'O'))
					this.dni = dni;
				else this.dni = "errordni";
			}
		}
		else this.dni = "errordni";
	}
	

	@Override
	public String toString() {
		return "Cualificar [nome=" + nome + ", cualificacion=" + 
	cualificacion + ", modulo=" + modulo + ", dni=" + dni + "]";
	}
	
}
