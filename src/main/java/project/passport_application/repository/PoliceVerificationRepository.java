package project.passport_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import project.passport_application.model.PoliceVerification;
import project.passport_application.model.PostalDispatch;



public interface PoliceVerificationRepository extends CrudRepository<PostalDispatch, Long> {

	PoliceVerification save(PoliceVerification policeVerification);

}