package objetos_compostos_copy;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PrincipalPessoaDvd {

	static ArrayList<Pessoa> lista = new ArrayList<Pessoa>();

	public static void main(String[] args) {

		String menu = "1 - Cadastrar Pessoa \n"
				+ "2 - Listar Dvd de uma pessoa\n"
				+ "3 - Listar pessoas que possuem um DVD\n"
				+ "4 - Listar Dvd pessoas abaixo do peso\n\n"
				+ "5 Sair\n";

		int op = 0;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (op) {
			case 1:
				cadastrar();
				break;
			case 2:
				mostraDvdPessoa();
				break;
			case 3:
				pessoasPossuemDvd();
				break;
			case 4:
				dvdsPessoasAbaixoPeso();
				break;
			}
		} while (op != 5);

	}

	static void cadastrar() {
		Pessoa p = new Pessoa();
		p.cadastra();
		lista.add(p);
	}

	static void mostraDvdPessoa() {
		String nomeBusca = JOptionPane.showInputDialog("Nome da pessoa");
		String ret = "";
		for (Pessoa p : lista) {
			if (p.nome.equals(nomeBusca)) {
				ret += p.meuDvd.mostraDvd();
			}
		}
		if (ret.equals(""))
			ret = "Pessoa n�o encontrada!";

		JOptionPane.showMessageDialog(null, ret);
	}

	static void pessoasPossuemDvd() {
		String nomeBusca = JOptionPane.showInputDialog("Nome do DVD");
		String ret = "";
		for (Pessoa p : lista) {
			if (p.meuDvd.nome.equals(nomeBusca)) {
				ret += p.nome + "\n";
			}
		}
		if (ret.equals(""))
			ret = "N�o existem pessoas com esse DVD!";

		JOptionPane.showMessageDialog(null, ret);
	}

	static void dvdsPessoasAbaixoPeso() {
		String ret = "";
		for (Pessoa p : lista) {
			if (p.categoriaImc().equals("Abaixo do peso")) {
				ret += p.meuDvd.mostraDvd();
			}
		}
		if (ret.equals(""))
			ret = "N�o existem pessoas com esta categoria de peso!";

		JOptionPane.showMessageDialog(null, ret);
	}

}
