package project.passport_application.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class PostalDispatch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String trackingNumber;
	private LocalDate dispatchDate;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "passport_application_id")
	  @JsonBackReference
	private PassportApplication passportApplication;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public LocalDate getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public PassportApplication getPassportApplication() {
		return passportApplication;
	}

	public void setPassportApplication(PassportApplication passportApplication) {
		this.passportApplication = passportApplication;
	}

}