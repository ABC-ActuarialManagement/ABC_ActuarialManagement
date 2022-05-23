

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TopMenuServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset= UTF-8");
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/login.jsp?err=000");
		
		if(request.getParameter("no").equals("1")) {
			rd = request.getRequestDispatcher("/jsp/topMenu.jsp");
			rd.forward(request, response);
		}
		
		//ログイン画面からユーザIDとパスワードを取得する
		String number = request.getParameter("number");
		String pass = request.getParameter("pass");
		
		//Daoのインスタンス化
		LoginDao dao = new LoginDao();
		
		//セッションの取得
		HttpSession session = request.getSession();
		
		if(dao.getName(number, pass) != null) {
			//セッション(UserName)に名前を格納する
			session.setAttribute("UserName", dao.getName(number, pass));
			//セッション(UserNumber)に社員番号を格納する
			session.setAttribute("UserNumber", number);
			//セッション(UserId)にidを格納する
			session.setAttribute("UserId", dao.getId(number, pass));
			
			//トップメニュー画面へ
			rd = request.getRequestDispatcher("/jsp/topMenu.jsp");
		} else {
			//エラー1を持ってログイン画面へ
			rd = request.getRequestDispatcher("/jsp/login.jsp?err=1");
		}
		rd.forward(request, response);
	}
	
}
