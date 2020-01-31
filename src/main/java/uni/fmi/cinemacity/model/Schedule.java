package uni.fmi.cinemacity.model;

import java.util.*;

import org.joda.time.DateTime;

/**
 * 
 */
public class Schedule extends BaseEntity {
	public Schedule() {
		
	}
	private ArrayList<Projection> projections; 
	private DateTime date;

	public ArrayList<Projection> getProjections() {
		return projections;
	}

	public void setProjection(ArrayList<Projection> projections) {
		this.projections = projections;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

}