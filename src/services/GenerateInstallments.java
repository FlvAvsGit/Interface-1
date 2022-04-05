package services;

import java.time.LocalDate;

import entities.Contrato;
import entities.Installment;

public class GenerateInstallments {

	private ServicoImpl servicoImpl;

	public GenerateInstallments(ServicoImpl servicoImpl) {
		this.servicoImpl = servicoImpl;
	}

	public void geraParcela(Contrato contrato, int numParcela) {
		Double valorParcela = contrato.getValorContrato() / numParcela;
		for (int i = 1; i <= numParcela; i++) {
			int diasVencto = i * 30;
			LocalDate dataVencto = contrato.getDataContrato().plusDays(diasVencto);
			Double valorJuros = valorParcela + servicoImpl.calculaJuros(valorParcela, i);
			Double valorPagamento = valorJuros + servicoImpl.calculaTax(valorJuros);
			Installment insta = new Installment(dataVencto, valorPagamento);
			contrato.addInstall(insta);
		}

	}
}
