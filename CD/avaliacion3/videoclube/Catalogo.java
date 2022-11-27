package videoclube;

//A SEGUINTE CLASE PODERÍA SER OMITIDA DO DIAGRAMA UML

import java.util.List;

public class Catalogo {

  private List<Filme> filmes;

  public Catalogo(List<Filme> filmes) {
      this.filmes = filmes;
  }

  public List<Filme> getFilmes() {
      return filmes;
  }
}
