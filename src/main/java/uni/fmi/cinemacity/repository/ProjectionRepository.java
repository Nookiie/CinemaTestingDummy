package uni.fmi.cinemacity.repository;

import java.util.ArrayList;

import org.joda.time.DateTime;

import uni.fmi.cinemacity.model.Movie;
import uni.fmi.cinemacity.model.Projection;
import uni.fmi.cinemacity.model.Reservation;

public class ProjectionRepository {
	private ArrayList<Projection> projections = new ArrayList<Projection>();
	
	public ProjectionRepository() {
		
	}

	public ArrayList<Projection> getProjections(){
		return projections;
	}
	
	public Projection getProjectionByID(int id) {
		return projections.stream().filter(Projection -> Projection.getId() == id)
				.findFirst()
				.get();
	}
	
	public boolean existsProjectionByDate(DateTime dateTime) {
		return projections.stream().anyMatch(Projection -> Projection.getStartTime() == dateTime);
	}
	
	public boolean existsProjectionByName(String name) {
		return projections.stream().anyMatch(Projection -> Projection.getName() == name);
	}
	
	public void addProjection(Projection projection) {
		projections.add(projection);
	}
	
	public void addReservation(String name, Movie movie, DateTime startTime, DateTime endTime ) {
		projections.add(new Projection(name, movie, startTime, endTime));
	}
	
	public void removeSchedule(Projection projection) {
		projections.remove(projection);
	}
	
	public void removeScheduleByID(int id) {
		projections.removeIf(Projection -> Projection.getId() == id);
	}
	
	public void updateSchedule(Reservation oldProjection, Projection newProjection) {
		projections.remove(oldProjection);
		projections.add(newProjection);
	}

}
