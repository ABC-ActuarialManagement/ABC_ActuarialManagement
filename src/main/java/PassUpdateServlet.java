

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PassUpdateServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset= UTF-8");
		
		// リスエストからPASSを取得する
		String pass = request.getParameter("pass");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("UserId");
		
		//DAOをインスタンス化する
		PassDao dao = new PassDao();
		
		//パスワードの変更を実行
		dao.updatePass(id, pass);
		
		//ログイン画面へ
		RequestDispatcher rd = request.getRequestDispatcher("/login");
		rd.forward(request, response);
	
	}
	
}
