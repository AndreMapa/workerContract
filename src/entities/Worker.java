package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enun.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void remoceContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income(Integer year, Integer month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for(HourContract c : contracts) {
			cal.setTime(c.getDate());
			int cYear = 1 + cal.get(Calendar.MONTH);
			int cMonth = cal.get(Calendar.YEAR);
			if(year == cYear && month == cMonth) {
				sum +=c.totalValue();
			}
		}
		return sum;
	}

	public String getName() {
		return name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	
}
