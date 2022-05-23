

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.BYBean;

public class BYUpdateServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset= UTF-8");
		
		HttpSession session = request.getSession();
		String by = (String)session.getAttribute("by");
		
		BYDao dao = new BYDao();
		RequestDispatcher rd = request.getRequestDispatcher("/byIchiran?by=" + by);
		
		//IDの取得
		int i = Integer.parseInt(request.getParameter("i"));
		ArrayList<BYBean> list = (ArrayList<BYBean>)session.getAttribute("list");
		String id = list.get(i).getId();
		
		if(request.getParameter("submit").equals("変更")){
			//変更ボタンが押された時
			
			if(by.equals("b")) {
				//部署
				
				//変更内容の取得
				String department = request.getParameter("department");
				String division = request.getParameter("division");
				
				if(department.isEmpty() || division.isEmpty()) {
					//項目のどれかが空欄だった場合
					rd = request.getRequestDispatcher("/jsp/byHenshu.jsp?err=1,i=" + i);
				} else {
					//変更を実行
					dao.updateB(id, department, division);
				}
				
			} else if(by.equals("y")) {
				//役職
				
				//変更内容の取得
				String position = request.getParameter("position");
				
				if(position.isEmpty()) {
					//項目のどれかが空欄だった場合
					rd = request.getRequestDispatcher("/jsp/byHenshu.jsp?err=1,i=" + i);
				} else {
					//変更を実行
					dao.updateY(id, position);
				}
			}
			
		} else if(request.getParameter("submit").equals("削除")){
			//削除ボタンが押された時
			
			if(by.equals("b")) {
				//部署
				
				//削除を実行
				dao.deleteB(id);
			} else if(by.equals("y")) {
				//役職
				//削除を実行
				dao.deleteY(id);
			}
			
		}
		
		// 部署・役職一覧画面のServletへ
		rd.forward(request, response);
	}

}
