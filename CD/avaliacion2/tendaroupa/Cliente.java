package tendaroupa;

public class Cliente {

	private static final int nArtigos = 2;
	Prenda[] cesta = new Prenda[nArtigos];
	private double importe;
	
	public Cliente(Prenda[] cesta) {
		super();
		this.cesta = cesta;
	}
	
	public Prenda[] getCesta() {
		return cesta;
	}
	
	public double setImporte() {
		Prenda[] cesta = this.cesta;
		for(int k = 0; k < this.getCesta().length; k++)
    		this.importe += cesta[k].getPrezo() * cesta[k].getCantidade();
    	return this.importe;
	}
	
	public double getImporte() {
		return importe;
	}
}
