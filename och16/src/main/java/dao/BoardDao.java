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

		String sql = "select * from (select rownum rn, a.*" + "from (select * from board order by ref desc, re_step) a)"
				+ "where rn between ? and ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
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
				// passwd, content 는..?
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}

	public void readCount(int num) {
		conn = null;
		pstmt = null;
		String sql = "update board set readcount=readcount+1 where num=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	public Board select(int num) {
		// prepare로 해도 됨 -> 이후 연습용으로 수정
		conn = null;
		stmt = null;
		rs = null;
		String sql = "select * from board where num=" + num;
		Board board = new Board();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				board.setNum(rs.getInt("num"));
				board.setWriter(rs.getString("writer"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setEmail(rs.getString("email"));
				board.setReadcount(rs.getInt("readcount"));
				board.setIp(rs.getString("ip"));
				board.setReg_date(rs.getDate("reg_date"));
				board.setRef(rs.getInt("ref"));
				board.setRe_level(rs.getInt("re_level"));
				board.setRe_step(rs.getInt("re_step"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs !=null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		}
		return board;

	}

	/* try-catch 안에 또 try-catch를 두지 않기 때문 */
	public int update(Board board) throws SQLException {
		// 수정할 객체를 가져온 상태.
		int result = 0;
		conn = null;
		pstmt = null;
		String sql = "update board set subject=?, writer=?, email=?," 
		+ "passwd=?, content=?, ip=? where num=?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getSubject());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getEmail());
			pstmt.setString(4, board.getPasswd());
			pstmt.setString(5, board.getContent());
			pstmt.setString(6, board.getIp());
			pstmt.setInt(7, board.getNum());
			
			result = pstmt.executeUpdate();
			//업데이트하며, 업데이트한 row의 개수 가져옴
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
			
		}return result;
		//db 바꾸고 결과표현숫자만 보냄
	}
	
	public int insert(Board board) throws SQLException {
			int num=board.getNum();
			conn=null;
			pstmt=null;
			int result=0;
			rs=null;
			String sql1="select nvl(max(num),0) from board";
			//NVL : 못가져왔으면 0으로 처리?
			String sql="insert into board values(?,?,?,?,?,?,?,?,?,?,?,sysdate)";
			String sql2="update board set re_step=re_step+1 where ref=? and re_step>?";
			try {
				conn=getConnection();
				pstmt=conn.prepareStatement(sql1);
				rs=pstmt.executeQuery();
				rs.next();
				//key인 num 1씩 증가, mysql auto_increment 또는 oracle sequence
				//max대신 sequence를 사용 : values(시퀀스명(board_seq).nextval,?,?...)
				int number=rs.getInt(1)+1;
				rs.close();
				pstmt.close();
			
				if(num!=0) { //댓글
					System.out.println("boardDao insert 댓글 sql2:"+sql2);
					System.out.println("boardDao insert 댓글 board.getRef():"+board.getRef());
					System.out.println("boardDao insert 댓글 board.getRe_step():"+board.getRe_step());
					pstmt=conn.prepareStatement(sql2);
					pstmt.setInt(1, board.getRef());
					pstmt.setInt(2, board.getRe_step());
					pstmt.executeUpdate();
					pstmt.close();
					
					//댓글 관련 정보
					board.setRe_step(board.getRe_step()+1);
					board.setRe_level(board.getRe_level()+1);
				
				
				
				} //댓글-->sql2
				if(num==0) {
					board.setRef(number);	//신규글일때 num과 Ref 맞춰줌
					pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, number);
					pstmt.setString(2, board.getWriter());
					pstmt.setString(3, board.getSubject());
					pstmt.setString(4, board.getContent());
					pstmt.setString(5, board.getEmail());
					pstmt.setInt(6,board.getReadcount());
					pstmt.setString(7, board.getPasswd());
					pstmt.setInt(8, board.getRef());
					pstmt.setInt(9,board.getRe_step());
					pstmt.setInt(10, board.getRe_level());
					pstmt.setString(11,board.getIp());
					result=pstmt.executeUpdate();
					
				}
			} catch (Exception e) {
			
				System.out.println(e.getMessage());}
		finally {
			if(rs!=null) rs.close();
			if(rs!=null) pstmt.close();
			if(rs!=null) conn.close();
		}
			return result;
	}
	
	public int delete(int num, String passwd) throws SQLException {
		conn = null;	
		pstmt= null; 
		int result = 0;		    
		rs = null;
		String sql1 = "select passwd from board where num=?";
		String sql="delete from board where num=?";
		try {
			String dbPasswd = "";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbPasswd = rs.getString(1); 
				if (dbPasswd.equals(passwd)) {
					rs.close();  
					pstmt.close();
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, num);
					result = pstmt.executeUpdate();
				} else result = 0;
			} else result = -1;
		} catch(Exception e) {	
			System.out.println(e.getMessage()); 
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn !=null) conn.close();
		}
		return result;
	}
}
