package introducao_oo;

import javax.swing.JOptionPane;

public class Dvd {

	String titulo;
	int anoLancamento;
	double valor;

	void cadastraDvd() {
		titulo = JOptionPane.showInputDialog("Titulo:");
		anoLancamento = Integer.parseInt(JOptionPane.showInputDialog("Ano de lan�amento:"));
		valor = Double.parseDouble(JOptionPane.showInputDialog("Valor:"));
	}
	
	String seApresente() {
		return "Nome: " + titulo + "\n"
				+ "Ano de lan�amento: " + anoLancamento + "  Valor: " + valor;
	}

}