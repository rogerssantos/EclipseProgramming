
public class UsaPilhaADCalculadora {

	public static void main(String[] args) {

		//Implemente o funcionamento de calculadoras capazes de resolver expressões.
		//Elas trabalham com expressões pós-fixadas, então para avaliarmos uma expressão
		//como (1-2)*(4+5) podemos digitar 1 2 – 4 5 + *. O funcionamento dessas
		//calculadoras é muito simples. Cada operando é empilhado numa pilha de valores.
		//Quando se encontra um operador, desempilha-se o número apropriado de operandos
		//(dois para operadores binários e um para operadores unários), realiza-se a operação
		//devida e empilha-se o resultado. Deste modo, na expressão acima, são empilhados
		//os valores 1 e 2. Quando aparece o operador -, 1 e 2 são desempilhados e o
		//resultado da operação, no caso -1 (= 1 - 2), é colocado no topo da pilha.
		//A seguir, 4 e 5 são empilhados. O operador seguinte, +, desempilha o 4 e o 5
		//e empilha o resultado da soma, 9. Nesta hora, estão na pilha os dois resultados
		//parciais, -1 na base e 9 no topo. O operador *, então, desempilha os dois e
		//coloca -9 (= -1 * 9) no topo da pilha. Implemente para os operadores + - * / .
		
		PilhaADCalculadora p = new PilhaADCalculadora();
		System.out.println("Empilhando...");
		p.empilha("Laranja");
		p.empilha("Maça");
		p.empilha("Limão");
		p.empilha("Melância");
		p.empilha("Abóbora");
		while (p.estaVazia() == false) {
			System.out.println(p.desempilhar());
		}
		
	}
}