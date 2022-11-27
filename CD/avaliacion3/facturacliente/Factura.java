package facturacliente;

import java.util.Date;

public class Factura {

	private float importe;
	private Date dataEmision;
	private Date dataPagamento;
	private String cifEmisor;
	private String cifCliente;
	
	public Factura
	(float importe, Date dataEmision, Date dataPagamento, 
			String cifEmisor, String cifCliente) {
		super();
		this.importe = importe;
		this.dataEmision = dataEmision;
		this.dataPagamento = dataPagamento;
		this.cifEmisor = cifEmisor;
		this.cifCliente = cifCliente;
	}
	
}
