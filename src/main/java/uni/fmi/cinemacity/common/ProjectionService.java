package uni.fmi.cinemacity.common;

import uni.fmi.cinemacity.model.Projection;
import uni.fmi.cinemacity.repository.ProjectionRepository;

public class ProjectionService {
	private ProjectionRepository projectionRepo = new ProjectionRepository();
	private String errorMessage;
	
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

	public boolean checkReservationAccessbility(Projection projection) {
		
			if(projection.getSeats() <= projection.getBlockedSeats()) {
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
