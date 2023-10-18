package application;

import java.util.Locale;
import java.util.Scanner;

import services.BrazilInterestService;
import services.InterestService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Amount: ");
		double amount = scanner.nextDouble();
		
		System.out.print("Months: ");
		int months = scanner.nextInt();
		
		InterestService brazilInterestService = new BrazilInterestService(2.0);
		double payment = brazilInterestService.payment(amount, months);
		
		System.out.println("Payment after " + months + " months:");
		System.out.println(String.format("%.2f", payment));
		
		scanner.close();
	}
	
}
