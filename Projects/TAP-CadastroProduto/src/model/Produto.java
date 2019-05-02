package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produto {
	
	private StringProperty produto = new SimpleStringProperty("");
	private DoubleProperty valor = new SimpleDoubleProperty(0);
	private DoubleProperty estoque = new SimpleDoubleProperty(0);
	private SimpleStringProperty unidade = new SimpleStringProperty("");
	
	public StringProperty produtoProperty() {
		return this.produto;
	}
	
	public String getProduto() {
		return this.produtoProperty().get();
	}
	
	public void setProduto(final String produto) {
		this.produtoProperty().set(produto);
	}
		
	public DoubleProperty valorProperty() {
		return this.valor;
	}
	
	public double getValor() {
		return this.valorProperty().get();
	}
	
	public void setValor(final double valor) {
		this.valorProperty().set(valor);
	}
	
	public DoubleProperty estoqueProperty() {
		return this.estoque;
	}
	
	public double getEstoque() {
		return this.estoqueProperty().get();
	}
	
	public void setEstoque(final double estoque) {
		this.estoqueProperty().set(estoque);
	}
	
	
	public StringProperty unidadeProperty() {
		return this.unidade;
	}
	
	public String getUnidade() {
		return this.unidadeProperty().get();
	}
	
	public void setUnidade(final String unidade) {
		this.unidadeProperty().set(unidade);
	}
	
}
