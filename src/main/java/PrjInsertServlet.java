

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrjInsertServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset= UTF-8");
		
		//入力された値を取得
		String projectCode = request.getParameter("projectCode");
		String supliers = request.getParameter("supliers");
		String description = request.getParameter("description");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		PrjDao dao = new PrjDao();
		
		//遷移先
		RequestDispatcher rd = request.getRequestDispatcher("/prjIchiran");
		
		if(projectCode.isEmpty() || supliers.isEmpty() || description.isEmpty() || startDate.isEmpty() || endDate.isEmpty()) {
			//項目のどれかが空欄だった場合
			rd = request.getRequestDispatcher("/jsp/prjSinki.jsp?err=1");
		} else {
			//登録
			dao.insert(projectCode, supliers, description, startDate, endDate);
		}
		
		rd.forward(request, response);
	}

}
