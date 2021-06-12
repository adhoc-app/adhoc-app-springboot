package fi.adhocapp.adhocappspringboot.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fi.adhocapp.adhocappspringboot.entity.User;
import fi.adhocapp.adhocappspringboot.mapper.UserMapper;
import fi.adhocapp.adhocappspringboot.repository.UserRepository;
import fi.adhocapp.adhocappspringboot.request.RegisterRequest;
import fi.adhocapp.adhocappspringboot.service.UserService;
import fi.adhocapp.adhocappspringboot.vo.UserVo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;
	
	@Autowired
	public UserServiceImpl(final UserRepository userRepository, final UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public UserVo create(RegisterRequest registerRequest) {
		// create User
		User user = userMapper.toUserEntity(registerRequest); 
		user = userRepository.saveAndFlush(user);
		
		entityManager.refresh(user);
		// convert to UserVo
		UserVo userVo = userMapper.toVo(user);
		
		return userVo;
	}

}
