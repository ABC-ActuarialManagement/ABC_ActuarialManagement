

import java.sql.PreparedStatement;

public class PassDao extends DBAccess {
	
	public void updatePass(String id, String pass) {
		
		String sql = "update employee set password=? where employee_id=?";
	
		try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, pass);
			ps.setString(2, id);
			ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	
}
