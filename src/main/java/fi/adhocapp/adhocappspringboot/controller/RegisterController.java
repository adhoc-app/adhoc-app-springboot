package fi.adhocapp.adhocappspringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/register")
public class RegisterController {
	
	@PostMapping
	public ResponseEntity<?> registerUser() {
		String response = "Chao em!";
				
		return ResponseEntity.ok(response);
	}

}
