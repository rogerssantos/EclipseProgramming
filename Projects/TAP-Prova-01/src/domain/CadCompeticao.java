package domain;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.DatePicker;

public class CadCompeticao {
	
	private StringProperty nome = new SimpleStringProperty("");
	
	public StringProperty nomeProperty() {
		return this.nome;
	}
	
	public String getNome() {
		return this.nomeProperty().get();
	}
	
	public void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}
	
	private StringProperty distancia = new SimpleStringProperty("");
	
	public StringProperty distanciaProperty() {
		return this.distancia;
	}
	
	public String getDistancia() {
		return this.distanciaProperty().get();
	}
	
	public void setDistancia(final String distancia) {
		this.distanciaProperty().set(distancia);
	}

	
	private StringProperty data = new SimpleStringProperty("");
	
	public StringProperty dataProperty() {
		return this.data;
	}
	
	public String getData() {
		return this.dataProperty().get();
	}
	
	public void setData(final String txtData) {
		this.dataProperty().set(txtData);
	}
	
	private DoubleProperty colocacao = new SimpleDoubleProperty(0);
	
	public DoubleProperty colocacaoProperty() {
		return this.colocacao;
	}
	
	public double getColocacao() {
		return this.colocacaoProperty().get();
	}
	
	public void setColocacao(final double colocacao) {
		this.colocacaoProperty().set(colocacao);
	}
	
}
