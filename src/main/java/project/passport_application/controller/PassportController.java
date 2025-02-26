package project.passport_application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.passport_application.model.PassportApplication;

@RestController
@RequestMapping("/passport")
public class PassportController {

	@Autowired
	private project.passport_application.service.PassportService passportService;

	@PostMapping(value="/apply",consumes = MediaType.APPLICATION_JSON_VALUE )
	public PassportApplication applyForPassport(@RequestBody PassportApplication passportApplication) {
		return passportService.applyForPassport(passportApplication);
	}

	@PostMapping(value="/verify",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void verifyPolice(@RequestBody PassportApplication passportApplication) {
		passportService.verifyPolice(passportApplication);
	}

	@PostMapping(value="/dispatch",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void dispatchPassport(@RequestBody PassportApplication passportApplication) {
		passportService.dispatchPassport(passportApplication);
	}

	@PostMapping(value="/renew",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void renewPassport(@RequestBody PassportApplication passportApplication) {
		passportService.renewPassport(passportApplication);

	}
	@GetMapping(value="/applications/{userId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Optional<PassportApplication> getUserApplications(@PathVariable Long userId) {
        return passportService.getUserApplications(userId);
    }
//	@GetMapping("/{userId}")
//	public Optional<PassportApplication> getUserById(@PathVariable Long userId) {
////        Optional<PassportApplication> user = passportService.getUserById(id);
//		return passportService.getUserById(userId);
//	}

	@GetMapping(value="/allUser",consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<PassportApplication> getAllUsers() {
		return passportService.getAllUsers();
	}

	@DeleteMapping(value="/delete/{userId}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<PassportApplication> deleteUser(@PathVariable Long userId) {
		passportService.deleteUsers(userId);
		return passportService.getAllUsers();
	}

	@DeleteMapping(value="/deleteAll",consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<PassportApplication> deleteAllUsers() {
		passportService.deleteAllUsers();
		return passportService.getAllUsers();
	}

}
