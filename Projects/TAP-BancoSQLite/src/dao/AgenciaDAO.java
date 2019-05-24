package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
	
	public ArrayList<Agencia> listaTudo(){
		ArrayList<Agencia> agencias = new ArrayList<Agencia>();
		String sql = "select numero, cidade, id, status from agencia where status = 'A'";
		try{
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Agencia a = new Agencia();
				a.setNumero(rs.getString("numero"));
				a.setCidade(rs.getString("cidade"));
				a.setId(rs.getInt("id"));
				a.setStatus(rs.getString("status"));
				agencias.add(a);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return agencias;
	}
	
	public ArrayList<Agencia> filtrar(String filtro){
		ArrayList<Agencia> agencias = new ArrayList<Agencia>();
		String sql = "select numero, cidade, id, status from agencia where status = 'A' and cidade like ?";
		try{
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ps.setString(1,  "%"+filtro+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Agencia a = new Agencia();
				a.setNumero(rs.getString("numero"));
				a.setCidade(rs.getString("cidade"));
				a.setId(rs.getInt("id"));
				a.setStatus(rs.getString("status"));
				agencias.add(a);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return agencias;
	}
	
	public void atualizar(Agencia a) {
		String sql = "update agencia set numero = ?, cidade = ?, status = ? where id = ?";
		try {
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ps.setString(1, a.getNumero());
			ps.setString(2, a.getCidade());
			ps.setString(3, a.getStatus());
			ps.setInt(4, a.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
