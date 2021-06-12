package fi.adhocapp.adhocappspringboot.mapper;

import org.mapstruct.Mapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import fi.adhocapp.adhocappspringboot.entity.User;
import fi.adhocapp.adhocappspringboot.request.RegisterRequest;
import fi.adhocapp.adhocappspringboot.vo.UserVo;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Mapping(source = "email", target = "email")
	@Mapping(source = "password", target = "passwordHash", qualifiedByName = "encodePassword")
	public abstract User toUserEntity(RegisterRequest registerRequest);
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "email", target = "email")
	public abstract UserVo toVo(User user);
	
	@Named("encodePassword")
	public String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}
}
