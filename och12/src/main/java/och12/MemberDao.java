package och12;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	private static MemberDao instance;
	//싱글턴. 외부에서 접근-인스턴스 생성 불가
	
	private MemberDao() {
	}
	
	public static MemberDao getInstance() {
		//오직 getInstance를 이용해서 공통의 스태틱 호출
		//새로운 인스턴스 생성은 x
		
		if(instance==null) {instance=new MemberDao();}
		//없으면 생성
		
		return instance;
		//있으면 공통의 스태틱 계속 이용

	}
	
	private Connection getConnection() {
						//이부분은 och11의 부분과 동일. 즉 싱글턴에 따른 getInstance부분만 다름
		Connection conn=null;
		
		try {
			Context ctx=new InitialContext();
			DataSource ds=(DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn=ds.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	int insert(Member2 member) //앞서 한 insert의 변형 
	{int result=0;
	
	return result;} 

}
