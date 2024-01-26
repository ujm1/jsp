package control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CommandProcess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> commandMap = new HashMap<String, Object>();

	public Controller() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		String props = config.getInitParameter("config");
		System.out.println("1.init String props->" + props);
			//props : /WEB-INF/command.properties
		
		Properties pr = new Properties();
		FileInputStream f = null;

		try {
			String configFilePath = config.getServletContext().getRealPath(props);
			System.out.println("2.init String configFilePath->" + configFilePath);
			/* configFilePath : C:\jsp\source\.metadata\.plugins
			 * \org.eclipse.wst.server.core\tmp0\wtpwebapps
			 * \och16\WEB-INF\command.properties  */
			
			f = new FileInputStream(configFilePath);
			pr.load(f); // 메모리에 적재
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (f != null)
				try {
					f.close();
				} catch (IOException e2) {
					// TODO: handle exception
				}
		} // list.do //content.do
		Iterator keyIter = pr.keySet().iterator();
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String className = pr.getProperty(command);
			System.out.println("3.init command->" + command);
			System.out.println("4.init className->" + className);
			/* 여기서 list.do - service.ListAction,
			 * updateForm.do-service.UpdateFormAction,
			 * content.do-service.ContentAction, 등 가져옴 */
			
			try {
				// ListAction la = new ListAction();
				// 소멸 Class
				// Class commandClass = Class.forName(className);
				// Object commandInstance = commandClass.newInstance();
				// new Class --> 제네릭의 요점은 클래스 유형을 모른다
//      list.do    service.ListAction
				// content.do service.ContentAction
				Class<?> commandClass = Class.forName(className);//해당 문자열을 클래스로 만든다.
				CommandProcess commandInstance = (CommandProcess) commandClass.getDeclaredConstructor().newInstance();
				//적당히 넘어감
				commandMap.put(command, commandInstance);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		requestServletPro(request,response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		requestServletPro(request,response);

	}
	
	protected void requestServletPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view=null;
		CommandProcess com=null;
		String command=request.getRequestURI();
		System.out.println("1.requestServletPro command->"+command);
		//command->/och16/list.do
		command=command.substring(request.getContextPath().length());
		System.out.println("2.requestServeletPro command substring->"+ command);
		//command substring->/list.do. 즉 앞의 /och16/을 없앰
		try {
			com=(CommandProcess) commandMap.get(command);
			System.out.println("3.requestServletPro command->"+command);
			//command->/list.do
			System.out.println("4.requestServletPro com->"+com);
			//com->service.ListAction@6568192e
			view=com.requestPro(request, response); 
			//Content Action에 따라 ListAction Service start...(실제 동작)
			System.out.println("5.requestServletPro view->"+view);
			//view->listForm.jsp
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	
	}
}
