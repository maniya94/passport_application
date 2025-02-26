package project.passport_application.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import project.passport_application.model.PassportApplication;
import project.passport_application.model.PoliceVerification;
import project.passport_application.model.PostalDispatch;
import project.passport_application.repository.PassportApplicationRepository;
import project.passport_application.repository.PoliceVerificationRepository;
import project.passport_application.repository.PostalDispatchRepository;

@Service
public class PassportService {

	@Autowired
	private PassportApplicationRepository passportApplicationRepository;
	@Autowired
	private PoliceVerificationRepository policeVerificationRepository;
	@Autowired
	private PostalDispatchRepository postalDispatchRepository;

	public PassportApplication applyForPassport(PassportApplication passportApplication) {
		passportApplication.setApplicationDate(LocalDate.now());
		passportApplication.setStatus("Pending");
		return passportApplicationRepository.save(passportApplication);
	}

	public PoliceVerification verifyPolice(PassportApplication passportApplication) {
	
//	    if (passportApplication == null || passportApplication.getId() == null) {
//	        throw new IllegalArgumentException("Invalid passport application");
//	    }

	    PoliceVerification policeVerification = new PoliceVerification();
	    policeVerification.setPassportApplication(passportApplication);
	    policeVerification.setStatus("Pending");  
	    policeVerification.setVerificationDate(LocalDate.now()); 
	    
	    return policeVerificationRepository.save(policeVerification);
	}

	public PostalDispatch dispatchPassport(PassportApplication passportApplication) {
		PostalDispatch postalDispatch = new PostalDispatch();
		try {
			postalDispatch.setPassportApplication(passportApplication);
			postalDispatch.setDispatchDate(LocalDate.now());
			// Generate tracking number to do non sequentail
			postalDispatch.setTrackingNumber("TRACK123456");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return postalDispatchRepository.save(postalDispatch);
	}

	public void renewPassport(PassportApplication passportApplication) {
		try {
			passportApplication.setStatus("Renewed");
			passportApplicationRepository.save(passportApplication);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error in renew" + passportApplication);
		}
		passportApplicationRepository.save(passportApplication);
	}

//	public Optional<PassportApplication> getUserById(Long userId) {
//		return passportApplicationRepository.findById(userId);
//	}

	public List<PassportApplication> getAllUsers() {
		return passportApplicationRepository.findAll();
	}

	public void deleteUsers(Long id) {
		passportApplicationRepository.deleteById(id);
	}

	public void deleteAllUsers() {
		passportApplicationRepository.deleteAll();
	}

	public Optional<PassportApplication> getUserApplications(Long userId) {
		// TODO Auto-generated method stub
		return passportApplicationRepository.findById(userId);
	}
}
