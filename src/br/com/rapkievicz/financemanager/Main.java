package br.com.rapkievicz.financemanager;

import java.util.List;
import java.util.Scanner;

public class Main {
	private static GerenciadorFinancas gerenciadorFinancas;

	public static void main(String[] args) {
		gerenciadorFinancas = new GerenciadorFinancas();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("=== Calculadora de Finanças Pessoais ===");
			System.out.println("1. Adicionar despesa");
			System.out.println("2. Calcular despesa total");
			System.out.println("3. Listar despesas");
			System.out.println("4. Sair");
			System.out.print("Escolha uma opção: ");

			int opcao = scanner.nextInt();
			scanner.nextLine(); // Consumir a quebra de linha

			switch (opcao) {
			case 1:
				adicionarDespesa(scanner);
				break;
			case 2:
				calcularDespesaTotal();
				break;
			case 3:
				listarDespesas();
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
			}
		}
	}

	private static void adicionarDespesa(Scanner scanner) {
		System.out.print("Descrição da despesa: ");
		String descricao = scanner.nextLine();

		System.out.print("Valor da despesa: ");
		double valor = scanner.nextDouble();
		scanner.nextLine(); // Consumir a quebra de linha

		Despesa despesa = new Despesa(descricao, valor);
		gerenciadorFinancas.adicionarDespesa(despesa);

		System.out.println("Despesa adicionada com sucesso!");
	}

	private static void calcularDespesaTotal() {
		double despesaTotal = gerenciadorFinancas.calcularDespesaTotal();
		System.out.println("Despesa total: " + despesaTotal);
	}

	private static void listarDespesas() {
		List<Despesa> despesas = gerenciadorFinancas.getDespesas();

		System.out.println("=== Lista de Despesas ===");
		for (Despesa despesa : despesas) {
			System.out.println(despesa.getDescricao() + " - R$" + despesa.getValor());
		}
	}
}