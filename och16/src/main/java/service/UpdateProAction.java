package service;

import java.io.IOException;

import dao.Board;
import dao.BoardDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateProAction implements CommandProcess {

	@Override		//updateForm->o->updatePro.jsp
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UpdateProAcion 스타트");
		// 1. num , pageNum, writer ,  email , subject , passwd , content   Get
		request.setCharacterEncoding("utf-8");
		int pageNum=Integer.parseInt(request.getParameter("pageNum")); // 체크
		
		int num=Integer.parseInt(request.getParameter("num"));

		String writer=request.getParameter("writer");
		String email=request.getParameter("email");
		String subject=request.getParameter("subject");
		String passwd=request.getParameter("passwd");
		String content=request.getParameter("content");
		
				// 2. Board board 생성하고 DTO Value Setting
		try {
			Board board=new Board();
			board.setNum(num);
			board.setWriter(writer);
			board.setEmail(email);
			board.setSubject(subject);
			board.setPasswd(passwd);
			board.setContent(content);
			board.setIp(request.getRemoteAddr()); //ip는 위에서 가져오지 않음
			//JAVA, jsp 에서 클라이언트의 ip주소를 얻기 위해 사용하는 코드는 request.getRemoteAddr() 이다.
			
			
			// 3. BoardDao bd Instance
			BoardDao bd=BoardDao.getInstance();
			int result = bd.update(board);
			//그 보드 객체를 업데이트.
			
			// 4. request 객체에 result, num , pageNum 
			request.setAttribute("result", result);//result:여기서 정함:board와 무관
			request.setAttribute("num", board.getNum());
			request.setAttribute("pageNum", pageNum); //pageNum:여기서 정함:board와 무관
			//이동할 곳에서 $로 el표기 사용 가능
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "updatePro.jsp";
		
		

				
	}

}
