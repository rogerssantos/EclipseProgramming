import java.util.Random;

import javax.swing.JOptionPane;

public class Principal {	
	
	static Pizza p1,p2,p3,p4,p5;
	
	static Tabuleiro tabuleiro = new Tabuleiro(0);

	static ListaJogadores lj = new ListaJogadores();
	
	public static void main(String[] args) {

		//cria todas as pizzas a serem usadas no jogo
		p1 = new Pizza(1);
		preenchePizza(p1, 2, 3, 4, 5);
		
		p2 = new Pizza(3);
		preenchePizza(p2, 4, 6, 7, 9);
		
		p3 = new Pizza(1);
		preenchePizza(p3, 5, 7, 9, 3);
		
		p4 = new Pizza(9);
		preenchePizza(p4, 9, 5, 7, 1);
		
		p5 = new Pizza(6);
		preenchePizza(p5, 6, 7, 8, 9);
		
		preencheTabuleiro();
		
		cadastraJogadores();
		boolean ganhou = false;
		int dado = 0;
		int item = 0;
		Jogador j = null;
		
		Jogador aux = lj.inicio;
		
		while (!ganhou) {
			
			j = aux;

			JOptionPane.showMessageDialog(null, "Vez do jogador rolar o dado: "+j.getNome());
			
			dado = rolaDado();
			JOptionPane.showMessageDialog(null, "Seu dado rolou e parou no numero : "+dado);
			
			if((j.getPosicaoTabulero()+dado)>35)
				j.setPosicaoTabulero((j.getPosicaoTabulero()+dado) -35); 
			else
				j.setPosicaoTabulero(j.getPosicaoTabulero()+dado);
			
			JOptionPane.showMessageDialog(null, "Posição do jogador atual: "+j.getPosicaoTabulero());
			
			item = tabuleiro.getItem(j.getPosicaoTabulero());
			
			
			if(item >9){
				JOptionPane.showMessageDialog(null, "Sua posição é referente a uma casa de sorte ou azar,\n" +
						"porem não foi implementado");
			}else{
				
				JOptionPane.showMessageDialog(null, j.addItemSacola(item));
					
			}
			
			//verifica se a sacola
			ganhou = j.verificaSacolaCheia();
			
			//se o jogador não tiver ganho busca o proximo jogador para jogar
			if(!ganhou)
				aux = aux.getProximo();
		}
		
		JOptionPane.showMessageDialog(null, "O ganhador foi:"+ j.getNome());
		
	}
	
	/**
	 * Metodo para cadastrar os jogadores
	 * @return Lista de jogadores cadastrados
	 */
	private static void  cadastraJogadores() {
		 
		String menu = "1 - Cadastrar\n" +
					  "0 - Sair";
		String menuPizza = "Digite o numero da pizza: \n" +
							"1 - Pizza de Calabreza\n" +
							"2 - Pizza de 4 Queijo\n" +
							"3 - Pizza de Portuguesa\n" +
							"4 - Pizza de Frutos do mar\n" +
							"5 - Pizza de Lombinho\n";
		int op = -1; 
		
		while (op!=0) {
			
			Jogador j = new Jogador();
			String nome = JOptionPane.showInputDialog("Digite o nome do jogador");

			j.setNome(nome);
			
			int pizza = Integer.parseInt(JOptionPane.showInputDialog(menuPizza));
			
			switch (pizza) {
			case 1:j.setPizza(p1);
				break;
			case 2:j.setPizza(p2);
				break;
			case 3:j.setPizza(p3);
				break;
			case 4:j.setPizza(p4);
				break;
			default: j.setPizza(p5);
				break;
			}
			
			j.setPosicaoTabulero(0);
			
			lj.add(j);
			
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
		}
		
	}

	/**
	 * Desenvolvido metodo para adiciona os ingrediente na pizza
	 * @param pizza
	 * @param ingr1
	 * @param ingr2
	 * @param ingr3
	 * @param ingr4
	 * @param ingr5
	 */
	public static void preenchePizza(Pizza pizza, int ingr2, int ingr3, int ingr4, int ingr5){	
		pizza.add(ingr2);
		pizza.add(ingr3);
		pizza.add(ingr4);
		pizza.add(ingr5);
	}

	/**
	 * Desenvolvido metodo para preencher o tabuleiro com os itens do jogo
	 */
	public static void preencheTabuleiro(){
		
		tabuleiro.add(10);
		tabuleiro.add(1);
		tabuleiro.add(11);
		tabuleiro.add(2);
		tabuleiro.add(3);
		tabuleiro.add(11);
		tabuleiro.add(11);
		tabuleiro.add(4);
		tabuleiro.add(5);
		tabuleiro.add(6);
		tabuleiro.add(11);
		tabuleiro.add(11);
		tabuleiro.add(7);
		tabuleiro.add(6);
		tabuleiro.add(11);
		tabuleiro.add(9);
		tabuleiro.add(4);
		tabuleiro.add(7);
		tabuleiro.add(11);
		tabuleiro.add(11);
		tabuleiro.add(8);
		tabuleiro.add(11);
		tabuleiro.add(5);
		tabuleiro.add(1);
		tabuleiro.add(11);
		tabuleiro.add(2);
		tabuleiro.add(11);
		tabuleiro.add(9);
		tabuleiro.add(11);
		tabuleiro.add(3);
		tabuleiro.add(6);
		tabuleiro.add(11);
		tabuleiro.add(8);
		tabuleiro.add(6);
		tabuleiro.add(11);
	}

	/**
	 * Desenvolvido função recursiva case o numero randomico retornar zero
	 * @return inteiro de entre 1 ... 6
	 */
	public static int rolaDado(){
		Random r = new Random();
		int i = r.nextInt(7);
		if (i == 0)
			return rolaDado();
		return i;
	}
}