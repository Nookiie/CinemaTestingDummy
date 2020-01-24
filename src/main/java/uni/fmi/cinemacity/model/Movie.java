package uni.fmi.cinemacity.model;

import org.joda.time.DateTime;

/**
 * 
 */
public class Movie extends BaseEntity {
	
	private String name;
	private String company;
	private DateTime dateOfRelease;

	public Movie() {
		
	}
	
	public Movie(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public DateTime getDateOfRelease() {
		return dateOfRelease;
	}

	public void setDateOfRelease(DateTime dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}

}