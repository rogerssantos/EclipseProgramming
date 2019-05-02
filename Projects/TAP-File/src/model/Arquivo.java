package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Arquivo {
	
	StringProperty nome = new SimpleStringProperty("");
	StringProperty tamanho = new SimpleStringProperty("");
	StringProperty dtModificacao = new SimpleStringProperty("");

	public StringProperty nomeProperty() {
		return this.nome;
	}
	
	public String getNome() {
		return this.nomeProperty().get();
	}
	
	public void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}
	
	public StringProperty tamanhoProperty() {
		return this.tamanho;
	}
	
	public String getTamanho() {
		return this.tamanhoProperty().get();
	}
	
	public void setTamanho(final String tamanho) {
		this.tamanhoProperty().set(tamanho);
	}
	
	public StringProperty dtModificacaoProperty() {
		return this.dtModificacao;
	}
	
	public String getDtModificacao() {
		return this.dtModificacaoProperty().get();
	}
	
	public void setDtModificacao(final String dtModificacao) {
		this.dtModificacaoProperty().set(dtModificacao);
	}
	
	
}
