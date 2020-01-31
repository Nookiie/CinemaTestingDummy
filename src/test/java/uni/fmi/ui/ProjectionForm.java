package uni.fmi.ui;

import uni.fmi.cinemacity.common.ProjectionService;
import uni.fmi.cinemacity.model.Projection;

public class ProjectionForm {
	private ProjectionService projectionService = new ProjectionService();
	private Projection chosenProjection;

	public ProjectionForm() {
		
	}
	
	public void selectProjection(Projection projection) {
			chosenProjection = projection;
	}
	
	public boolean isReservePossible(Projection projection) {
		return projectionService.checkReservationAccessbility(projection);
	}
	
	public String getErrorMessage() {
		return projectionService.getErrorMessage();
	}
	
	public ReservationForm clickCreateReservationButton() {
		return new ReservationForm();
	}
}
