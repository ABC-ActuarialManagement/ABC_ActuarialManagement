

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.KotuBean;

public class KotuShosaiServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset= UTF-8");
		
		KotuDao dao = new KotuDao();
		HttpSession session = request.getSession();
		
		int i = Integer.parseInt(request.getParameter("i"));
		ArrayList<KotuBean> list = (ArrayList<KotuBean>)session.getAttribute("list");
		
		String id = list.get(i).getCostId();
		
		session.setAttribute("detail", dao.getDetail(id));
		
		// kotuShosai.jspへ画面遷移する
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/kotuShosai.jsp?i=" + i);
		rd.forward(request, response);
	}
}
