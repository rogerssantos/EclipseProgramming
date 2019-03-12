package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemPedido {
	
	private StringProperty produto = new SimpleStringProperty("");
	private DoubleProperty valor = new SimpleDoubleProperty(0);
	private DoubleProperty quantidade = new SimpleDoubleProperty(0);
	private DoubleProperty valorTotalItemPedido = new SimpleDoubleProperty(0);
	
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
	
	public DoubleProperty quantidadeProperty() {
		return this.quantidade;
	}
	
	public double getQuantidade() {
		return this.quantidadeProperty().get();
	}
	
	public void setQuantidade(final double quantidade) {
		this.quantidadeProperty().set(quantidade);
	}
	
	public DoubleProperty valorTotalItemPedidoProperty() {
		valorTotalItemPedido = new SimpleDoubleProperty(getValorTotalItemPedido());
		return valorTotalItemPedido;
	}
	
	public double getValorTotalItemPedido() {
		
		return this.valor.get() * this.quantidade.get();
	}
	
}
