
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Iterator;

/**
 * Servlet implementation class Fibonazzi
 */
public class Fibonazzi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BigInteger[] arr = new BigInteger[100]; //큰 값을 넣는 배열. int보다 더 

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Fibonazzi() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Fibonazzi init...");
		arr[0] = new BigInteger("1");
		arr[1] = new BigInteger("1");
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 2].add(arr[i - 1]); // 지금=2이전+1이전.
						//그냥 더하는 메서드인듯..
		}

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Fibonazzi doGet...");
		int num=Integer.parseInt(request.getParameter("num"));
		if (num>100) {num=100;}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<html><body><h2>피보나치 수열</h2>");
		for (int i=0; i<num; i++) {
			out.println((i+1)+"번째 피보나치 수열:"+arr[i]+"<br>");
		} 
		out.println("</body></html>");
		out.close();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
