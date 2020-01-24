package uni.fmi.cinemacity.model;

import java.util.*;

import org.joda.time.DateTime;

/**
 * 
 */
public class Schedule extends BaseEntity {
	public Schedule() {
		
	}
	private List<Projection> projections; 
	private DateTime date;

	public List<Projection> getProjections() {
		return projections;
	}

	public void setProjection(List<Projection> projections) {
		this.projections = projections;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

}