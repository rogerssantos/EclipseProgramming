package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Correntista {
	
	private SimpleIntegerProperty id = new SimpleIntegerProperty(0);
	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty nascimento = new SimpleStringProperty("");
	private StringProperty status = new SimpleStringProperty("");
	
	@Override
	public String toString() {
		return getNome()+" - "+getNascimento();
	}

	public SimpleIntegerProperty idProperty() {
		return this.id;
	}
	
	public int getId() {
		return this.idProperty().get();
	}

	public void setId(int id) {
		this.idProperty().set(id);
	}
	
	public StringProperty nascimentoProperty() {
		return this.nascimento;
	}
	
	public String getNascimento() {
		return this.nascimentoProperty().get();
	}
	
	public void setNascimento(final String nascimento) {
		this.nascimentoProperty().set(nascimento);
	}
	
	public StringProperty nomeProperty() {
		return this.nome;
	}
	
	public String getNome() {
		return this.nomeProperty().get();
	}

	public void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}
	
	public StringProperty statusProperty() {
		return this.status;
	}
	
	public String getStatus() {
		return this.statusProperty().get();
	}

	public void setStatus(final String status) {
		this.statusProperty().set(status);
	}
	
}