package och12;

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

public class MemberDao {
	private static MemberDao instance;
	// 싱글턴. 외부에서 접근-인스턴스 생성 불가
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;

	private MemberDao() {
	}

	public static MemberDao getInstance() {
		// 오직 getInstance를 이용해서 공통의 스태틱 호출
		// 새로운 인스턴스 생성은 x

		if (instance == null) {
			instance = new MemberDao();
		}
		// 없으면 생성

		return instance;
		// 있으면 공통의 스태틱 계속 이용

	}

	private Connection getConnection() {
		// 이부분은 och11의 부분과 동일. 즉 싱글턴에 따른 getInstance부분만 다름
		conn = null;

		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return conn;
	}

	// 로그인 시 체크, loginForm, loginPro
	public int check(String id, String passwd) {
		// 참고
		System.out.println(id + " " + passwd);

		int result = 0;
		conn = null;
		String sql = "select passwd from member2 where id=?";
		pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			// id OK
			if (rs.next()) {
				String dbPasswd = rs.getString(1);
				System.out.println(dbPasswd);

				System.out.println(passwd);

				if (dbPasswd.equals(passwd))
					// equals가 아닌 ==으로 하니 틀림.
					result = 1;

				// 비밀번호가 틀림
				else
					result = 0;

				// id가 틀림
			} else
				result = -1;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();

			}

		}
		return result;
	}

	// 회원가입, joinForm, joinPro
	public int insert(Member2 member) { // 밖에서 쓸 메서드만 public

		int result = 0;
		try {
			conn = getConnection();

			if (conn != null) {
				String sql = "insert into member2 values (?,?,?,?,?, sysdate)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getPasswd());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getAddress());
				pstmt.setString(5, member.getTel());
				result = pstmt.executeUpdate();
			} else {
				return result;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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

	// memberList.jsp에서 사용 : db에 회원 있는지 체크
	public List<Member2> list() {
		List<Member2> list = new ArrayList<Member2>();
		conn = null;
		pstmt = null;
		rs = null;
		String sql = "select * from member2";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					Member2 member = new Member2();
					member.setId(rs.getString(1));
					member.setPasswd(rs.getString(2));
					member.setName(rs.getString(3));
					member.setAddress(rs.getString(4));
					member.setTel(rs.getString(5));
					member.setReg_date(rs.getDate(6));
					list.add(member);
				} while (rs.next());

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}

	// updateForm.jsp, updatePro.jsp에서 회원정보수정하기 위함
	public Member2 select(String id) {
		Member2 member = new Member2();
		conn = null;
		String sql = "select * from member2 where id=?";
		pstmt = null;
		rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member.setId(rs.getString(1));
				member.setPasswd(rs.getString(2));
				member.setName(rs.getString(3));
				member.setAddress(rs.getString(4));
				member.setTel(rs.getString(5));
				member.setReg_date(rs.getDate(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
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

		return member;
	}

	// confirmId.jsp에서 아이디 동일 체크할 때 사용
	public int confirm(String id) {
		int result = 0;
		conn = null;
		pstmt = null;
		rs = null;
		try {
			conn = getConnection();
			String sql = "select id from member2 where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
			} else
				result = 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		}

		return result;
	}

	// deleteForm, deletePro
	public int delete(String id, String passwd) {
		int result = 0;
		conn = null;
		result = check(id, passwd); // 입력한 id로 passwd 맞는지 체크해
		// 맞으면 1 비번틀리면0 아이디틀리면 -1 반환

		// 삭제작업 수행
		String sql = "delete from member2 where id=?";
		pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
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
		return result; // 숫자반환(그에 따라 출력되는 페이지 차이 두기 위함)
	}

	public int update(Member2 member) { 

		int result = 0;
		conn=null;
		pstmt=null;
		try {
			conn = getConnection();
				String sql = "update member2 set passwd=?,name=?,address=?,tel=? where id=?";
				/*
				 * pstmt = conn.prepareStatement(sql); pstmt.setString(1, member.getId());
				 * pstmt.setString(2, member.getPasswd()); pstmt.setString(3, member.getName());
				 * pstmt.setString(4, member.getAddress()); pstmt.setString(5, member.getTel());
				 * pstmt.setString(6, member.getId());
				 */
				System.out.println("getId"+member.getId());
				System.out.println("getName"+member.getName());
				System.out.println("getAddress"+member.getAddress());
				System.out.println("getTel"+member.getTel());
				//체크용
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getPasswd());
				pstmt.setString(2, member.getName());
				pstmt.setString(3, member.getAddress());
				pstmt.setString(4, member.getTel());
				pstmt.setString(5, member.getId());
				//id와 날짜는 수정하지 않음. 아예 받아오지도 않고.
				result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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
