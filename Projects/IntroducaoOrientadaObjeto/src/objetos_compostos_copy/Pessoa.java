package objetos_compostos_copy;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Pessoa {

	String nome;
	double peso, altura;
	Dvd meuDvd = new Dvd(); 
			
	double calculaImc() {
		return peso / (altura * altura);
	}

	void cadastra() {
		nome = JOptionPane.showInputDialog("Nome da pessoa");
		peso = Double.parseDouble(JOptionPane.showInputDialog("Peso"));
		altura = Double.parseDouble(JOptionPane.showInputDialog("Altura"));
		meuDvd.cadastraDvd(); 
	}

	String categoriaImc(){
		
		double imc = calculaImc();
		
		if (imc < 18)
			return "Abaixo do peso"; 
		else
			if(imc > 29)
				return "Acima do peso";
			else
				return "Peso ideal";
	}
	String seApresente() {
		DecimalFormat df = new DecimalFormat("##.00");
		return nome + ": " + df.format(calculaImc()) + "\n"
				+ "Categoria: " + categoriaImc()
				+ "\n\n"
				+ meuDvd.mostraDvd();
	}

}