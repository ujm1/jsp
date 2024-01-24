package service;

import java.io.IOException;
import java.sql.SQLException;

import dao.BoardDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListAction implements CommandProcess {
	//fasade 패턴
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ListAction Service start...");
		
		BoardDao bd=BoardDao.getInstance();
		try {
			int totCnt=bd.getTotalCnt(); 
			request.setAttribute("totCnt", totCnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "listForm.jsp";
					//이게 뷰
	}

}
