package pt.memplus.web.model.repository;

import pt.memplus.web.model.repository.memory.DoctorRepository;
import pt.memplus.web.model.repository.memory.PacientRepository;
import pt.memplus.web.model.repository.memory.TechnitianRepository;
import pt.memplus.web.models.Doctor;
import pt.memplus.web.models.Patient;
import pt.memplus.web.models.Technician;

public class DataRepositoryLocator {
	private static final IRepository<Patient> pacientRepository = new PacientRepository();
	private static final IRepository<Doctor> doctorRepository = new DoctorRepository();
	private static final IRepository<Technician> technitianRepository = new TechnitianRepository();
	
	
	public static IRepository<Patient> getPacientrepository() {
		return pacientRepository;
	}
	public static IRepository<Doctor> getDoctorrepository() {
		return doctorRepository;
	}
	public static IRepository<Technician> getTechnitianrepository() {
		return technitianRepository;
	}
	

}
