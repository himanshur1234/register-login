package in.ashok.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;

import in.ashok.dto.registerDTO;
import in.ashok.util.ConnectionClass;



public class DaoClass {
	
	public static String sql_insert="INSERT INTO registrationdata VALUES(?,?,?,?,?)";
	public static String sql_search="SELECT * FROM registrationdata WHERE Email=? AND pass=?";
	
	
	public static boolean saveRegistration(registerDTO dto) throws IOException, SQLException {
		Connection con= ConnectionClass.getConnection();
		
		PreparedStatement psmt = con.prepareStatement(sql_insert);
		psmt.setString(1, dto.getFname());
		psmt.setString(2, dto.getLname());
		psmt.setString(3, dto.getEmail());
		psmt.setString(4, dto.getPass());
		psmt.setString(5, dto.getGender());
		
		int count = psmt.executeUpdate();
		psmt.close();
		con.close();
		return count>0;
		
	}
	public static boolean checkdata(registerDTO dto) throws IOException, SQLException {
		Connection con = ConnectionClass.getConnection();
		
		PreparedStatement psmt = con.prepareStatement(sql_search);
		
		psmt.setString(1, dto.getEmail());
		psmt.setString(2, dto.getPass());
		
		ResultSet row = psmt.executeQuery();
		
		return row.next();
	}
	
}
