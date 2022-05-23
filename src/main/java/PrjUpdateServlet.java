

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.PrjBean;

public class PrjUpdateServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset= UTF-8");
		
		HttpSession session = request.getSession();
		PrjDao dao = new PrjDao();
		RequestDispatcher rd = request.getRequestDispatcher("/prjIchiran");
		
		//プロジェクトIDの取得
		int i = Integer.parseInt(request.getParameter("i"));
		ArrayList<PrjBean> list = (ArrayList<PrjBean>)session.getAttribute("list");
		String id = list.get(i).getId();
		
		if(request.getParameter("submit").equals("変更")){
			//変更ボタンが押された時
			
			//変更内容の取得
			String projectCode = request.getParameter("projectCode");
			String supliers = request.getParameter("supliers");
			String description = request.getParameter("description");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			
			if(projectCode.isEmpty() || supliers.isEmpty() || description.isEmpty() || startDate.isEmpty() || endDate.isEmpty()) {
				//項目のどれかが空欄だった場合
				rd = request.getRequestDispatcher("/jsp/prjHenshu.jsp?err=1,i=" + i);
			} else {
				//変更を実行
				dao.update(id, projectCode, supliers, description, startDate, endDate);
			}
			
		} else if(request.getParameter("submit").equals("削除")){
			//削除ボタンが押された時
			
			//削除を実行
			dao.delete(id);
			
		}
		
		// プロジェクト一覧画面のServletへ
		rd.forward(request, response);
	}

}
