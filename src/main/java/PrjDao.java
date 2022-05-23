import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.PrjBean;

public class PrjDao extends DBAccess {
	
	//プロジェクト一覧の取得
	public ArrayList<PrjBean> getAll() {

		ArrayList<PrjBean> list = new ArrayList<PrjBean>();
		
		String sql = "select * from project";
		
		try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				PrjBean bean = new PrjBean();
				bean.setId(rs.getString("id"));
				bean.setProjectCode(rs.getString("project_code"));
				bean.setSupliers(rs.getString("supliers"));
				bean.setDescription(rs.getString("description"));
				bean.setStartDate(rs.getDate("start_date"));
				bean.setEndDate(rs.getDate("end_date"));
				list.add(bean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	
	//プロジェクトの新規登録
	public void insert(String projectCode, String supliers, String description, String startDate, String endDate) {
		String sql = "insert into project(project_code,supliers,description,start_date,end_date) values (?,?,?,?,?)";
		
		try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, projectCode);
			ps.setString(2, supliers);
			ps.setString(3, description);
			ps.setString(4, startDate);
			ps.setString(5, endDate);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	
	//プロジェクトの変更
	public void update(String id, String projectCode, String supliers, String description, String startDate, String endDate) {
		String sql = "update project set project_code=?, supliers=?, description=?, start_date=?, end_date=? where id=?" ;

		try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, projectCode);
			ps.setString(2, supliers);
			ps.setString(3, description);
			ps.setString(4, startDate);
			ps.setString(5, endDate);
			ps.setString(6, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	
	//プロジェクトの削除
	public void delete(String id) {
		String sql = "delete from project where id=?";

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
	
	
	//PRJCDの取得
	public ArrayList<PrjBean> getPrjcd() {

		ArrayList<PrjBean> list = new ArrayList<PrjBean>();
		
		String sql = "select * from project";
		
		try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				PrjBean bean = new PrjBean();
				bean.setProjectCode(rs.getString("project_code"));
				list.add(bean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
}