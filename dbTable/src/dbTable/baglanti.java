package dbTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class baglanti {
	
	static Connection myConn;
	static Statement myStat;
	
	static ResultSet yap() {
		ResultSet myRs = null;
		try {
			myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme","root","1234");
			myStat = (Statement) myConn.createStatement();
			myRs = myStat.executeQuery("select * from personel");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myRs;
	}
	
	
	static ResultSet urun() {
		ResultSet myRs = null;
		try {
			myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme","root","1234");
			myStat = (Statement) myConn.createStatement();
			myRs = myStat.executeQuery("select * from urun");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myRs;
		
	}
	
	
	static ResultSet musteri() {
		ResultSet myRs = null;
		try {
			myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme","root","1234");
			myStat = (Statement) myConn.createStatement();
			myRs = myStat.executeQuery("select * from musteri");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myRs;
		
	}
	
	
	
	static void ekle(String sql_sorgu) {
		try {
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void update(String sql_sorgu) {
		try {
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void sil(String sql_sorgu) {
		try {
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static ResultSet sorgula(String sql_sorgu) {
		ResultSet myRs = null;
		try {
			myRs = myStat.executeQuery(sql_sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myRs;
	}
	
	
}
