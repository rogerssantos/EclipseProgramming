package programa;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.ItemPedido;

public class AbreItemPedido {
	
	@FXML
	private ImageView img;
	@FXML
	private TextField txtProduto;
	@FXML
	private TextField txtValor;
	@FXML
	private TextField txtQuantidade;
	@FXML
	private TextField txtValorTotal;
	
	protected void setItemPedido(ItemPedido itemPedido) {
		
		txtProduto.setText(itemPedido.getProduto());
		txtValor.setText(String.valueOf(itemPedido.getValor()));
		txtQuantidade.setText(String.valueOf(itemPedido.getQuantidade()));
		txtValorTotal.setText(String.valueOf(itemPedido.getValorTotalItemPedido()));
		
	}

}
