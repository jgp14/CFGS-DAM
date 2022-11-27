package videoclube;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Emprestimo {

    private Date dataRetirada;
    private Time horaRetirada;
    private double importeTotal;

    private List<Filme> filmes;

    public Emprestimo(Date dataRetirada, Time horaRetirada, double importeTotal, List<Filme> filmes) {
        this.dataRetirada = dataRetirada;
        this.horaRetirada = horaRetirada;
        this.importeTotal = importeTotal;
        this.filmes = filmes;
    }

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public Time getHoraRetirada() {
		return horaRetirada;
	}

	public void setHoraRetirada(Time horaRetirada) {
		this.horaRetirada = horaRetirada;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}
    
    
}
