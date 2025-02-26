package project.passport_application.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.passport_application.model.PassportApplication;


public interface UserRepository extends JpaRepository<PassportApplication, Long> {
    List<PassportApplication> findByUserId(Long userId);
}