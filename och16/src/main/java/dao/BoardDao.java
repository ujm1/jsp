package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {
	private static BoardDao instance;
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
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
		conn = null;
		stmt = null;
		rs = null;
		int tot = 0;
		String sql = "select count(*) from board";
		try {
			conn = getConnection();

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())
				tot = rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return tot;
	}

	public List<Board> boardList(int startRow, int endRow) {
		List<Board> list = new ArrayList<Board>();
		conn = null;
		pstmt = null;
		rs = null;
	
		String sql = "select * from (select rownum rn, a.*"
				+ "from (select * from board order by ref desc, re_step) a)" + "where rn between ? and ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				Board board = new Board();
						board.setNum(rs.getInt("num"));
						board.setWriter(rs.getString("writer"));
						board.setSubject(rs.getString("subject"));
						board.setContent(rs.getString("content"));
						board.setEmail(rs.getString("email"));
						board.setReadcount(rs.getInt("readcount"));
						board.setPasswd(rs.getString("passwd"));
						board.setRef(rs.getInt("ref"));
						board.setRe_step(rs.getInt("re_step"));
						board.setRe_level(rs.getInt("re_level"));
						board.setIp(rs.getString("ip"));
						board.setReg_date(rs.getDate("reg_date"));
						list.add(board);
				//passwd, content 는..?
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(pstmt!=null) {pstmt.close();}
				if(conn!=null) {conn.close();}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	
	public int readCount(int num) {
		
		return num;
		
	}
	
	public Board select(int num) {
		Board board=new Board();
		return board;
		
	}

}
