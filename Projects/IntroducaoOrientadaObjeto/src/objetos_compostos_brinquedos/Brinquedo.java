package objetos_compostos_brinquedos;

import javax.swing.JOptionPane;

public class Brinquedo {

	String nome;
	int idadeMinima;

	String cadastraBrinquedo(int idade) {
		nome = JOptionPane.showInputDialog("Nome do brinquedo: ");
		idadeMinima = Integer.parseInt(JOptionPane.showInputDialog("Idade m�nima para brincar: "));
		if (idade < idadeMinima) {
			JOptionPane.showMessageDialog(null, "Brinquedo inv�lido!\n Idade da crian�a n�o atinge idade m�nima do brinquedo\n\nTente outra vez!");
			cadastraBrinquedo(idade);
		}
		return nome;
	}

	
	String mostraBrinquedo() {
		return "Brinquedo(" + nome + " - " + idadeMinima + ")\n";
	}

}