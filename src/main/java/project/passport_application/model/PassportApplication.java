package project.passport_application.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class PassportApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	@JsonIgnore
	private String fullName;
	private String address;
	private String identityProof;
	private String certificate;
	private String status; // "Pending", "Police Verification", "Issued"
	private LocalDate applicationDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
//	@JsonManagedReference
	private User user;
	@OneToOne(mappedBy = "passportApplication", cascade = CascadeType.ALL)
//	@JsonManagedReference
	private PoliceVerification policeVerification;
	
	@OneToOne(mappedBy = "passportApplication", cascade = CascadeType.ALL)
//	@JsonManagedReference
	private PostalDispatch postalDispatch;

//     Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdentityProof() {
		return identityProof;
	}

	public void setIdentityProof(String identityProof) {
		this.identityProof = identityProof;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PoliceVerification getPoliceVerification() {
		return policeVerification;
	}

	public void setPoliceVerification(PoliceVerification policeVerification) {
		this.policeVerification = policeVerification;
	}

	public PostalDispatch getPostalDispatch() {
		return postalDispatch;
	}

	public void setPostalDispatch(PostalDispatch postalDispatch) {
		this.postalDispatch = postalDispatch;
	}
}