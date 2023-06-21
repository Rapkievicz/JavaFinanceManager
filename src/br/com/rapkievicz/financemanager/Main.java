package br.com.rapkievicz.financemanager;

import java.util.List;
import java.util.Scanner;

public class Main {
	private static FinanceManager financeManager;

	public static void main(String[] args) {
		financeManager = new FinanceManager();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("=== Calculadora de Finanças Pessoais ===");
			System.out.println("1. Adicionar despesa");
			System.out.println("2. Calcular despesa total");
			System.out.println("3. Listar despesas");
			System.out.println("4. Sair");
			System.out.print("Escolha uma opção: ");

			int option = scanner.nextInt();
			scanner.nextLine(); // Consumir a quebra de linha

			switch (option) {
			case 1:
				addExpense(scanner);
				break;
			case 2:
				calculateTotalExpense();
				break;
			case 3:
				listExpenses();
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
			}
		}
	}

	private static void addExpense(Scanner scanner) {
		System.out.print("Descrição da despesa: ");
		String description = scanner.nextLine();

		System.out.print("Valor da despesa: ");
		double amount = scanner.nextDouble();
		scanner.nextLine(); // Consumir a quebra de linha

		Expense expense = new Expense(description, amount);
		financeManager.addExpense(expense);

		System.out.println("Despesa adicionada com sucesso!");
	}

	private static void calculateTotalExpense() {
		double totalExpense = financeManager.calculateTotalExpense();
		System.out.println("Despesa total: " + totalExpense);
	}

	private static void listExpenses() {
		List<Expense> expenses = financeManager.getExpenses();

		if (expenses.isEmpty()) {
			System.out.println("Nenhuma despesa encontrada.");
		} else {
			for (int i = 0; i < expenses.size(); i++) {
				Expense expense = expenses.get(i);
				System.out.println("[" + i + "] " + expense.getDescription() + " - R$" + expense.getAmount());
			}
		}
	}
}
