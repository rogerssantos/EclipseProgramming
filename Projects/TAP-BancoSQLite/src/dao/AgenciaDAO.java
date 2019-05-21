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
	
	public static ArrayList<Agencia> listaTudo(){
		ArrayList<Agencia> agencias = new ArrayList<Agencia>();
		String sql = "select numero, cidade from agencia where status = 'A'";
		try{
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Agencia a = new Agencia();
				a.setNumero(rs.getString("numero"));
				a.setCidade(rs.getString("cidade"));
				agencias.add(a);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return agencias;
	}

}
