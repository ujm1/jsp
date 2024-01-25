package service;

import java.io.IOException;
import java.sql.SQLException;

import dao.Board;
import dao.BoardDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ContentAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ContentAction Service start...");
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");

		try { 
			BoardDao bd = BoardDao.getInstance();
			bd.readCount(num);
			Board board = bd.select(num);
			request.setAttribute("num", num);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("board", board);
		} catch (Exception e) {
			e.printStackTrace();
		}
				//view
		return "content.jsp";
	}

}
