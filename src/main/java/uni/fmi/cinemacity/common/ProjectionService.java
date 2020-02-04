package uni.fmi.cinemacity.common;

import uni.fmi.cinemacity.model.Projection;
import uni.fmi.cinemacity.model.Reservation;
import uni.fmi.cinemacity.repository.ProjectionRepository;

public class ProjectionService {
	private ProjectionRepository projectionRepo = new ProjectionRepository();
	private String errorMessage = GlobalConstants.getReservationSuccessString();
	
	public ProjectionService() {
		projectionRepo.addProjection(new Projection());
		projectionRepo.addProjection(new Projection());
		projectionRepo.addProjection(new Projection());
		projectionRepo.addProjection(new Projection());
	}
	
	public void addProjection(Projection projection) {
		projectionRepo.addProjection(projection);
	}
	
	public void existsProjection(Projection projection) {
		projectionRepo.existsProjectionByName(projection.getName());
	}
	
	public boolean checkReservationSeats(Reservation reservation) {
		for(int seat : reservation.getProjection().getBlockedSeats()) {
			for(int chosenSeat : reservation.getChosenSeats()) {
				if(seat == chosenSeat) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean checkReservationAccessbility(Projection projection) {
			if(projection.getSeats() <= projection.getBlockedSeats().size()) {
				errorMessage = GlobalConstants.getReservationFailedNoVacantSeatsString();
				return false;
			}
		
			if(projection.getStartTime().withDurationAdded(1, 1).isBeforeNow()) {
				errorMessage = GlobalConstants.getReservationFailedProjectionLateString();
				return false;
			}
		
			return true;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
