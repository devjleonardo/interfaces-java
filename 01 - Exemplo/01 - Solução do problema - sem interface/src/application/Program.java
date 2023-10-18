package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Entre com os dados do aluguel");
		
		System.out.print("Modelo do carro: ");
		String carModel = scanner.nextLine();
		
		System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(scanner.nextLine(), dateTimeFormatter);
		
		System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(scanner.nextLine(), dateTimeFormatter);
		
		CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));
		
		System.out.print("Entre com o preço por hora: ");
		double pricePerHour = scanner.nextDouble();
		
		System.out.print("Entre com o preço por dia: ");
		double pricePerDay = scanner.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		rentalService.processInvoice(carRental);
		
		System.out.println("FATURA:");
		System.out.println("Pagamento basico: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
		System.out.println("Imposto: " + String.format("%.2f", carRental.getInvoice().getTax()));
		System.out.println("Pagamento total: " + String.format("%.2f", carRental.getInvoice().getTotalPayment()));
		
		scanner.close();
	}

}
