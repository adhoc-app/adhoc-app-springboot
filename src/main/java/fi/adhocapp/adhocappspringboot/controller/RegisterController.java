package fi.adhocapp.adhocappspringboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.adhocapp.adhocappspringboot.request.RegisterRequest;
import fi.adhocapp.adhocappspringboot.service.UserService;
import fi.adhocapp.adhocappspringboot.vo.UserVo;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/register")
public class RegisterController {

	private final UserService userService;

	@Autowired
	public RegisterController(final UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
		// TODO: user request validation

		// TODO: verify captcha

		// create user
		UserVo user = userService.create(registerRequest);
		return ResponseEntity.ok(user);
	}

}
