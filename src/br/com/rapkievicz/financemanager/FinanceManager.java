package br.com.rapkievicz.financemanager;

import java.util.ArrayList;
import java.util.List;

public class FinanceManager {
	private List<Expense> expenses;

	public FinanceManager() {
		this.expenses = new ArrayList<>();
	}

	public void addExpense(Expense expense) {
		expenses.add(expense);
	}

	public double calculateTotalExpense() {
		double total = 0;
		for (Expense expense : expenses) {
			total += expense.getAmount();
		}
		return total;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}
}
