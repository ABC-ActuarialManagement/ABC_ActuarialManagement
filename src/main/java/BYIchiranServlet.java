

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BYIchiranServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset= UTF-8");
		
		HttpSession session = request.getSession();
		
		String by = request.getParameter("by");
		session.setAttribute("by", by);
		
		BYDao dao = new BYDao();
		
		if(by.equals("b")) {
			//部署メニュー
			
			session.setAttribute("list", dao.getAllB());
		} else if(by.equals("y")) {
			//役職メニュー
			
			session.setAttribute("list", dao.getAllY());
		}
			
		// 部署・役職一覧画面へ
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/byIchiran.jsp");
		rd.forward(request, response);
	}

}
