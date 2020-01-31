package uni.fmi.ui;

public class ReservationCheckoutForm {
	private String ccNumber;
	private String ccDate;
	private String ccSecret;
	private String name;
	private boolean isCheckoutValid = false;
	
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
		
	}

	public boolean checkCC() {
		
		isCheckoutValid = true;
		return true;
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
}
