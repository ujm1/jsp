package och12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
				//로그인 시 체크, loginForm, loginPro
	public int check(String id, String passwd) {
		// 참고
		System.out.println(id+" "+ passwd);
		
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
					//equals가 아닌 ==으로 하니 틀림.
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
				//회원가입, joinForm, joinPro
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
			//memberList.jsp에서 사용 : db에 회원 있는지 체크
	public int list() {
		int result = 0;
		stmt = conn.createStatement();
		String sql = "select empno, ename from emp";
		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next()) {
			do {
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				al.add(emp);
			} while (rs.next());
			request.setAttribute("al", al);
			rs.close();
			stmt.close();
			conn.close();
		} else {
			out.println("데이터가 없습니다");
			stmt.close();
			conn.close();
		}
		return result;
	}
					//updateForm.jsp에서 회원정보수정하기 위함
	public Member2 select(String id) {
	
		String sql = "select * from member2 where id=" + id;
		
		try {
			conn = getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		MemberDao md=MemberDao.getInstance();
		
		if (rs.next()) {
			md
			request.setAttribute("dno", dno);
			request.setAttribute("dname", rs.getString(2));
			//위와 달리 변수명 선언 안해주고 바로 쓸 떄
			request.setAttribute("phone", rs.getString(3));
			request.setAttribute("position", rs.getString(4));
			rs.close();
			stmt.close();
			conn.close();
			RequestDispatcher rd = request.getRequestDispatcher("myResult.jsp");
			rd.forward(request, response);
		}
		}
		stmt.close();
		conn.close();
		
		return Member2;
	}
				//confirmId.jsp에서 아이디 동일 체크할 때 사용
	public int confirm(String id) {
		int result = 0;
		conn = null;
		try {
			conn=getConnection();
			String sql="select id from ";
			pstmt=conn.prepareStatement(sql);
			if(conn!=null) {
			
			
			
		}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
				//deleteForm, deletePro
	public int delete(String id, String passwd) {
		int result=0;
		
		return result;
	}

}
