package Bean;

import java.sql.Date;

import javax.servlet.http.HttpServlet;

public class KotuBean extends HttpServlet {
	
	private String costId;
	private Date date;
	private String empId;
	private String status;
	
	private String id;
	private String applicationId;
	private String projectId;
	private Date costDate;
	private String getOn;
	private String getOff;
	private String classification;
	private String trafficInstitution;
	private String loads;
	private String receipt;
	private String report;
	private String trafficExpenses;
	
	public String getCostId() {
		return costId;
	}
	public void setCostId(String costId) {
		this.costId = costId;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	public Date getCostDate() {
		return costDate;
	}
	public void setCostDate(Date costDate) {
		this.costDate = costDate;
	}
	
	public String getGetOn() {
		return getOn;
	}
	public void setGetOn(String getOn) {
		this.getOn = getOn;
	}
	
	public String getGetOff() {
		return getOff;
	}
	public void setGetOff(String getOff) {
		this.getOff = getOff;
	}
	
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	public String getTrafficInstitution() {
		return trafficInstitution;
	}
	public void setTrafficInstitution(String trafficInstitution) {
		this.trafficInstitution = trafficInstitution;
	}
	
	public String getLoads() {
		return loads;
	}
	public void setLoads(String loads) {
		this.loads = loads;
	}
	
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	
	public String getTrafficExpenses() {
		return trafficExpenses;
	}
	public void setTrafficExpenses(String trafficExpenses) {
		this.trafficExpenses = trafficExpenses;
	}

}
