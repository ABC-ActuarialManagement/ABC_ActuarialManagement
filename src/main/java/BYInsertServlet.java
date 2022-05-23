

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BYInsertServlet extends HttpServlet {
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
		
		if(by.equals("b")) {
			//部署
			
			//入力された値を取得
			String department = request.getParameter("department");
			String division = request.getParameter("division");
			
			if(department.isEmpty()) {
				rd = request.getRequestDispatcher("/byIchiran?by=b,err=1");
			} else {
				dao.insertB(department, division);
			}
			
		} else if(by.equals("y")) {
			//役職
			
			//入力された値を取得
			String position = request.getParameter("position");
			
			if(position.isEmpty()) {
				rd = request.getRequestDispatcher("/byIchiran?by=y,err=1");
			} else {
				dao.insertY(position);
			}
			
		}
		
		// 部署・役職一覧画面のServletへ
		rd.forward(request, response);
	}

}
