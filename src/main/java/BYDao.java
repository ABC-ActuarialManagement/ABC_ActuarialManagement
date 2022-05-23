

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.BYBean;

public class BYDao extends DBAccess {
	
	//部署一覧の取得
	public ArrayList<BYBean> getAllB() {

		ArrayList<BYBean> list = new ArrayList<BYBean>();
		
		String sql = "select * from department";
		
		try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				BYBean bean = new BYBean();
				bean.setId(rs.getString("id"));
				bean.setDepartment(rs.getString("department"));
				bean.setDivision(rs.getString("division"));
				list.add(bean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
		
	//役職一覧の取得
	public ArrayList<BYBean> getAllY() {

		ArrayList<BYBean> list = new ArrayList<BYBean>();
		
		String sql = "select * from position";
		
		try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
	
			while (rs.next()) {
				BYBean bean = new BYBean();
				bean.setId(rs.getString("id"));
				bean.setPosition(rs.getString("position"));
				list.add(bean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	
	//部署の新規登録
	public void insertB(String department, String division) {
		String sql = "insert into department(department, division) values (?,?)";
		
		try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, department);
			ps.setString(2, division);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	
	//役職の新規登録
	public void insertY(String position) {
		String sql = "insert into position (position) values (?)";
		
		try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, position);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	
	//	部署の変更
	public void updateB(String id, String department, String division) {
		String sql = "update department set department=?, division=? where id=?" ;

		try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, department);
			ps.setString(2, division);
			ps.setString(3, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	
	//	役職の変更
	public void updateY(String id, String position) {
		String sql = "update position set position=? where id=?" ;

		try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, position);
			ps.setString(2, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	
	//部署の削除
	public void deleteB(String id) {
		String sql = "delete from department where id=?";
			try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	
	//役職の削除
		public void deleteY(String id) {
			String sql = "delete from position where id=?";
				try {
				connect();
				
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, id);
				ps.executeUpdate();
				
				} catch (Exception e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
	
}
