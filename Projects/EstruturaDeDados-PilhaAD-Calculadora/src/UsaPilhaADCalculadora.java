
public class UsaPilhaADCalculadora {

	public static void main(String[] args) {

		//Implemente o funcionamento de calculadoras capazes de resolver express�es.
		//Elas trabalham com express�es p�s-fixadas, ent�o para avaliarmos uma express�o
		//como (1-2)*(4+5) podemos digitar 1 2 � 4 5 + *. O funcionamento dessas
		//calculadoras � muito simples. Cada operando � empilhado numa pilha de valores.
		//Quando se encontra um operador, desempilha-se o n�mero apropriado de operandos
		//(dois para operadores bin�rios e um para operadores un�rios), realiza-se a opera��o
		//devida e empilha-se o resultado. Deste modo, na express�o acima, s�o empilhados
		//os valores 1 e 2. Quando aparece o operador -, 1 e 2 s�o desempilhados e o
		//resultado da opera��o, no caso -1 (= 1 - 2), � colocado no topo da pilha.
		//A seguir, 4 e 5 s�o empilhados. O operador seguinte, +, desempilha o 4 e o 5
		//e empilha o resultado da soma, 9. Nesta hora, est�o na pilha os dois resultados
		//parciais, -1 na base e 9 no topo. O operador *, ent�o, desempilha os dois e
		//coloca -9 (= -1 * 9) no topo da pilha. Implemente para os operadores + - * / .
		
		PilhaADCalculadora p = new PilhaADCalculadora();
		System.out.println("Empilhando...");
		p.empilha("Laranja");
		p.empilha("Ma�a");
		p.empilha("Lim�o");
		p.empilha("Mel�ncia");
		p.empilha("Ab�bora");
		while (p.estaVazia() == false) {
			System.out.println(p.desempilhar());
		}
		
	}
}