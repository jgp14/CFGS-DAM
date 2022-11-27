package pedidospcs;

public class Computadora {

	private Componente placamai;
	private Componente chipset;
	private Componente alimentacion;
	private Componente caixa;
	private Componente refrixeracion;
	private Componente[] adaptadores = new Componente[2];
	private Componente[] procesadores  = new Componente[4];
	private Componente[] modulosRAM  = new Componente[4];
	private Componente cartaVideo;
	
	public Computadora(Componente placamai, Componente chipset, Componente alimentacion, Componente caixa,
			Componente refrixeracion, Componente[] adaptadores, Componente[] procesadores, Componente[] modulosRAM,
			Componente cartaVideo) {
		super();
		this.placamai = placamai;
		this.chipset = chipset;
		this.alimentacion = alimentacion;
		this.caixa = caixa;
		this.refrixeracion = refrixeracion;
		this.adaptadores = adaptadores;
		this.procesadores = procesadores;
		this.modulosRAM = modulosRAM;
		this.cartaVideo = cartaVideo;
	}

	public Componente getPlacamai() {
		return placamai;
	}

	public void setPlacamai(Componente placamai) {
		this.placamai = placamai;
	}

	public Componente getChipset() {
		return chipset;
	}

	public void setChipset(Componente chipset) {
		this.chipset = chipset;
	}

	public Componente getAlimentacion() {
		return alimentacion;
	}

	public void setAlimentacion(Componente alimentacion) {
		this.alimentacion = alimentacion;
	}

	public Componente getCaixa() {
		return caixa;
	}

	public void setCaixa(Componente caixa) {
		this.caixa = caixa;
	}

	public Componente getRefrixeracion() {
		return refrixeracion;
	}

	public void setRefrixeracion(Componente refrixeracion) {
		this.refrixeracion = refrixeracion;
	}

	public Componente[] getAdaptadores() {
		return adaptadores;
	}

	public void setAdaptadores(Componente[] adaptadores) {
		this.adaptadores = adaptadores;
	}

	public Componente[] getProcesadores() {
		return procesadores;
	}

	public void setProcesadores(Componente[] procesadores) {
		this.procesadores = procesadores;
	}

	public Componente[] getModulosRAM() {
		return modulosRAM;
	}

	public void setModulosRAM(Componente[] modulosRAM) {
		this.modulosRAM = modulosRAM;
	}

	public Componente getCartaVideo() {
		return cartaVideo;
	}

	public void setCartaVideo(Componente cartaVideo) {
		this.cartaVideo = cartaVideo;
	}
	
	
}
