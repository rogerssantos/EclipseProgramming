package introducao_oo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PrincipalDvd {

	static ArrayList<Dvd> lista = new ArrayList<Dvd>();

	public static void main(String[] args) {
		
		String menu = "1 - Cadastrar DVD\n"
				+ "2 - Listar todos\n"
				+ "3 - Soma os valores\n"
				+ "4 - Procurar DVD por ano de lan�amento\n"
				+ "5 - Procurar DVD por titulo\n\n"
				+ "6 - Sair\n";
		
		int op = 0;
		try{
			
			do{
				op = Integer.parseInt(
						JOptionPane.showInputDialog(menu));
				
				switch (op) {
				case 1:
					Dvd d = new Dvd();
					d.cadastraDvd();
					lista.add(d);
					break;
				case 2:
					String str = "*** Dvds cadastrados ***\n\n";
					
					for (Dvd dvd : lista){
						str += dvd.seApresente();
					}
					JOptionPane.showMessageDialog(null, str);
					break;
				case 3:
					double ret = calculaPrecoTotal();
					JOptionPane.showMessageDialog(null, ret);
						
					break;
				case 4:
					int anoBusca = Integer.parseInt(JOptionPane.showInputDialog("Ano: "));
					String ret1 = "";
					for (Dvd dvd : lista){
						if(dvd.anoLancamento == anoBusca)
							ret1 += dvd.seApresente();
					}
					if(ret1.equals(""))
						ret1 = "N�o encontrado";
					
					JOptionPane.showMessageDialog(null, ret1);
						
					break;
					
				case 5:
					String tituloBusca = JOptionPane.showInputDialog("Titulo: ");
					String ret2 = "";
					for (Dvd dvd : lista){
						if(dvd.titulo.equals(tituloBusca))
							ret2 += dvd.seApresente();
					}
					if(ret2.equals(""))
						ret2 = "N�o encontrado";
					
					JOptionPane.showMessageDialog(null, ret2);
						
					break;
				}
				
			}while(op != 6);
		}
		catch (NumberFormatException e){
			//System.err.println("Error: Invalid Input!");
			JOptionPane.showMessageDialog(null, "You chose to leave :( ...");
		}
	}
	
	
	static double calculaPrecoTotal() {
		double valorTotal = 0;
		for (Dvd dvd : lista){
			valorTotal += dvd.valor;
		}
		return valorTotal;
	}
}
