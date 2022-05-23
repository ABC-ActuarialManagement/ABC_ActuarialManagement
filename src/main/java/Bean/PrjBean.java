package Bean;

import java.io.Serializable;
import java.sql.Date;

public class PrjBean implements Serializable {
	
	private String id;
	private String projectCode;
	private String supliers;
	private String description;
	private Date startDate;
	private Date endDate;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	public String getSupliers() {
		return supliers;
	}

	public void setSupliers(String supliers) {
		this.supliers = supliers;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
