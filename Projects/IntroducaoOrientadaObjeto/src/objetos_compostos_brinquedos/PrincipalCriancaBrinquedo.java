package objetos_compostos_brinquedos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PrincipalCriancaBrinquedo {

	static ArrayList<Crianca> lista = new ArrayList<Crianca>();

	public static void main(String[] args) {

		String menu = "1 - Cadastrar Criança\n"
				+ "2 - Listar brinquedos de uma criança\n"
				+ "3 - Listar todas as crianças e sesus respectivos brinquedos\n"
				+ "4 - Listar o nome de todas as crianças que possuem um determinado brinquedo\n\n"
				+ "5 Sair\n";

		int op = 0;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (op) {
			case 1:
				cadastrar();
				break;
			case 2:
				mostraBrinquedosCrianca();
				break;
			case 3:
				listarTodos();
				break;
			case 4:
				pessoasPossuemBrinquedo();
				break;
			}
		} while (op != 5);

	}

	static void cadastrar() {
		Crianca p = new Crianca();
		p.cadastra();
		lista.add(p);
	}

	static void mostraBrinquedosCrianca() {
		String nomeBusca = JOptionPane.showInputDialog("Nome de uma criança: ");
		String ret = "";
		for (Crianca p : lista) {
			if (p.nome.equals(nomeBusca)) {
				ret += p.listarBrinquedos()+"\n\n";
			}
		}
		if (ret.equals(""))
			ret = "Criança não encontrada!";

		JOptionPane.showMessageDialog(null, ret);
	}

	static void pessoasPossuemBrinquedo() {
		String nomeBusca = JOptionPane.showInputDialog("Nome do brinquedo");
		String ret = "";
		for (Crianca p : lista) {
			if (p.possuiBrinquedo(nomeBusca)){
				ret += p.nome + "\n";
			}
		}
		if (ret.equals(""))
			ret = "Não existem pessoas com esse brinquedo!";

		JOptionPane.showMessageDialog(null, ret);
	}

	static void listarTodos() {
		String ret = "";
		for (Crianca p : lista) {
			ret += p.nome + " - " + p.idade + " - " + p.sexo + "\n";
			ret += p.listarBrinquedos()+"\n";
			ret += "\n\n";
		}
		if (ret.equals(""))
			ret = "Não existem crianças cadastradas!";

		JOptionPane.showMessageDialog(null, ret);
	}

}
