package fi.adhocapp.adhocappspringboot.service;

import fi.adhocapp.adhocappspringboot.request.RegisterRequest;
import fi.adhocapp.adhocappspringboot.vo.UserVo;

public interface UserService {
	
	UserVo create(RegisterRequest registerRequest);
}
