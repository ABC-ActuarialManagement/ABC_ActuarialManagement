

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PassServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset= UTF-8");
		
		//パスワード変更画面へ
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/pass.jsp");
		rd.forward(request, response);
	}
	
}