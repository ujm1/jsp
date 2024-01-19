package och06;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

/**
 * Servlet implementation class Greet2
 */
public class Greet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter log;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Greet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init start...");
	try {
		log=new PrintWriter(new FileWriter("c:/log/log.txt",true));
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("에러");
	}	
	} //초기화, 초기 설정 같은 느낌으로 쓰는게 init. 즉 가장 먼저 실행
		//서블릿이 실행될 때, 단 한번만 실행,

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() { //유언장. 프로세스 끝낼때. 즉 서버 닫을떄
		
		System.out.println("destroy start...");
		log.flush(); 
		if(log!=null) {log.close();} 
		//여기서 destroy될때 flush와 close를 하게 설정했으므로, 서버를 닫을 때 비로소
		//print로 txt에 내용이 출력되어 저장된다.
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet start...");
		String name=request.getParameter("name");
		String msg=name+"님 반가워\r\n"; //html에서 사용자가 입력한 name을 받아옴
		
		
		GregorianCalendar gc=new GregorianCalendar(); 
		//국제 표준시. 자동으로 시스템상 시간인 서울 시간 받아옴
		String date=String.format("%TF %TT\r\n",gc,gc);
		//tf는 연 원 일, tt는 시 분 초. 
		log.print(date+msg); //log.txt에 시간//~님 반가워를 씀
		//flush가 되지 않았으므로 이것만으론 출력되지 않고, 그래서 destory에 
		//server를 닫을때 flush가 실행되어 파일이 수정된다.
		
		
		//화면 출력 부분
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<html><body><h2>인사</h2>"+msg);
		out.println("</body></html>");
		out.close();
	} //init에 이어 두번째로 실행. 입력을 할때마다(doGet을 받아와야 할 때마다) 중복 실행

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
