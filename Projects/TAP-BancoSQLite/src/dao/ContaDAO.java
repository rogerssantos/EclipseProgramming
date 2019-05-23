package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Conta;
import util.Constants;

public class ContaDAO {
	
	public void inserir(Conta c) {
		String sql = "insert into conta (agencia, correntista, saldo) values (?, ?, ?)";
		try {
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ps.setString(1, c.getAgencia());
			ps.setString(2, c.getCorrentista());
			ps.setDouble(3, c.getSaldo());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Conta> listaTudo(){
		ArrayList<Conta> contas = new ArrayList<Conta>();
		String sql = "select id, agencia, correntista, saldo from conta where status = 'A'";
		try{
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Conta c = new Conta();
				c.setId(rs.getInt("id"));
				c.setAgencia(rs.getString("agencia"));
				c.setCorrentista(rs.getString("correntista"));
				c.setSaldo(rs.getDouble("saldo"));
				contas.add(c);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return contas;
	}
	
	public void atualizar(Conta c) {
		String sql = "update conta set agencia = ?, correntista = ?, saldo = ?, status = ? where id = ?";
		try {
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ps.setString(1, c.getAgencia());
			ps.setString(2, c.getCorrentista());
			ps.setDouble(3, c.getSaldo());
			ps.setString(4, c.getStatus());
			ps.setInt(5, c.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
