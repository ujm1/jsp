package service;

import java.io.IOException;

import dao.Board;
import dao.BoardDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WriteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	try {
		// 1. num , pageNum, writer ,  email , subject , passwd , content   Get
		request.setCharacterEncoding("utf-8");
		String pageNum=request.getParameter("pageNum");
		System.out.println(pageNum);
		Board board=new Board();
		
	board.setNum(Integer.parseInt(request.getParameter("num")));
	board.setWriter(request.getParameter("writer"));
	board.setEmail(request.getParameter("email"));
	board.setSubject(request.getParameter("subject"));
	board.setPasswd(request.getParameter("passwd"));
	board.setRef(Integer.parseInt(request.getParameter("ref")));
	board.setRe_step(Integer.parseInt(request.getParameter("re_step")));
	board.setRe_level(Integer.parseInt(request.getParameter("re_level")));
	board.setContent(request.getParameter("content"));
	board.setIp(request.getRemoteAddr());
	
		
		// 2. Board board 생성하고 DTO Value Setting
		BoardDao bd=BoardDao.getInstance();
				// 3. BoardDao bd Instance
		        int result = bd.insert(board);
		        // 4. request 객체에 result, num , pageNum
		        request.setAttribute("num", board.getNum());
		        request.setAttribute("result", result);
		        request.setAttribute("pageNum", pageNum);

		        return "writePro.jsp";

		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		

		
	}

}
