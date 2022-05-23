

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KotuRirekiServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset= UTF-8");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("UserId");
		
		KotuDao dao = new KotuDao();
		
		session.setAttribute("list", dao.getAll());
		
		// kotuRireki.jspへ画面遷移する
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/kotuRireki.jsp");
		rd.forward(request, response);
	}
}
