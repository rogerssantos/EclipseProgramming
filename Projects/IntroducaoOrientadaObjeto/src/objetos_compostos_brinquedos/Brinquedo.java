package objetos_compostos_brinquedos;

import javax.swing.JOptionPane;

public class Brinquedo {

	String nome;
	int idadeMinima;

	String cadastraBrinquedo(int idade) {
		nome = JOptionPane.showInputDialog("Nome do brinquedo: ");
		idadeMinima = Integer.parseInt(JOptionPane.showInputDialog("Idade mínima para brincar: "));
		if (idade < idadeMinima) {
			JOptionPane.showMessageDialog(null, "Brinquedo inválido!\n Idade da criança não atinge idade mínima do brinquedo\n\nTente outra vez!");
			cadastraBrinquedo(idade);
		}
		return nome;
	}

	
	String mostraBrinquedo() {
		return "Brinquedo(" + nome + " - " + idadeMinima + ")\n";
	}

}