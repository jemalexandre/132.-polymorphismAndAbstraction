package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Taxpayer;
import entities.TaxpayerCompany;
import entities.TaxpayerIndividual;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Taxpayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Taxpayer #" + (i+1) + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			Double anualIncome = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenses = sc.nextDouble();
				Taxpayer tp = new TaxpayerIndividual(name, anualIncome, healthExpenses);
				list.add(tp);
			} else if (ch == 'c') {
				System.out.print("Number of employees: ");
				int numberExployees = sc.nextInt();
				Taxpayer tp = new TaxpayerCompany(name, anualIncome, numberExployees);
				list.add(tp);
			} else {
				System.out.println("Invalid input. Try again!");
			}
		}
		
		double sum = 0.0;
		System.out.println();
		System.out.println("TAXES PAID:");
		for (Taxpayer tp: list) {
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tp.calculateTax()));
			sum += tp.calculateTax();
		}
		System.out.println();
		System.out.printf("TOTAL TAXES: %.2f", sum);
		
		sc.close();
	}
}
