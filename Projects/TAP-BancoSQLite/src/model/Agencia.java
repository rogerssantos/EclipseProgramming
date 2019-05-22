package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Agencia {
	
	private  SimpleIntegerProperty id = new SimpleIntegerProperty(0);
	private StringProperty numero = new SimpleStringProperty("");
	private StringProperty cidade = new SimpleStringProperty("");
	private StringProperty status = new SimpleStringProperty("");
	
	@Override
	public String toString() {
		return getNumero()+" - "+getCidade();
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
	
	public StringProperty numeroProperty() {
		return this.numero;
	}
	
	public String getNumero() {
		return this.numeroProperty().get();
	}

	public void setNumero(final String numero) {
		this.numeroProperty().set(numero);
	}
	
	public StringProperty cidadeProperty() {
		return this.cidade;
	}
	
	public String getCidade() {
		return this.cidadeProperty().get();
	}

	public void setCidade(final String cidade) {
		this.cidadeProperty().set(cidade);
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