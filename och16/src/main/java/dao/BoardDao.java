package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {
	private static BoardDao instance;
	Connection conn; 
	Statement stmt;
	ResultSet rs;
	
	private BoardDao() {
	}

	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();

		}
		return instance;

	}

	private Connection getConnection() {
		conn = null;

		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;

	}
	
	public int getTotalCnt() throws SQLException {
		conn=null;
		stmt=null;
		rs=null;
		int tot=0;
		String sql="select count(*) from board";
		try {
			conn=getConnection();

			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next()) tot=rs.getInt(1);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}
		return tot;
	}

}
