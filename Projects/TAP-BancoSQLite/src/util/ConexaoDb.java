package util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoDb {
	
	public static Connection conectaBd(){
		Connection conn = null;
		try{
			File f = new File("bd/sistema_bancario.sqlite");
			if(f.exists()) {
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:bd/sistema_bancario.sqlite");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}

}
