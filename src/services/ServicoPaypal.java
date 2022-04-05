package services;

public class ServicoPaypal implements ServicoImpl {

	private static final double PERC_JUROS = 0.01;
	private static final double TAX	= 0.02;

	public Double calculaJuros(Double valor, int numParcela) {
		return valor * (PERC_JUROS * numParcela);
	}
	public Double calculaTax(Double valor) {
		return valor * TAX ;
	}
	

}
