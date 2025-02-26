package project.passport_application.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class PoliceVerification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String status; // "Completed", "Pending", "Rejected"
	private LocalDate verificationDate;

	@OneToOne(cascade = CascadeType.ALL)
//	@OneToOne()
	@JoinColumn(name = "passport_application_id")
	  @JsonBackReference
	private PassportApplication passportApplication;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getVerificationDate() {
		return verificationDate;
	}

	public void setVerificationDate(LocalDate verificationDate) {
		this.verificationDate = verificationDate;
	}

	public PassportApplication getPassportApplication() {
		return passportApplication;
	}

	public void setPassportApplication(PassportApplication passportApplication) {
		this.passportApplication = passportApplication;
	}

}