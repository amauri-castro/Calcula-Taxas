package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.Payer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Payer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			System.out.printf("Tax payer #%d data:\n", i);
			System.out.print("Individual or company (i/c)?");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			Double anualIncome = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpend = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpend));
			}
			else if (ch == 'c') {
				System.out.print("Number of employees: ");
				int employeeNumber = sc.nextInt();
				list.add(new Company(name, anualIncome, employeeNumber));
			}
		}
		
		double sum = 0.0;
		System.out.println("TAXES PAID:");
		for (Payer payer : list) {
			System.out.println(payer.getName() + ": $ " + String.format("%.2f", payer.tax()) );
			sum += payer.tax();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $" + String.format("%.2f", sum));
		
		sc.close();
	}

}
