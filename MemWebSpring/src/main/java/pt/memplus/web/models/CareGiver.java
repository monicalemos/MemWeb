package pt.memplus.web.models;

public class CareGiver extends Person {
	private boolean caregiver;
	
	public CareGiver() {
		super();
	}

	public boolean isCaregiver() {
		return caregiver;
	}

	public void setCaregiver(boolean caregiver) {
		this.caregiver = caregiver;
	}

}
