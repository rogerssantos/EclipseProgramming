
public class UsaPilhaDeInteiros{
	public static void main(String args[]) {
		PilhaDeInteiros p = new PilhaDeInteiros();
		System.out.println(p.estaVazia());
		p.empilhar(10);
		System.out.println(p.tamanho());
		System.out.println(p.mostraTopo());
		System.out.println(p.estaVazia());
		p.empilhar(15);
		p.empilhar(9);
		p.empilhar(46);
		p.empilhar(7);
		System.out.println(p.tamanho());
		System.out.println(p.mostraTopo());
		System.out.println(p.estaVazia());
		System.out.println(p.tamanho());
		System.out.println(p.desempilhar());
		System.out.println(p.tamanho());
		System.out.println(p.estaVazia());
			while (p.estaVazia() == false) {
				System.out.println(p.desempilhar());
			}
		System.out.println(p.tamanho());
		System.out.println(p.estaVazia());
	}
}