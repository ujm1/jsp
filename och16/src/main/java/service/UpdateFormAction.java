package service;

import java.io.IOException;

import dao.Board;
import dao.BoardDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UpdateFormAction start...");

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		try {
			BoardDao bd = BoardDao.getInstance();
			Board board = bd.select(num);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("board", board);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return "updateForm.jsp";
	}

}
