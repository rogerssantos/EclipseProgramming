package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Correntista;
import util.Constants;

public class CorrentistaDAO {
	
	public void inserir(Correntista c) {
		String sql = "insert into correntista (nome, nascimento) values (?, ?)";
		try {
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getNascimento());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Correntista> listaTudo(){
		ArrayList<Correntista> correntistas = new ArrayList<Correntista>();
		String sql = "select id, nome, nascimento from correntista where status = 'A'";
		try{
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Correntista c = new Correntista();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setNascimento(rs.getString("nascimento"));
				correntistas.add(c);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return correntistas;
	}
	
	public void atualizar(Correntista c) {
		String sql = "update correntista set nome = ?, nascimento = ?, status = ? where id = ?";
		try {
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getNascimento());
			ps.setString(3, c.getStatus());
			ps.setInt(4, c.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
