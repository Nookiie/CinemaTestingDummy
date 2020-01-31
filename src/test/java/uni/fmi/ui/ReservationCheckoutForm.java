package uni.fmi.ui;

import uni.fmi.cinemacity.model.Reservation;

public class ReservationCheckoutForm {
	private String ccNumber;
	private String ccDate;
	private String ccSecret;
	private String name;
	private boolean isCheckoutValid = false;
	private String errorMessage;
	
	public void addName(String name) {
		this.name = name;
	}
	
	public void addCCNumber(String ccNumber) {
		this.ccNumber =  ccNumber;
	}
	
	public void addCCDate(String ccDate) {
		this.ccDate = ccDate;
	}
	
	public void addCCSecret(String ccSecret) {
		this.ccSecret = ccSecret;
	}

	public void clickCompleteTransactionButton() {
		if(checkCC()) {
			sendCheckoutComplete();
		}
	}

	public boolean checkCC() {
		// We don't have any advanced API CC DB like Paypal or Nexmo so this will have to do for now
		
		boolean isCCNumberValid = ((ccNumber != null) && (ccNumber != ""));
		boolean isCCDateValid = ((ccDate != null) && (ccDate != "")) ;
		boolean isCCSecretValid = ((ccSecret != null) && (ccSecret != ""));
		boolean isNameValid = (name != null) && (name != "");
		
		if(isCCNumberValid && isCCDateValid && isCCSecretValid && isNameValid) {
			isCheckoutValid = true;
			return true;
		}
		
		return false;
	}
	
	public boolean getCheckoutComplete() {
		return isCheckoutValid;
	}
	
	public void sendCheckoutComplete() {
		if(checkCC()) {
			isCheckoutValid = true;
		}
	}

	public boolean makeTransaction() {
		if(isCheckoutValid) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setErrorMessage(String message) {
		this.errorMessage =message; 
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}

