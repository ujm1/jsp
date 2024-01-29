package service;

import java.io.IOException;

import dao.Board;
import dao.BoardDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WriteFormAction implements CommandProcess {
			//답변작성
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("writeFormAction start...");
		
		try {
			//신규글
			int num=0; int ref=0; int re_level=0; int re_step=0; //여기서 설정한걸
			String pageNum=request.getParameter("pageNum");
			if(pageNum==null) {pageNum="1";
			
			//댓글
			if(request.getParameter("num")!=null) {
				num=Integer.parseInt(request.getParameter("num"));
				BoardDao bd=BoardDao.getInstance();
				Board board=bd.select(num);
				ref=board.getRef();
				re_level=board.getRe_level();
				re_step=board.getRe_step();
				
				
			}
			
			request.setAttribute("num", num); //여기 오른쪽에 넣음
			request.setAttribute("ref", ref);
			request.setAttribute("re_level", re_level);
			request.setAttribute("re_step", re_step);
			request.setAttribute("pageNum", pageNum);
			//이건 그냥 단순 초기화, 설정해 다음 페이지로 보내기 위함
			
			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "writeForm.jsp";
	}

}
