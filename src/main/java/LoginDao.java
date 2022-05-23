

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao extends DBAccess {
	
	//社員番号とパスワードから名前を取得する
	public String getName(String number, String password) {
		String sql = "select name from employee where number = ? and password = ?";
		String name = null;
		ResultSet rs = null;
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, number);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
			name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return name;
	}
	
	//社員番号とパスワードからidを取得する
	public String getId(String number, String password) {
		String sql = "select id from employee where number = ? and password = ?";
		String id = null;
		ResultSet rs = null;
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, number);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
			id = rs.getString("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return id;
	}


}
