package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contrato;
import entities.Installment;
import services.GenerateInstallments;
import services.ServicoPaypal;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
//		Date data = sdf.parse(sc.next());
		String data = sc.next();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateContract = LocalDate.parse(data, format);

		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();

		Contrato contrato = new Contrato(number, dateContract, totalValue);

		System.out.print("Enter number of installments: ");
		int n = sc.nextInt();
		
		System.out.println("Installments: ");
		
		GenerateInstallments generateInstallments = new GenerateInstallments(new ServicoPaypal());
		generateInstallments.geraParcela(contrato, n);
		
		for(Installment parc : contrato.getInstall()) {
			
			System.out.println(parc.getAmount() + " - " + parc.getDueDate() );
		}
		System.out.println(contrato.toString());
		sc.close();
	}

}
