package objetos_compostos_brinquedos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Crianca {

	String nome, sexo;
	int idade;
	
	ArrayList<Brinquedo> listaBrinquedos = new ArrayList<Brinquedo>(); 

	void cadastra() {
		nome = JOptionPane.showInputDialog("Nome da criança:");
		idade = Integer.parseInt(JOptionPane.showInputDialog("Idade:"));
		sexo = JOptionPane.showInputDialog("Sexo: M ou F");
		String mais = JOptionPane.showInputDialog("Deseja cadastrar brinquedos? S ou N");
		while(mais.equals("S")){
			Brinquedo d = new Brinquedo();
			d.cadastraBrinquedo(idade);
			listaBrinquedos.add(d);
			mais = JOptionPane.showInputDialog("Deseja cadastrar mais algum brinquedo? S ou N");
		}
	}
	
	String seApresente() {
		return nome;
	}
	
	String listarBrinquedos(){
		String ret = "";
		for (Brinquedo bri : listaBrinquedos) {
			ret += bri.mostraBrinquedo();
		}
		if (ret.equals(""))
			ret = "Não possue Brinquedos\n";
		
		return ret;
	}

	boolean possuiBrinquedo(String nmBrinquedo){
		for (Brinquedo bri : listaBrinquedos) {
			if (bri.nome.equals(nmBrinquedo))
				return true;
		}
		return false;
	}
	
}