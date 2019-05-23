package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Correntista;
import util.Constants;

public class CorrentistaDAO {
	
	public void inserir(Correntista a) {
		String sql = "insert into correntista (agencia, correntista, saldo) values (?, ?, ?)";
		try {
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ps.setString(1, a.getAgencia());
			ps.setString(2, a.getCorrentista());
			ps.setDouble(3, a.getSaldo());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Correntista> listaTudo(){
		ArrayList<Correntista> correntistas = new ArrayList<Correntista>();
		String sql = "select agencia, correntista, saldo from correntista where status = 'A'";
		try{
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Correntista c = new Correntista();
				c.setAgencia(rs.getString("agencia"));
				c.setCorrentista(rs.getString("correntista"));
				c.setSaldo(rs.getDouble("saldo"));
				correntistas.add(c);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return correntistas;
	}
	
	public void atualizar(Correntista c) {
		String sql = "update correntista set agencia = ?, correntista = ?, saldo = ?, status = ? where id = ?";
		try {
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ps.setString(1, c.getAgencia());
			ps.setString(2, c.getCorrentista());
			ps.setDouble(3, c.getSaldo());
			ps.setString(4, c.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
