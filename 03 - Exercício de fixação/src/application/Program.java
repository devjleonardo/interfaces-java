package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PayPalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato:");
		
		System.out.print("Número: ");
		int number = scanner.nextInt();
		
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(scanner.next(), dateTimeFormatter);
		
		System.out.print("Valor do contrato: ");
		double totalValue = scanner.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.print("Entre com o numero de parcelas: ");
		int n = scanner.nextInt();
		
		ContractService contractService = new ContractService(new PayPalService());
		contractService.processContract(contract, n);
		
		System.out.println("Parcelas:");
		
		for (Installment installment : contract.getInstallments()) {
			System.out.println(installment);
		}
		
		scanner.close();
	}
	
}
