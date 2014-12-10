package pt.memplus.web.models;

public class Doctor extends Person{
	private String speciality;
	
	public Doctor() {
		super();
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
}
