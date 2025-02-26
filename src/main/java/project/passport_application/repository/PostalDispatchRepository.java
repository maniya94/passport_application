package project.passport_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.passport_application.model.PostalDispatch;

public interface PostalDispatchRepository extends JpaRepository<PostalDispatch, Long> {
}
