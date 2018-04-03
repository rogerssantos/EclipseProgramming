
class Calc {
	
	//Attributes
	public String digito;
	public Calc proximo;
	
	//Constructor
	public Calc(String v){
		digito = v;
		proximo = null;
	}
}

public class PilhaADCalculadora {
	
	private Calc topo = null;
	
	public boolean estaVazia() {
		return topo == null;
	}
	
	public void empilha(String digito) {
		if (digito == "+" || digito == "-" || digito == "*" || digito == "/") {
			double digito1 = Double.parseDouble(topo.digito);
			//System.out.println(digito1);
			desempilhar();
			double digito2 = Double.parseDouble(topo.digito);
			desempilhar();
			//System.out.println(digito2);
			char c = digito.charAt(0);
			double resposta = 0;
			switch (c) {
	            case '+': resposta = Calculo.soma(digito2, digito1);
	                      break;
	            case '-': resposta = Calculo.diminui(digito2, digito1);
	                      break;
	            case '*': resposta = Calculo.multiplica(digito2, digito1);
	                      break;
	            case '/': resposta = Calculo.divide(digito2, digito1);
	                      break;
	        }
			String respostaString = String.valueOf(resposta);
			Calc novo = new Calc(respostaString);
			if(topo == null)
				topo = novo;
			novo.proximo = topo;
			topo = novo;
			System.out.println("Cálculo: " + digito2 + " " + c + " " + digito1);
			System.out.println("A reposta é: " + resposta);
		}
		else {
			Calc novo = new Calc(digito);
			if(topo == null)
				topo = novo;
			novo.proximo = topo;
			topo = novo;
		}
	}
	
	public void desempilhar() {
		topo = topo.proximo;
	}
	
}