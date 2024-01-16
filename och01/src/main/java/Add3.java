

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Add3
 */
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Add3 Get Start...");
		int num=Integer.parseInt(request.getParameter("num")); 
		//num파라미터를 가져옴. 이렇게 가져오는건 문자열 꼴이므로 int로 변환
		System.out.println(num);
		String loc=request.getParameter("loc");
		
		int sum=0;
		for (int i=1; i<=num; i++) {
			sum+=i;
		}
		System.out.println("sum="+sum);
		
		request.setCharacterEncoding("utf-8"); //브라우저->서버
		response.setContentType("text/html;charset=utf-8"); //서버->브라우저
		//한글 깨지지 않게
		
		PrintWriter out=response.getWriter(); //서버(이클립스)에 있는걸 브라우저로 가져옴
		//사용자 브라우저에 출력. 해당 파라미터(?)로 인해 이동되는 페이지에 출력되는 html 웹화면에 뿌려지는 것
		out.println("<html><body>");
		out.printf("<h1>1부터 %d까지의 합계 %s</h1>", num, loc);
		//out.printf("<h4>LOC--> %s</h4>", loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
				
		
	}

}
