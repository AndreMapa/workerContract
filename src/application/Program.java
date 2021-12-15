package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enun.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		Department department = new Department(sc.nextLine());
		
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		WorkerLevel level = WorkerLevel.valueOf(sc.nextLine());
		System.out.print("Base salary: ");
		Double baseSalary = sc.nextDouble();
		Worker worker = new Worker(name, level, baseSalary, department);
		
		System.out.print("How many contracts to this worker? ");
		int quantity = sc.nextInt();
		
		for (int i = 0; i < quantity; i++) {
			System.out.println("Enter contract #" + (i+1) + " data");
			System.out.print("Date(DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double value = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			
			HourContract hourContract = new HourContract(contractDate, value, hours);
			worker.addContract(hourContract);
		}
		
		System.out.print("\nEnter month an year to calculate income(MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		double income = worker.income(month, year);
		System.out.println("Name: " + worker.getName() + 
				"\nDepartment: " + worker.getDepartment().getName() +
				"\nIncome for " + monthAndYear + ": "  + String.format("%.2f", income));
		sc.close();
	}

}
