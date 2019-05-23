package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Correntista {
	
	private SimpleIntegerProperty id = new SimpleIntegerProperty(0);
	private StringProperty agencia = new SimpleStringProperty("");
	private StringProperty correntista = new SimpleStringProperty("");
	private DoubleProperty saldo = new SimpleDoubleProperty(0);
	private StringProperty status = new SimpleStringProperty("");
	
	@Override
	public String toString() {
		return getAgencia()+" - "+getCorrentista();
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
	
	public StringProperty agenciaProperty() {
		return this.agencia;
	}
	
	public String getAgencia() {
		return this.agenciaProperty().get();
	}
	
	public void setAgencia(final String agencia) {
		this.agenciaProperty().set(agencia);
	}
	
	public StringProperty correntistaProperty() {
		return this.correntista;
	}
	
	public String getCorrentista() {
		return this.correntistaProperty().get();
	}

	public void setCorrentista(final String correntista) {
		this.correntistaProperty().set(correntista);
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
	
	
	public DoubleProperty saldoProperty() {
		return this.saldo;
	}
	
	public double getSaldo() {
		return this.saldoProperty().get();
	}

	public void setSaldo(double saldo) {
		this.saldoProperty().set(saldo);
	}
}