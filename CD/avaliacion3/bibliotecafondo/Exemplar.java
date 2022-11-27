package bibliotecafondo;

import java.util.Date;

public class Exemplar {
	 
	private String ISBN;
	private Date dataPublic;
	private String editorial;
	private String linguaxePub;
	
	public Exemplar(String iSBN, Date dataPublic, String editorial, String linguaxePub) {
		super();
		ISBN = iSBN;
		this.dataPublic = dataPublic;
		this.editorial = editorial;
		this.linguaxePub = linguaxePub;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public Date getDataPublic() {
		return dataPublic;
	}

	public void setDataPublic(Date dataPublic) {
		this.dataPublic = dataPublic;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getLinguaxePub() {
		return linguaxePub;
	}

	public void setLinguaxePub(String linguaxePub) {
		this.linguaxePub = linguaxePub;
	}
	
	
}
