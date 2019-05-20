package dao;

import java.sql.PreparedStatement;

import model.Agencia;
import util.Constants;

public class AgenciaDAO {
	
	public void inserir(Agencia a) {
		String sql = "insert into agencia (numero, cidade) values (?, ?)";
		try {
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ps.setString(1, a.getNumero());
			ps.setString(2, a.getCidade());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
