

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.KotuBean;

public class KotuDao extends DBAccess {
	
	//交通費申請履歴の取得
	public ArrayList<KotuBean> getAll() {
		
		ArrayList<KotuBean> list = new ArrayList<KotuBean>();
		
		String sql = "select * from cost";
		
		try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				KotuBean bean = new KotuBean();
				bean.setCostId(rs.getString("cost_id"));
				bean.setDate(rs.getDate("date"));
				bean.setEmpId(rs.getString("emp_id"));
				bean.setStatus(rs.getString("status"));
				list.add(bean);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//交通費申請内容の取得
	public ArrayList<KotuBean> getDetail(String id) {

		ArrayList<KotuBean> list = new ArrayList<KotuBean>();
		
		String sql = "select * from traffic_cost where application_id=?";
		
		try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				KotuBean bean = new KotuBean();
				bean.setId(rs.getString("id"));
				bean.setApplicationId(rs.getString("application_id"));
				bean.setProjectId(rs.getString("project_id"));
				bean.setDate(rs.getDate("date"));
				bean.setGetOn(rs.getString("get_on"));
				bean.setGetOff(rs.getString("get_off"));
				bean.setClassification(rs.getString("classification"));
				bean.setTrafficInstitution(rs.getString("traffic_institution"));
				bean.setLoads(rs.getString("loads"));
				bean.setReceipt(rs.getString("receipt"));
				bean.setReport(rs.getString("report"));
				bean.setTrafficExpenses(rs.getString("traffic_expenses"));
				list.add(bean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	
	//交通費の新規申請
	public void insert(String applicationId, String projectId, String date, String getOn, String getOff, String classification, String trafficInstitution, String loads, String receipt, String report, String trafficExpenses) {
		String sql = "insert into traffic_cost(application_id, project_id, date, get_on, get_off, classification, traffic_institution, loads, receipt, report, traffic_expenses) values (?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, applicationId);
			ps.setString(2, projectId);
			ps.setString(3, date);
			ps.setString(4, getOn);
			ps.setString(5, getOff);
			ps.setString(6, classification);
			ps.setString(7, trafficInstitution);
			ps.setString(8, loads);
			ps.setString(9, receipt);
			ps.setString(10, report);
			ps.setString(11, trafficExpenses);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	
	//	交通費の申請内容の変更
	public void update(String id, String applicationId, String projectId, String date, String getOn, String getOff, String classification, String trafficInstitution, String loads, String receipt, String report, String trafficExpenses) {
		String sql = "update traffic_cost set application_id=?, project_id=?, date=?, get_on=?, get_off=?, classification=?, traffic_institution=?, loads=?, receipt=?, report=?, traffic_expenses=? where id=?" ;

		try {
			connect();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, applicationId);
			ps.setString(2, projectId);
			ps.setString(3, date);
			ps.setString(4, getOn);
			ps.setString(5, getOff);
			ps.setString(6, classification);
			ps.setString(7, trafficInstitution);
			ps.setString(8, loads);
			ps.setString(9, receipt);
			ps.setString(10, report);
			ps.setString(11, trafficExpenses);
			ps.setString(12, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	
	//交通費申請の削除
	public void delete(String id) {
		String sql = "delete from traffic_cost where id=?";
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
