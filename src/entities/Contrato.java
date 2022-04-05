package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contrato {
	private int contrato;
	private LocalDate dataContrato;
	private Double valorContrato;
	private List<Installment> install = new ArrayList<>();

	public Contrato() {
	}

	public Contrato(int contrato, LocalDate dataContrato, Double valorContrato) {
		this.contrato = contrato;
		this.dataContrato = dataContrato;
		this.valorContrato = valorContrato;
	}

	public int getContrato() {
		return contrato;
	}

	public void setContrato(int contrato) {
		this.contrato = contrato;
	}

	public LocalDate getDataContrato() {
		return dataContrato;
	}

	public void setDataContrato(LocalDate dataContrato) {
		this.dataContrato = dataContrato;
	}

	public Double getValorContrato() {
		return valorContrato;
	}

	public void setValorContrato(Double valorContrato) {
		this.valorContrato = valorContrato;
	}

	public List<Installment> getInstall() {
		return install;
	}

	public void addInstall(Installment installment) {
		install.add(installment);
	}

	public void remInstall(Installment installment) {
		install.remove(installment);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contrato [contrato=");
		builder.append(contrato);
		builder.append(", dataContrato=");
		builder.append(dataContrato);
		builder.append(", valorContrato=");
		builder.append(valorContrato);
		builder.append(", install=");
		builder.append(install);
		builder.append("]");
		return builder.toString();
	}

}	
