package br.com.rapkievicz.financemanager;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorFinancas {
	private List<Despesa> despesas;

	public GerenciadorFinancas() {
		this.despesas = new ArrayList<>();
	}

	public void adicionarDespesa(Despesa despesa) {
		despesas.add(despesa);
	}

	public double calcularDespesaTotal() {
		double total = 0;
		for (Despesa despesa : despesas) {
			total += despesa.getValor();
		}
		return total;
	}

	public List<Despesa> getDespesas() {
		return despesas;
	}
}
