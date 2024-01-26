package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.Board;
import dao.BoardDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListAction implements CommandProcess {
	//fasade 패턴
	@Override			//index->o->listForm.jsp
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ListAction Service start...");
		
		BoardDao bd=BoardDao.getInstance();
		try {
			int totCnt=bd.getTotalCnt(); 
			request.setAttribute("totCnt", totCnt);
			//여기까지 하면 카운트 세는거 됨, 추가로.. 
			//페이징 작업
			String pageNum=request.getParameter("pageNum");
			if(pageNum==null||pageNum.equals("")) {pageNum="1";}
			int currentPage=Integer.parseInt(pageNum);
			int pageSize=10; //한 화면에 보여주는 게시글들의 수 
			
			int blockSize=10; 
			int startRow=(currentPage-1)*pageSize+1; //처음엔 1->다음 11
			int endRow=startRow+pageSize-1; //처음엔 10->다음 20
			int startNum=totCnt-startRow+1; //38-1+1=38. 그래서 게시판의 첫번 째 글의 번호가 38, 그 다음은 37, 36...이렇게 표시됨
			
			List<Board> list=bd.boardList(startRow,endRow); 
			
			int pageCnt=(int)Math.ceil((double)totCnt/pageSize); // 38/10 -> 4.
			int startPage=(int)(currentPage-1)/blockSize*blockSize+1; //1
			int endPage=startPage+blockSize-1; //마지막 페이지. 1+10-1=10
			
			
			if(endPage>pageCnt) endPage=pageCnt; //텅빈페이지 방지. 10>4인데 그럼 5-10페이지가 텅 비어있으므로 이를 출력하지 않기 위해서.
			
			request.setAttribute("list", list);
			request.setAttribute("totCnt", totCnt);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("startNum", startNum);
			request.setAttribute("blockSize", blockSize);
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "listForm.jsp";
					//이게 뷰
	}

}
