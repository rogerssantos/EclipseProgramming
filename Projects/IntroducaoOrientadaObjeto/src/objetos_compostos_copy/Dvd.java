package objetos_compostos_copy;

import javax.swing.JOptionPane;

public class Dvd {

	String nome;
	int ano;
	double valor;

	void cadastraDvd() {
		nome = JOptionPane.showInputDialog("Nome do dvd:");
		ano = Integer.parseInt(JOptionPane.showInputDialog("Ano de lançamento:"));
		valor = Double.parseDouble(JOptionPane.showInputDialog("Valor:"));
	}
	
	String mostraDvd() {
		return "DVD(" + nome + " - " + ano + " - " + valor + ")\n";  
//		return "Nome: " + nome + "\n"
//				+ "Ano de lançamento: " + anoLancamento + "  Valor: " + valor;
	}

}