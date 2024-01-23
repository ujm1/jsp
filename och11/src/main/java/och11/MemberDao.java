package och11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//db crud 관련된 dml 처리 logic을 하나에 클래스에 모아놓기
//oraDbConnect.jsp에서 한 dbcp와의 연결 작업을 자바에서 한 것
public class MemberDao {
	;
	Connection conn;
	PreparedStatement pstmt;

	private Connection getUserConn() throws SQLException {

		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");

			conn = ds.getConnection();

		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return conn;
	}

	public MemberDao() {
		// TODO Auto-generated constructor stub
	}

	// insert 메서드 생성, getuserconn 사용, parameter:memberdto, return int,
	// PreparedStatement
	public int insert(MemberDto member) {
		int result = 0;
		try {
			conn = getUserConn(); // 이 conn=으로 할당하는게 없어서 틀린듯

			if (conn != null) {
				String sql = "insert into member1 values (?,?,?, sysdate)"; // sysdate에서 헤맴
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getName());
				pstmt.setString(3, member.getPassword());
				result = pstmt.executeUpdate();
				return result;
			} else {
				return result;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {				  try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return result;
	}

}